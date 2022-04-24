
1. 이번 달 1일 부터 마지막 날까지 아래와 같이 출력 
     ( LEVEL 의사컬럼 사용 )
실행결과) 
  날짜	       요일    주차(IW)
21/11/01	월	44
21/11/02	화	44
21/11/03	수	44
21/11/04	목	44
21/11/05	금	44
21/11/06	토	44 
 :
21/11/29	월	48
21/11/30	화	48
SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1 날짜
, TO_CHAR( :yyyymm, 'dy')요일 , TO_CHAR(:yyyymm, 'iw')주차 
FROM dual
CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) );

 2-1.  아래와 같이 계층 구조로 출력하는 쿼리 작성  ( 계층구조 질의문)
실행결과)
NAME		LEVEL   empno	mgr
------------------------------------
KING		1	7839	null
   JONES	2	7566	7839         
      FORD	3	7902	7566
         SMITH	4	7369	7902     
   BLAKE	2	7698	7839
      ALLEN	3	7499	7698
      WARD	3	7521	7698
      MARTIN	3	7654	7698
      TURNER	3	7844	7698
      JAMES	3	7900	7698
   CLARK	2	7782	7839
      MILLER	3	7934	7782
 select lpad(' ' ,3*level-3) ||ename as "name" , level ,empno ,mgr
from emp
start with mgr is null
connect by prior empno=mgr;
    

2-2. 위의 JONES 계층구조 제거하는 쿼리 작성. 
실행결과)
NAME		LEVEL   empno	mgr
------------------------------------
KING		1	7839	null
   BLAKE	2	7698	7839
      ALLEN	3	7499	7698
      WARD	3	7521	7698
      MARTIN	3	7654	7698
      TURNER	3	7844	7698
      JAMES	3	7900	7698
   CLARK	2	7782	7839
      MILLER	3	7934	7782
select lpad(' ' ,3*level-3) ||ename as "name", level ,empno ,mgr
from emp
start with mgr is null
connect by prior empno=mgr and  ename!= 'jones';
3.  MERGE : 병합 , 한쪽 테이블의 정보를 다른 테이블에 병합(추가)
drop table tbl_merge2; 

CREATE TABLE tbl_merge1
(
   id      number Primary key
   , name  varchar2(20)
   , pay  number
   , sudang number
)

CREATE TABLE tbl_merge2
(
   id      number Primary key 
   , sudang number
)

INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (1, 'a', 100, 10);
INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (2, 'b', 150, 20);
INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (3, 'c', 130, 0);
    
INSERT INTO tbl_merge2 (id, sudang) VALUES (2,5);
INSERT INTO tbl_merge2 (id, sudang) VALUES (3,10);
INSERT INTO tbl_merge2 (id, sudang) VALUES (4,20);

COMMIT;

위의 두 테이블을 병합(merge)해서 아래와 같이 결과가 나오도록 병합하세요.
[ 실행 결과 ]
SELECT * FROM tbl_merge1;
1	a	100	10
2	b	150	20
3	c	130	0
SELECT * FROM tbl_merge2;
2	5
3	10
4	20
--
1	a	100	10
[2]	b	150	25 ( UPDATE )    
[3]	c	130	10 ( UPDATE )
4	        20 ( INSERT )    
merge into tbl_merge1 t1
using (select id , sudang from tbl_merge2) t2
on(t1.id=t2.id)
when matched then 
    update set sudang =t1.sudang+t2.sudang 
when not matched then 
    insert(t1.id, t1.sudang) values ( t2.id, t2.sudang);
4. 제약조건( Contratrint ) 
  ㄱ. 제약조건이란 ?    
       데이터 무결성을 위해서  입력 수정 삭제할때 적용되는 규ㅠ칙 
  ㄴ. 제약조건을 설정하는 2가지 방법에 대해 설명하세요.
    테이블 생성할때 선언하던지 alter table 테이블명 add 로 설정하던지 
  ㄷ. 제약조건의 5가지 종류 
  기본키 제약조건
  외부키 제약조건
 not null 제약조건
 unique 제약조건
 check 제약조건 
      
  ㄹ. emp 테이블의 제약조건 확인 쿼리 작성 
     
     select *
     from  user_constraints 
     where table_name=upper('emp');
     
  ㅁ. 데이터 무결성 종류 및 설명
  개체 무결성 
  참조무결성
  도메인무결성

5. 아래 테이블 생성 쿼리 에서 [컬럼 레벨] 방식으로 
   ㄱ. deptno 를 PK 로 설정
   ㄴ. dname을 NN 로 설정
CREATE TABLE tbl_dept
(
    DEPTNO  NUMBER(2)   primary keyy
   , DNAME VARCHAR2(14)  not null
   , LOC   VARCHAR2(13)      
);

6. 아래 테이블 생성 쿼리 에서 [테이블 레벨] 방식으로 
   ㄱ. deptno 를 PK 로 설정
   ㄴ. dname을 NN 로 설정       
CREATE TABLE tbl_dept
(
    DEPTNO  NUMBER(2) 
   , DNAME VARCHAR2(14) 
   , LOC   VARCHAR2(13) 
   ,  primary key(deptno)
   ,  not null(dname)
);

7. tbl_dept 테이블을 생성 후 [모든 제약조건 제거]하는 쿼리 작성  
alter table tbl_dept 
drop constrainnt 
8. ALTER TABLE 문을 사용해서 PK 제약조건 설정. 
alter table tbl_dept
add primary key (칼럼명) 
9. UK 제약 조건 삭제 쿼리 작성
   예) tbl_member테이블에  tel 컬럼이 UK_MEMBER_TEL 이란 제약조건명으로
     UNIQUE 제약 조건이 설정된 경우 
     alter table tbl_member
    drop constraint uk_member_tel;

10. FK 제약 조건 설정 시 아래 옵션에 대해 설명하세요
   CONSTRAINT FK_TBLEMP_DEPTNO FOREIGN KEY ( deptno ) 
                                REFERENCES tbl_dept(deptno )
                                
   ㄱ. ON DELETE CASCADE 
   자식까지 삭제
   ㄴ. ON DELETE SET NULL 
삭제햇으면 참조하고 있는 테이블은 null처리 
11. taeyo.net


----------------------
컴꺼져서 다 날라감 
-----------
equi join은  두테이블이상 같은 칼럼이 있을 경우에 사용
join on , from where , join using 으로 사용 
using을 사용하면 객체, 별칭 사용 못함 
natural join은 내부적으로  equi join이랑 같다.


문제 dept, emp을 조인해서
 empno, deptno, dname, ename, hiredate 칼럼 조회 
 
 부모테이블 dept: deptno(pk), dname
 자식테이블 emp : empno(pk), deptno(fk), ename, hiredate 
 
 1)
select e.deptno, dname, empno, ename, hiredate
from emp e join dept d on d.deptno = e.deptno; --equi조인, 네추럴 조인 

2) using 절은 별창,객체 사용 금지 
select deptno, dname, empno, ename, hiredate
from emp e join dept d using(deptno); 

3) 별칭사용 
select e.deptno, dname, empno, ename, hiredate
from emp e, dept d
where d.deptno = e.deptno;

문젝) 
book, panmai, gogaek, danga 조인 

select b.b_id, title, p_su, price, g_name, p_su*price 판매금액
from book b ,panmai p, gogaek g, danga d
where b.b_id=p.b_id and p.g_id=g.g_id and b.b_id= d.b_id;

join on 구문 
select  b.b_id, title, p_su, price, g_name, p_su*price 판매금액 
from book b join panmai p on b.b_id = p.b_id
    join gogaek g on g.g_id = p.g_id 
    join  danga d on  b.b_id=d.b_id;
    
using 사용 
select  b_id, title, p_su, price, g_name, p_su*price 판매금액 
from book b join panmai p using(b_id)
    join gogaek g using(g_id)
    join  danga d using(b_id);


출판된 책들이 각각 총 몇권 판매되엇는지 조회 ( 총 판매권수) 
panmai, book,danga 조인 



select b.b_id, title, sum(p_su) "각각판매권수" ,price
from panmai p join book b on b.b_id=p.b_id
              join danga d on b.b_id=d.b_id
group by b.b_id, title, price 
order by b.b_id asc;


select b.b_id, title, sum(p_su) qty
        ,(select sum(p_su) from panmai) total_qty
from panmai p join book b on b.b_id = p.b_id
              join danga d on b.b_id =d.b_id 
group by b.b_id, title, price;

-- 상관서브쿼리를 이용하여 문제풀기 


문제 ) 각각의 책이 전체판매량의 몇 퍼센트에 해당되는지 출력 

select b.b_id, title ,price 
    --id별로 group by 하였기에 각각의 판매권수 
    , sum(p_su) "각각판매권수" 
    ,(select sum(p_su) from panmai) "전체판매량수"
    ,round(sum(p_su)/ (select sum(p_su) from panmai),2)*100 ||'%' "퍼센트"
from panmai p join book b on b.b_id=p.b_id
              join danga d on b.b_id=d.b_id
group by b.b_id, title, price 
order by b.b_id asc;

book테이블에서 판매가 된 적이 있는 
판매된 적이 없는 

select count(*)
from book; --9

select count(*)
from panmai; --10 (중복된것이 있어서) 

select b_id
from panmai; --10

select count(distinct b_id)
from panmai; --6 

--판매된적이 없는 책의 수는 3 

select distinct b_id
from panmai;

with
a as (
    ---판매가 된 적 잇음 
    select distinct b_id
    from panmai
),
--모든 책정보 
b as(select b.b_id, title, price
from book b join danga d on b.b_id =d.b_id)
select b.b_id, title, price 
from a join b  on a.b_id=b.b_id;


select b_id, title, price
from book 
minus
select  b.b_id, title, price
from book b join panmai p on b.b_id=p.b_id
 join danga d on b.b_id=d.b_id


--2

select  b.b_id, title, price
from book b join danga d on b.b_id=d.b_id
where b.b_id in (select distinct b_id from panmai);

--판매된 적이 없는 책 
select  b.b_id, title, price
from book b join danga d on b.b_id=d.b_id
where b.b_id not in (select distinct b_id from panmai);

select b.b_id, title, price
from book b join (select distinct b_id from panmai)p  on b.b_id=p.b_id
            join danga d on b.b_id=d.b_id;


outer 조인 

가장 많이 판매가 된 책의 정보를 조회 
책id, 제목 가격 총 판매량 

1: top-n 방식 : rownum이라고 하는 의사칼럼을 사용하는 방법 


select t.*,rownum
from(
select b.b_id, title, price ,sum(p_su) qty
from book b join danga d  on b.b_id=d.b_id
            join panmai p on b.b_id=p.b_id
group by b.b_id, title, price 
order by qty desc)t
where rownum=1;

2: rank() 함수 


또 렉걸림 ;; 


판매가 된 적이; 없는 책 정보
select b.b_id, title, p_su, price
from book b left join panmai p on b.b_id =p.b_id
    join danga d on b.b_id=d.b_id
where p_su is null;

cross join 
Cartesian Product를 실행한 겻과 같은 결과를 출력한다.
cross join은 cartesian product를 위한 ANSI/ISO SQL-99의 표준 문법이다.
테이블 aa와 bb의 행 수가 각각 3, 2 이므로 출력 결과는 3x2=6가 출력된다

