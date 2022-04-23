
1.  truncate / delete / drop ���ؼ� �����ϼ���
truncate ���̺� ����, �ڵ�Ŀ�� �ѹ�Ұ�
delete ���̺����ͻ���, where ���ǹ��� ������ ��ü�����͸� ����
drop ���̺� ��ü�� ���� 

2.  insert �� ���� �� ������ ���� ������ �߻��ߴٸ� ������ ���� �����ϼ���
  ��. 00947. 00000 -  "not enough values" 
   insert into ���̺��(Į���� ����) values (Į���� ) 
   ����� ���� �ƴϴ�. 
  ��. ORA-00001: unique constraint (SCOTT.SYS_C007770) violated  ����Ű����  
  ��. ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
   �θ�Ű�� ã�� �� ���� 
3. ���������� ����ؼ� ���̺� ����
  ��. deptno, dname, empno, ename, sal+nvl(comm,0) pay, grade �÷��� ���� ���ο� ���̺� ����
  ��. ���̺�� : tbl_empdeptgrade   

create table tbl_empdeptgrade
as(
    select deptno, dnam, empno, ename, sal+nvl(comm,0) pay, grade
    from dept d join emp e on d.deptno=e.deptno
            join salgrade s on e.,sal between s.losal and s.hisal 
);

4-1. insa ���̺��� num, name �����ͼ� tbl_score ���̺� ����
create table tbl_score
as(
    select num,name
    from insa
);

4-2. kor, eng, mat, tot          , avg , grade, rank �÷� �߰�
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

4-3. �� �л����� kor,eng,mat ���� 0~100 �����ϰ� ä���ֱ�.
update tbl_score
set kor=trunc(dbms_random.value(0,101)),
    eng=trunc(dbms_random.value(0,101)),
    mat=trunc(dbms_random.value(0,101));

4-4. ����, ���, ���, ��� ����
    ����)
     ����� ��� ������ 40���̻��̰�, ��� 60 �̻��̸� "�հ�"
           ��� 60 �̻��̶� �� �����̶� 40�� �̸��̶��  "����"
           �׿ܴ� "���հ�" �̶�� ����.
       update tbl_score
       set avg= (kor+eng+mat)/3  
       ,grade= case
                when kor>=40 and eng>=40 and mat >=40 and avg>=60 then '�հ�'
                when kor<=40 or eng<=40 or mat <=40 and avg>=60then '����'
                else '���հ� ' 
                end;
5.  emp ���̺��� ������ Ȯ���ϰ�, ���������� Ȯ���ϰ�, ������ ��� ������ �߰��ϴ� INSERT ���� �ۼ��ϼ���.
   ��. ����Ȯ�� ����  desc emp;
   ��. �������� Ȯ�� ����
   select *
   from tabs;
   from user_constriants;
   from user_tables;
   where table_name=upper('emp');
   ��. INSERT ���� 
    insert into emp values('����' );
6-1. emp ���̺��� ������ �����ؼ� ���ο� tbl_emp10, tbl_emp20, tbl_emp30, tbl_emp40 ���̺��� �����ϼ���. 
create table tbl_emp10 as select * from emp where 1=0 ; 
create table tbl_emp20 as select * from emp where 1=0 ; 
create table tbl_emp30 as select * from emp where 1=0 ; 
create table tbl_emp40 as select * from emp where 1=0 ; 
6-2. emp ���̺��� �� �μ��� �ش��ϴ� ���������  ������ ������ ���̺� INSERT �ϴ� ������ �ۼ��ϼ���.   
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

7. ������ �ִ� ���� INSERT ������  INSERT ALL �� INSERT FIRST ���� ���� �������� �����ϼ���.
insert first�� �´� ���� �ϳ� ������, �״��� ���ǹ��� ������������ 

�����л��鸸 ��������5���߰� 

UPDATE tbl_score
SET eng = eng + 5
--           1003 , 1005
WHERE num = ANY ( --�ϳ��� �����ϴ� ���� ������ ����� ���� 
    SELECT num 
    FROM insa
    WHERE MOD(SUBSTR(ssn, -7, 1), 2) = 0 AND num <= 1005
);--1005������ ���� �����л��� ���ڸ� �����ͼ� 


-- �޷±׸���
level �ǻ�Į�� 

select :yyyymm
from dual;

select dates 
,to_char(dates,'d')d
,to_char(dates,'dy')dy
,to_char(dates,'day')day
,to_char(dates,'iw')iw
,case
--�Ͽ����̶�� 1�� ���ϰڴ� �޷¿� ���� �Ͽ��Ϻ��� ���ο� ���̱⿡ 
    when to_char (dates, 'd')=1 then to_char(dates, 'iw')+1
    else to_number(to_char(dates,'iw'))

    end "iw2"
,to_char(dates,'ww')ww
,to_char(dates,'w')w --�ش� ���� 1~7���� ����   
from(
select to_date(:yyyymm,'yyyymm')+level-1 dates  -- -1�� �ȳ����� 2�� ���� ��� 
from dual
--to_char�� �ϴϱ� �������� extract ���� �ٲ� 
connect by level<=extract(day from last_day(to_date(:yyyymm,'yyyymm')))
)t

-----------------------------
-------------------------------------------------------- KENIK -------------------------------
SELECT 
      NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  ȭ
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  ��
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE 
               -- IW �� 50�� �����鼭 "�Ͽ���"
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
      NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  ȭ
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  ��
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
--startwith -> �ֻ������ mgr ���� ��� 
start with  mgr is null 
connect by prior empno=mgr; --�ڽ��� ���� �θ� ������ 


select lpad(' ',3*level-3) || ename
,empno,mgr,level
,sys_connect_by_path(ename,'/')path
,connect_by_root ename root_node --�ֻ��� ��Ʈ��� 
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
 
 insert into tbl_level ( deptno, dname, college, loc ) values ( 10,'��������', null , null);
insert into tbl_level ( deptno, dname, college, loc ) values ( 100,'�����̵���к�',10, null );
insert into tbl_level ( deptno, dname, college, loc ) values ( 101,'��ǻ�Ͱ��а�',100,'1ȣ��');
insert into tbl_level ( deptno, dname, college, loc ) values ( 102,'��Ƽ�̵���а�',100,'2ȣ��');
insert into tbl_level ( deptno, dname, college, loc ) values ( 200,'��īƮ�δн��к�', 10,null);
insert into tbl_level ( deptno, dname, college, loc ) values ( 201,'���ڰ��а�',200,'3ȣ��');
 insert into tbl_level ( deptno, dname, college, loc ) values ( 202,'�����а�',200,'4ȣ��');
    
--7�� ���� ���� Ŀ�� 
commit;

select deptno, dname, college, level
from tbl_level
start with deptno=10
connect by prior deptno=college;   --�ڽ�Ű=�θ�Ű ;  --top-down ���



SELECT LPAD(' ', (LEVEL-1)*2) || dname ������
    FROM tbl_level
    START WITH deptno=10
    CONNECT BY PRIOR deptno=college;
    
SELECT LPAD(' ', (LEVEL-1)*2) || dname ������
,deptno, college,level
    FROM tbl_level
   -- where dname!='�����̵���к�'
    START WITH deptno=10
    CONNECT BY PRIOR deptno=college and dname!='�����̵���к�';
    
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

����->tbl_emp ->tbl_bonus
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
when matched then  --��ġ�ϸ� update 
    update set t2.sudang=t2.sudang+t1.sudang
when not matched then --��ġ���� ������ insert 
    insert (t2.id, t2.sudang) values (t1.id, t1.sudang);
    
    
select *
from user_Constraints
where table_name=upper('emp');


��.���̺� ���ڵ�(��)�� �߰�, ���� ,�����Ҷ� ����Ǵ� ��Ģ

��.���̺��� ���� ������ ���ؼ��� ���������� ����Ѵ�.
dept(deptno pk) --emp(deptno pk) 
delete from dept
where deptno=30;
���� ���� -
ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found

��.�����͹��Ἲ 
? 1) ��ü ���Ἲ(Entity Integrity)
�����̼ǿ� ����Ǵ� Ʃ��(tuple)�� ���ϼ��� �����ϱ� ���� ���������̴�. ==pk ����Ű 

? 2) ���� ���Ἲ(Relational Integrity)
�ܷ� Ű�� �ݵ�� ���� Ű�� ���� ��ġ�ϰų� null�� ������ �Ѵ�.
update emp
set deptno=90 --dept���̺����� 90�� �μ��� �������� �ʱ� ������ 
where empno=7369;
delete from dept
where deptno=30
���� ���� -
ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found

? 3) ������ ���Ἲ(domain integrity)
�����̼� (���̺�)���� �������� �ϰ����� �����ϱ� ���� ���������̴� 
kor number(3) not null default 0
�����ο� ����� üũ 
�����Ͱ� �㰡���� �ʴ� ������ �߰�, ���� ,���� �����ϴ� Ư�� 

�ֹε�Ϲ�ȣ 
rrn char(14) insert into ���̺�� (rrn) values ('123') ;

���������� ����ϴ� ���� ? dml�� �� �߸� ���۵Ǵ� ���� �����ϱ� ���ؼ� 
dml= insert, update, delete

���������� ���� �ϴ� ��� 
��. create table ���̺� ����
��.alter table ���̺� ���� ��

������ �ĺ��� �� �ִ� �Ӽ� 

���������� ���� 5���� 
��.primary key �������� (����Ű pk)
��.foreign key �������� (�ܷ�Ű, ����Ű fk)
��. not null �������� nn 
��.unique �������� (���ϼ� uk)
��. check �������� (ck) 
    -Į������ - in line �������� ���
    -���̺��� - out of line �������� ���

--�������� x
create table tbl_constraint
(
    empno number(4) not null
    ,ename varchar2(20) not null
    ,deptno number(2) not null
    ,kor number(3)
    ,email varchar2(20)
    ,city varchar2(20) --���� �λ� �뱸 ���� 
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

--Į������ ������� �������� ���� 
create table tbl_column_level
(
    empno number(4) not null constraint pk_tblcolumn_pk primary key
    ,ename varchar2(20) not null 
    ,deptno number(2) not null constraint fk_tblcolumnlevel_deptno references dept(deptno)
    ,kor number(3) constraint ck_tblcolumnlevel_kor check(kor between 0 and 100)
    ,email varchar2(20) constraint uk_tblcolumn_email unique 
    ,city varchar2(20) constraint ck_tblcolumnlevel_city check(city in ('����','�λ�','�뱸','����'))
);
���̺� ���� ������� �������� ���� 
not null x 
create table tbl_table_level(
     empno number(4) 
    ,ename varchar2(20)
    ,deptno number(2)   
    ,kor number(3)
    ,email varchar2(20)
    ,city varchar2(20)    
    --pk �������� ���� 
,not null constraint pk_tbltable_pk primary key(empno)
,not null constraint fk_tbltable__deptno foreign key(deptno) references dept(deptno)  
,constraint uk_tbltable__email unique (email) 
,constraint ck_tbltable__kor check(kor between 0 and 100)
,constraint ck_tbltable__city check(city in ('����','�λ�','�뱸','����'))
);


insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('1111', 'admin',20,90,'admin@naver.com','����');

insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('2222', 'admin',50,50,'admin@naver.com','����');


--üũ������������, �����ο� ���� ����  kor�� city 
insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('2222', 'admin',50, 111,'admin@naver.com','����');

--not null �������ǿ� ���� 
insert into tbl_table_level (empno,ename,deptno,kor,email, city) 
values ('3333',null,50, 111,'admin@naver.com','����');

--��������Ȯ��
select *
from user_constriants
where table_name =upper('tbl_table_level');

--�������� ����
-- alter table�� ���氡���ϴ� 

alter table ���̺�� 
drop constraint constraint�� primary|unique

alter table ���̺��
drop primary key;

alter table ���̺��
drop constraint pk_tablelevel_empno;


alter table ���̺�� 
add constraint pk_tbltable_level_empno primary key; 

���� 1. ���������� Ȯ���ϰ� ��� ck ���� (����) tbl_table_level ���̺��� 

select *
from user_constraints
where table_name='tbl_table_level';
 
alter table tbl_table_level
drop constraint �������Ǹ� ; 

���� kor �÷��� nn �������� ������ �ȵǾ��մ�. 
alter table tbl_table_level
add constraint �������Ǹ� check (kor is not null)
�Ǵ� 
alter table tbl_table_level
modify kor is not null 

�������� Ȱ��ȭ/��Ȱ��ȭ ==����/�߰�

alter table ���̺��
enable constriant �������Ǹ�

alter table ���̺��
disalbe constraint �������Ǹ� (cascade) ;


emp- �����ؼ� -> tbl_emp ���� 
dept-  ���� ->tbl_dept
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

2) �������� Ȯ�� 
not null�� ������ ���������� ������� �ʴ´� 

select * 
from user_constriants
where table_name='tbl_emp';

3)�������� pk �߰� empno , deptno 

alter table tbl_emp 
add constraint tbl_emp_pk primary key(empno);


alter table tbl_dept
add constraint pk_tbldept_deptno primary key(deptno);

4)tbl_dept(deptno pk) -> tbl_emp(deptno) ����Ű fk ���� 

alter table deptno
add constraint fk_tbldept_deptno foreign key(deptno) references tbl_dept(deptno);

select * from tbl_emp;
select * from tbl_dept; 

delete from tbl_dept
where deptno=30;

tbl_emp���̺� 30�� �μ����鵵 ���� ���� ��Ű�� �ʹ�
on delete cascade �ɼ� 

fk_table_deptno �������� ���� 
alter table tbl_emp
drop constraint fk_table_deptno;

fk���������� �ٽ��߱�� 
alter table tbl_emp
add constraint fk_table_deptno foreign key(deptno) references tbl_dept(deptno) on delete cascade;

--���ڵ带 �����ϴ� ���� �ƴϰ� null������ ���� 
alter table tbl_emp
add constraint fk_table_deptno foreign key(deptno) references tbl_dept(deptno) on delete set null;

delete from tbl_dept
where deptno=30; 

select * from tbl_dept;
select * from tbl_emp ;

rollback;

����- ���ų� ���� �ٸ� �ΰ� �̻��� ���̺��� Į���� �˻� �ϱ� ���ؼ� ����Ѵ�. 


�������� 
? �� ���� ���̺��� �� ���� ���̺�ó�� ����ϱ� ���� ���̺� ������ ����Ͽ� �� ���̺��� ��ü������ JOIN�Ͽ� ����Ѵ�.
? SELF JOIN�� ���̺��� �ڽ��� Ư�� �÷��� �����ϴ� �� �ٸ� �ϳ��� �÷��� ������ �ִ� ��쿡 ����Ѵ�.

�����ġ�
	SELECT alias1.�÷���, alias2.�÷���
	FROM �������̺� alais1, �������̺� alais2
	WHERE alias1.�÷�1��=alais2.�÷�2��;

�����ġ�
	SELECT alias1.�÷���, alias2.�÷���
	FROM �������̺� alais1 JOIN �������̺� alais2
		ON alias1.�÷�1��=alais2.�÷�2��;

����)�����ȣ/�����/�μ��� ��ȸ + ���ӻ��(�Ŵ���) ����� 
select a.empno,a.ename, a.deptno , a.mgr, b.ename
from emp a, emp b
where a.mgr=b.empno;

select a.empno,a.ename, a.deptno , a.mgr, b.ename
from emp a join emp b on a.mgr=b.empno;


�μ������ �˰������ 
select a.empno,a.ename, a.deptno , a.mgr, b.ename, dname
from emp a, emp b, dept d
where a.mgr=b.empno and a.deptno=d.deptno;


select a.empno,a.ename, a.deptno , a.mgr, b.ename, dname
from emp a join emp b on a.mgr=b.empno join dept d on a.deptno=d.deptno;