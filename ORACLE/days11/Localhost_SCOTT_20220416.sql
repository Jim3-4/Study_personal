
1.  truncate / delete / drop 대해서 설명하세요
truncate 테이블 삭제, 자동커밋 롤백불가
delete 테이블데이터삭제, where 조건문이 없으면 전체데이터를 삭제
drop 테이블 자체를 삭제 

2.  insert 문 수행 중 다음과 같은 오류가 발생했다면 이유에 대해 설명하세요
  ㄱ. 00947. 00000 -  "not enough values" 
   insert into 테이블명(칼럼명 갯수) values (칼럼명 ) 
   충분한 값이 아니다. 
  ㄴ. ORA-00001: unique constraint (SCOTT.SYS_C007770) violated  고유키위배  
  ㄷ. ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
   부모키를 찾을 수 없음 
3. 서브쿼리를 사용해서 테이블 생성
  ㄱ. deptno, dname, empno, ename, sal+nvl(comm,0) pay, grade 컬럼을 가진 새로운 테이블 생성
  ㄴ. 테이블명 : tbl_empdeptgrade   

create table tbl_empdeptgrade
as(
    select deptno, dnam, empno, ename, sal+nvl(comm,0) pay, grade
    from dept d join emp e on d.deptno=e.deptno
            join salgrade s on e.,sal between s.losal and s.hisal 
);

4-1. insa 테이블에서 num, name 가져와서 tbl_score 테이블 생성
create table tbl_score
as(
    select num,name
    from insa
);

4-2. kor, eng, mat, tot          , avg , grade, rank 컬럼 추가
alter table tbl_score
add(
    kor number(3) default 0
    ,ent numbe(3) default 0
    ,mat number(3) default 0
    ,tot number(3) 
    ,avg number(5,2)
    ,grade char(1 char)
    ,rank number 
);

4-3. 각 학생들의 kor,eng,mat 점수 0~100 랜덤하게 채워넣기.
update tbl_score
set kor=trunc(dbms_random.value(0,101)),
    eng=trunc(dbms_random.value(0,101)),
    mat=trunc(dbms_random.value(0,101));

4-4. 총점, 평균, 등급, 등수 수정
    조건)
     등급은 모든 과목이 40점이상이고, 평균 60 이상이면 "합격"
           평균 60 이상이라도 한 과목이라 40점 미만이라면  "과락"
           그외는 "불합격" 이라고 저장.
       update tbl_score
       set avg= (kor+eng+mat)/3  
       ,grade= case
                when kor>=40 and eng>=40 and mat >=40 and avg>=60 then '합격'
                when kor<=40 or eng<=40 or mat <=40 and avg>=60then '과락'
                else '불합격 ' 
                end;
5.  emp 테이블의 구조를 확인하고, 제약조건을 확인하고, 임의의 사원 정보를 추가하는 INSERT 문을 작성하세요.
   ㄱ. 구조확인 쿼리  desc emp;
   ㄴ. 제약조건 확인 쿼리
   select *
   from tabs;
   from user_constriants;
   from user_tables;
   where table_name=upper('emp');
   ㄷ. INSERT 쿼리 
    insert into emp values('값들' );
6-1. emp 테이블의 구조만 복사해서 새로운 tbl_emp10, tbl_emp20, tbl_emp30, tbl_emp40 테이블을 생성하세요. 
create table tbl_emp10 as select * from emp where 1=0 ; 
create table tbl_emp20 as select * from emp where 1=0 ; 
create table tbl_emp30 as select * from emp where 1=0 ; 
create table tbl_emp40 as select * from emp where 1=0 ; 
6-2. emp 테이블의 각 부서에 해당하는 사원정보를  위에서 생성한 테이블에 INSERT 하는 쿼리를 작성하세요.   
insert first
    when deptno=10 then 
    into emp_10 values(emp,ename, job,mgr, hiredate ,sal, comm, deptno)
    when deptno=20 then 
    into emp_20 values(emp,ename, job,mgr, hiredate ,sal, comm, deptno)
    when deptno=30 then 
    into emp_30 values(emp,ename, job,mgr, hiredate ,sal, comm, deptno)
    when deptno=40 then 
    into emp_40 values(emp,ename, job,mgr, hiredate ,sal, comm, deptno)
select * from emp ; 

7. 조건이 있는 다중 INSERT 문에서  INSERT ALL 과 INSERT FIRST 문에 대한 차이점을 설명하세요.
insert first는 맞는 조건 하나 만나면, 그다음 조건문은 실행하지않음 

여자학생들만 영어점수5점추가 

UPDATE tbl_score
SET eng = eng + 5
--           1003 , 1005
WHERE num = ANY ( --하나라도 만족하는 값이 있으면 결과를 리턴 
    SELECT num 
    FROM insa
    WHERE MOD(SUBSTR(ssn, -7, 1), 2) = 0 AND num <= 1005
);--1005번보다 작은 여자학생중 여자만 데려와서 


-- 달력그리기
level 의사칼럼 

select :yyyymm
from dual;

select dates 
,to_char(dates,'d')d
,to_char(dates,'dy')dy
,to_char(dates,'day')day
,to_char(dates,'iw')iw
,case
--일요일이라면 1을 더하겠다 달력에 보면 일요일부터 새로운 주이기에 
    when to_char (dates, 'd')=1 then to_char(dates, 'iw')+1
    else to_number(to_char(dates,'iw'))

    end "iw2"
,to_char(dates,'ww')ww
,to_char(dates,'w')w --해당 달의 1~7일은 한주   
from(
select to_date(:yyyymm,'yyyymm')+level-1 dates  -- -1을 안넣으면 2일 부터 출력 
from dual
--to_char로 하니까 오류떠서 extract 으로 바꿈 
connect by level<=extract(day from last_day(to_date(:yyyymm,'yyyymm')))
)t

-----------------------------
-------------------------------------------------------- KENIK -------------------------------
SELECT 
      NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  일
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  월
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  화
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  수
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  목
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  금
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  토
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE 
               -- IW 가 50주 넘으면서 "일요일"
             WHEN TO_CHAR(dates, 'MM') = 1 AND  TO_CHAR(dates, 'D') = '1' AND TO_CHAR( dates, 'IW') > '50' THEN 1
             WHEN TO_CHAR(dates, 'MM') = 1 AND TO_CHAR(dates, 'D') != '1' AND TO_CHAR( dates, 'IW') > '50' THEN 0  
             WHEN TO_CHAR( dates , 'D') = 1 THEN TO_CHAR( dates , 'IW') + 1
             ELSE TO_NUMBER( TO_CHAR( dates , 'IW') )
          END   
ORDER BY   
         CASE 
             WHEN TO_CHAR(dates, 'MM') = 1 AND  TO_CHAR(dates, 'D') = '1' AND TO_CHAR( dates, 'IW') > '50' THEN 1
             WHEN TO_CHAR(dates, 'MM') = 1 AND TO_CHAR(dates, 'D') != '1' AND TO_CHAR( dates, 'IW') > '50' THEN 0  
             WHEN TO_CHAR( dates , 'D') = 1 THEN TO_CHAR( dates , 'IW') + 1
             ELSE TO_NUMBER( TO_CHAR( dates , 'IW') )
            END      ;  
            

SELECT 
      NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  일
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  월
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  화
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  수
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  목
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  금
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  토
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE
            WHEN TO_CHAR( dates, 'D' ) < TO_CHAR( TO_DATE( :yyyymm,'YYYYMM' ), 'D' ) THEN TO_CHAR( dates, 'W' ) + 1
            ELSE TO_NUMBER( TO_CHAR( dates, 'W' ) )
        END
ORDER BY CASE
            WHEN TO_CHAR( dates, 'D' ) < TO_CHAR( TO_DATE( :yyyymm,'YYYYMM' ), 'D' ) THEN TO_CHAR( dates, 'W' ) + 1
            ELSE TO_NUMBER( TO_CHAR( dates, 'W' ) )
        END;
        
select empno, ename, mgr , level
from emp
--startwith -> 최상위노드 mgr 없는 사원 
start with  mgr is null 
connect by prior empno=mgr; --자식을 왼쪽 부모를 오른쪽 


select lpad(' ',3*level-3) || ename
,empno,mgr,level
,sys_connect_by_path(ename,'/')path
,connect_by_root ename root_node --최상의 루트노드 
,connect_by_isleaf 
from emp
start with mgr is null
connect by prior empno=mgr;


create table tbl_level(
    deptno number(3) not null primary key,
    dname varchar2(20) not null,
    college number(3),
    loc varchar2(10));

 select * 
 from tbl_level;
 
 alter table tbl_level
 modify dname varchar2(30);
 
 desc tbl_level;
 
 insert into tbl_level ( deptno, dname, college, loc ) values ( 10,'공과대학', null , null);
insert into tbl_level ( deptno, dname, college, loc ) values ( 100,'정보미디어학부',10, null );
insert into tbl_level ( deptno, dname, college, loc ) values ( 101,'컴퓨터공학과',100,'1호관');
insert into tbl_level ( deptno, dname, college, loc ) values ( 102,'멀티미디어학과',100,'2호관');
insert into tbl_level ( deptno, dname, college, loc ) values ( 200,'메카트로닉스학부', 10,null);
insert into tbl_level ( deptno, dname, college, loc ) values ( 201,'전자공학과',200,'3호관');
 insert into tbl_level ( deptno, dname, college, loc ) values ( 202,'기계공학과',200,'4호관');
    
--7개 들어간거 보고 커밋 
commit;

select deptno, dname, college, level
from tbl_level
start with deptno=10
connect by prior deptno=college;   --자식키=부모키 ;  --top-down 방식



SELECT LPAD(' ', (LEVEL-1)*2) || dname 조직도
    FROM tbl_level
    START WITH deptno=10
    CONNECT BY PRIOR deptno=college;
    
SELECT LPAD(' ', (LEVEL-1)*2) || dname 조직도
,deptno, college,level
    FROM tbl_level
   -- where dname!='정보미디어학부'
    START WITH deptno=10
    CONNECT BY PRIOR deptno=college and dname!='정보미디어학부';
    
    select *
    from tbl_emp;
    
    create table tbl_emp(
    id number primary key, 
    name varchar2(10) not null,
    salary  number,
    bonus number default 100);


insert into tbl_emp(id,name,salary) values(1001,'jijoe',150);
insert into tbl_emp(id,name,salary) values(1002,'cho',130);
insert into tbl_emp(id,name,salary) values(1003,'kim',140);

create table tbl_bonus(
    id number
    ,bonus number default 100
);

    select *  from tbl_bonus;
insert into tbl_bonus values(1001,100);
insert into tbl_bonus values(1002,100);
insert into tbl_bonus values(1003,100);
insert into tbl_bonus values(1004,50);

병함->tbl_emp ->tbl_bonus
merge  into tbl_bonus b
using ( select id, salary from tbl_emp)e
on (b.id=e.id)
when matched then --update
    update set b.bonus= b.bonus+e.salary*0.01
when not matched then --insdert 
    insert (b.id, b.bonus) values (e.id, e.salary*0.01);
    
----------------------------------------------------------------
    CREATE TABLE tbl_merge1
(
   id number primary key
   , name varchar2(20)
   , pay number
   , sudang number
);

CREATE TABLE tbl_merge2
(
   id number primary key 
   , sudang number
);

INSERT INTO TBL_merge1 (id, name, pay, sudang) VALUES (1, 'a', 100, 10);
INSERT INTO TBL_merge1 (id, name, pay, sudang) VALUES (2, 'b', 150, 20);
INSERT INTO TBL_merge1 (id, name, pay, sudang) VALUES (3, 'c', 130, 0);
    
INSERT INTO TBL_merge2 (id, sudang) VALUES (2,5);
INSERT INTO TBL_merge2 (id, sudang) VALUES (3,10);
INSERT INTO TBL_merge2(id, sudang) VALUES (4,20);

COMMIT;

select * from tbl_merge1; 
select * from tbl_merge2;

merge into tbl_merge2 t2
using (select id, sudang from tbl_merge1 )t1
on(t1.id=t2.id )
when matched then  --일치하면 update 
    update set t2.sudang=t2.sudang+t1.sudang
when not matched then --일치하지 않으면 insert 
    insert (t2.id, t2.sudang) values (t1.id, t1.sudang);
    
    
select *
from user_Constraints
where table_name=upper('emp');


ㄱ.테이블에 레코드(행)을 추가, 수정 ,삭제할때 적용되는 규칙

ㄴ.테이블의 삭제 방지를 위해서도 제약조건을 사용한다.
dept(deptno pk) --emp(deptno pk) 
delete from dept
where deptno=30;
오류 보고 -
ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found

ㄷ.데이터무결성 
? 1) 개체 무결성(Entity Integrity)
릴레이션에 저장되는 튜플(tuple)의 유일성을 보장하기 위한 제약조건이다. ==pk 고유키 

? 2) 참조 무결성(Relational Integrity)
외래 키는 반드시 참조 키의 값과 일치하거나 null을 가져야 한다.
update emp
set deptno=90 --dept테이블에서는 90번 부서가 존재하지 않기 때문에 
where empno=7369;
delete from dept
where deptno=30
오류 보고 -
ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found

? 3) 도메인 무결성(domain integrity)
릴레이션 (테이블)간의 데이터의 일관성을 보장하기 위한 제약조건이다 
kor number(3) not null default 0
도메인에 벗어나면 체크 
데이터가 허가되지 않는 값으로 추가, 수정 ,삭제 제한하는 특성 

주민등록번호 
rrn char(14) insert into 테이블명 (rrn) values ('123') ;

제약조건을 사용하는 이유 ? dml할 때 잘못 조작되는 것을 방지하기 위해서 
dml= insert, update, delete

제약조건을 선언 하는 방법 
ㄱ. create table 테이블 생성
ㄴ.alter table 테이블 수정 ㄹ

각행을 식별할 수 있는 속성 

제약조건의 종류 5가지 
ㄱ.primary key 제약조건 (고유키 pk)
ㄴ.foreign key 제약조건 (외래키, 참조키 fk)
ㄷ. not null 제약조건 nn 
ㄹ.unique 제약조건 (유일성 uk)
ㅁ. check 제약조건 (ck) 
    -칼럼레벨 - in line 제약조건 방법
    -테이블레벨 - out of line 제약조건 방법

--제약조건 x
create table tbl_constraint
(
    empno number(4) not null
    ,ename varchar2(20) not null
    ,deptno number(2) not null
    ,kor number(3)
    ,email varchar2(20)
    ,city varchar2(20) --서울 부산 대구 대전 
);

insert into tbl_constraint (empno, ename, deptno,kor, email,city) values
(1111,'admin',10,null,null,null);

insert into tbl_constraint (empno, ename, deptno,kor, email,city) values
(1111,'hong',20,null,null,null);

select *from tbl_constraint;

drop table tbl_constraint;
rollback;

select *
from tbl_column_level;

--칼럼레벨 방식으로 제약조건 설정 
create table tbl_column_level
(
    empno number(4) not null constraint pk_tblcolumn_pk primary key
    ,ename varchar2(20) not null 
    ,deptno number(2) not null constraint fk_tblcolumnlevel_deptno references dept(deptno)
    ,kor number(3) constraint ck_tblcolumnlevel_kor check(kor between 0 and 100)
    ,email varchar2(20) constraint uk_tblcolumn_email unique 
    ,city varchar2(20) constraint ck_tblcolumnlevel_city check(city in ('서울','부산','대구','대전'))
);
테이블 레벨 방식으로 제약조건 설정 
not null x 
create table tbl_table_level(
     empno number(4) 
    ,ename varchar2(20)
    ,deptno number(2)   
    ,kor number(3)
    ,email varchar2(20)
    ,city varchar2(20)    
    --pk 제약조건 설정 
,not null constraint pk_tbltable_pk primary key(empno)
,not null constraint fk_tbltable__deptno foreign key(deptno) references dept(deptno)  
,constraint uk_tbltable__email unique (email) 
,constraint ck_tbltable__kor check(kor between 0 and 100)
,constraint ck_tbltable__city check(city in ('서울','부산','대구','대전'))
);


insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('1111', 'admin',20,90,'admin@naver.com','서울');

insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('2222', 'admin',50,50,'admin@naver.com','서울');


--체크제약조건위배, 도메인에 들어가지 않음  kor과 city 
insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('2222', 'admin',50, 111,'admin@naver.com','포항');

--not null 제약조건에 위배 
insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('3333',null,50, 111,'admin@naver.com','포항');

--제약조건확인
select *
from user_constriants
where table_name =upper('tbl_table_level');

--제약조건 변경
-- alter table로 변경가능하다 

alter table 테이블명 
drop constraint constraint명 primary|unique

alter table 테이블명
drop primary key;

alter table 테이블명
drop constraint pk_tablelevel_empno;


alter table 테이블명 
add constraint pk_tbltable_level_empno primary key; 

문제 1. 제약조건을 확인하고 모든 ck 삭제 (제거) tbl_table_level 테이블에서 

select *
from user_constraints
where table_name='tbl_table_level';
 
alter table tbl_table_level
drop constraint 제약조건명 ; 

문제 kor 컬럼은 nn 제약조건 설정이 안되어잇다. 
alter table tbl_table_level
add constraint 제약조건명 check (kor is not null)
또는 
alter table tbl_table_level
modify kor is not null 

제약조건 활성화/비활성화 ==삭제/추가

alter table 테이블명
enable constriant 제약조건명

alter table 테이블명
disalbe constraint 제약조건명 (cascade) ;


emp- 복사해서 -> tbl_emp 생성 
dept-  복사 ->tbl_dept
drop table tbl_emp ;


create table tbl_emp as(
select *
from emp 
);

create table tbl_dept
as(
select *
from dept
);

2) 제약조건 확인 
not null을 제외한 제약조건은 복사되지 않는다 

select * 
from user_constriants
where table_name='tbl_emp';

3)제약조건 pk 추가 empno , deptno 

alter table tbl_emp 
add constraint tbl_emp_pk primary key(empno);


alter table tbl_dept
add constraint pk_tbldept_deptno primary key(deptno);

4)tbl_dept(deptno pk) -> tbl_emp(deptno) 참조키 fk 설정 

alter table deptno
add constraint fk_tbldept_deptno foreign key(deptno) references tbl_dept(deptno);

select * from tbl_emp;
select * from tbl_dept; 

delete from tbl_dept
where deptno=30;

tbl_emp테이블에 30번 부서원들도 같이 삭제 시키고 싶다
on delete cascade 옵션 

fk_table_deptno 제약조건 삭제 
alter table tbl_emp
drop constraint fk_table_deptno;

fk제약조건을 다시추기ㅐ 
alter table tbl_emp
add constraint fk_table_deptno foreign key(deptno) references tbl_dept(deptno) on delete cascade;

--레코드를 삭제하는 것이 아니고 null값으로 설정 
alter table tbl_emp
add constraint fk_table_deptno foreign key(deptno) references tbl_dept(deptno) on delete set null;

delete from tbl_dept
where deptno=30; 

select * from tbl_dept;
select * from tbl_emp ;

rollback;

조인- 같거나 서로 다른 두개 이상의 테이블에서 칼럼을 검색 하기 위해서 사용한다. 


셀프조인 
? 한 개의 테이블을 두 개의 테이블처럼 사용하기 위해 테이블 별명을 사용하여 한 테이블을 자체적으로 JOIN하여 사용한다.
? SELF JOIN은 테이블이 자신의 특정 컬럼을 참조하는 또 다른 하나의 컬럼을 가지고 있는 경우에 사용한다.

【형식】
	SELECT alias1.컬럼명, alias2.컬럼명
	FROM 같은테이블 alais1, 같은테이블 alais2
	WHERE alias1.컬럼1명=alais2.컬럼2명;

【형식】
	SELECT alias1.컬럼명, alias2.컬럼명
	FROM 같은테이블 alais1 JOIN 같은테이블 alais2
		ON alias1.컬럼1명=alais2.컬럼2명;

문제)사원번호/사원명/부서명 조회 + 직속상사(매니저) 사원명 
select a.empno,a.ename, a.deptno , a.mgr, b.ename
from emp a, emp b
where a.mgr=b.empno;

select a.empno,a.ename, a.deptno , a.mgr, b.ename
from emp a join emp b on a.mgr=b.empno;


부서명까지 알고싶을때 
select a.empno,a.ename, a.deptno , a.mgr, b.ename, dname
from emp a, emp b, dept d
where a.mgr=b.empno and a.deptno=d.deptno;


select a.empno,a.ename, a.deptno , a.mgr, b.ename, dname
from emp a join emp b on a.mgr=b.empno join dept d on a.deptno=d.deptno;