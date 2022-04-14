
1. PIVOT() �Լ��� ������ ��������.
  SELECT * 
  FROM (�ǹ� ��� ������)
  PIVOT (�׷��Լ�(�����÷�) FOR �ǹ��÷� IN(�ǹ��÷� �� AS ��Ī...))
  
2. emp ���̺���   �� JOB�� ����� (�Ǻ�)

select * 
from (select job from emp)
pivot (count(job) for job in (   'CLERK'  ,' SALESMAN',  'PRESIDENT',   ' MANAGER',    'ANALYST'));

--pivot( for in ()) �̷��� ��Ƴ��� �������ϴ� 

    CLERK   SALESMAN  PRESIDENT    MANAGER    ANALYST
---------- ---------- ---------- ---------- ----------
         3          4          1          3          1

3. emp ���̺���  [JOB����] �� ���� �Ի��� ����� ���� ��ȸ 

  ��. COUNT(), DECODE() ���
 select hiredae
        ,to_char(hiredate,'mm') --�������� 
        ,extract(month from hiredate) --�������� 
from emp ;
  
select job, count(*)
            ,count(decode(exract(month from hiredate),1,'o'))"1��"
            ,count(decode(exract(month from hiredate),2,'o'))"1��"
            ,count(decode(exract(month from hiredate),3,'o'))"1��"
            ,count(decode(exract(month from hiredate),4,'o'))"1��"
            ,count(decode(exract(month from hiredate),5,'o'))"1��"
            ,count(decode(exract(month from hiredate),6,'o'))"1��"
            ,count(decode(exract(month from hiredate),7,'o'))"1��"
            ,count(decode(exract(month from hiredate),8,'o'))"1��"
from emp
group by job;

select job, count(*),
        count(decode( to_char(hiredate, 'mm'), '01', 'O')) "01��"
        , count(decode( to_char(hiredate, 'mm'), '02', 'O')) "02��"
        , count(decode( to_char(hiredate, 'mm'), '03', 'O')) "03��"
        , count(decode( to_char(hiredate, 'mm'), '04', 'O')) "04��"
        , count(decode( to_char(hiredate, 'mm'), '05', 'O')) "05��"
        , count(decode( to_char(hiredate, 'mm'), '06', 'O')) "06��"
        , count(decode( to_char(hiredate, 'mm'), '07', 'O')) "07��"
        , count(decode( to_char(hiredate, 'mm'), '08', 'O')) "08��"
        , count(decode( to_char(hiredate, 'mm'), '09', 'O')) "09��"
        , count(decode( to_char(hiredate, 'mm'), '10', 'O')) "10��"
        , count(decode( to_char(hiredate, 'mm'), '11', 'O')) "11��"
        , count(decode( to_char(hiredate, 'mm'), '12', 'O')) "12��"     
from emp
group by job;

JOB         COUNT(*)         1��         2��         3��         4��         5��         6��         7��         8��         9��        10��        11��        12��
--------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
CLERK              3          1          0          0          0          0          0          0          0          0          0          0          2
SALESMAN           4          0          2          0          0          0          0          0          0          2          0          0          0
PRESIDENT          1          0          0          0          0          0          0          0          0          0          0          1          0
MANAGER            3          0          0          0          1          1          1          0          0          0          0          0          0
ANALYST            1          0          0          0          0          0          0          0          0          0          0          0          1

  
  
  
  
  ��. GROUP BY �� ���
select extract(month from hiredate)"��"
        ,count(*)"�ο���"
from emp
group by  extract(month from hiredate) 
order by extract(month from hiredate) asc;
  

         ��        �ο���
---------- ----------
         1          1
         2          2
         4          1
         5          1
         6          1
         9          2
        11          1
        12          3

8�� ���� ���õǾ����ϴ�. 
  
  ��. PIVOT() ���
  select 
  from (select job,extract(month from hiredate)hire_month from emp) 
  pivot( count(*) for hire_date in (1,2,3,4,5,6,7,8,9,10,11,12));
  
  select extract(month from hiredate)hire_month
  from emp;
  
  select *
from(
    select 
    	extract( month from hiredate) month     
    from emp
    )
pivot (count(month) for month in(1,2,3,4,5,6,7,8,9,10,11,12) );
  
JOB               1��          2          3          4          5          6          7          8          9         10         11         12
--------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
CLERK              1          0          0          0          0          0          0          0          0          0          0          2
SALESMAN           0          2          0          0          0          0          0          0          2          0          0          0
PRESIDENT          0          0          0          0          0          0          0          0          0          0          1          0
MANAGER            0          0          0          1          1          1          0          0          0          0          0          0
ANALYST            0          0          0          0          0          0          0          0          0          0          0          1

4. emp ���̺��� �� �μ��� �޿� ���� �޴� ��� 2�� ���
  ������)
       SEQ      EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- ---------- --------- ---------- -------- ---------- ---------- ----------
         1       7839 KING       PRESIDENT            81/11/17       5000                    10
         2       7782 CLARK      MANAGER         7839 81/06/09       2450                    10
         1       7902 FORD       ANALYST         7566 81/12/03       3000                    20
         2       7566 JONES      MANAGER         7839 81/04/02       2975                    20
         1       7698 BLAKE      MANAGER         7839 81/05/01       2850                    30
         2       7654 MARTIN     SALESMAN        7698 81/09/28       1250       1400         30
  
-rank �����Լ� partition �ɼ����� �׷� 
-top-n ��� 
--from keyword ���� ����, select * -> select emp.* 
select dept_rank seq, t.empno, t.ename,t.sal
from (select emp.*, rank() over(partition by deptno order by sal desc) dept_rank
from emp)t
where dept_rank<=2

select rownum, t.*
from (
    select  *
    from emp
    order by sal desc
)t
where rownum<=2;

------------------------------
emp ���̺��� grade ��޺� ����� ��ȸ 

1)count(), decode() 
    --decode���� 'o'ó�� ���� ���� ������ null���� �� 
    select 
        count(decode(���,1,'o'))
    
    1) ���� �̷��� �������� 
    select ename, sal, losal ||'~' ||hisal, grade 
    from emp e, salgrade s
    where e.sal between s.losal and s.hisal;
    
    2)
    select  count(*)
    ,count(decode(grade , 1,'o') )"1���"
    ,count(decode(grade , 2,'o') )"2���"
    ,count(decode(grade ,3,'o') )"3���"
    ,count(decode(grade ,4,'o') )"4���"
    ,count(decode(grade ,5,'o') )"5���"
    from emp e, salgrade s
    where e.sal between s.losal and s.hisal;

--�ĺ���(��Ī���� )����Ҷ� ���ڷ� �����ϸ� �ȵǱ� ������ ""�� �־���Ѵ�. 

2)group by
select grade || '���' , count(*) �����
from emp e, salgrade s
    where e.sal between s.losal and s.hisal
    group by grade
    order by grade asc;
3)pivot() 
select *
from(select  deptno, grade 
    from emp e, salgrade s
    where e.sal between s.losal and s.hisal)
pivot(count(*) for grade in (1 as"1���",2 as"2���",3 as "3���",4 as "4���",5 as "5���"));
pivot(for in (���)) --��Ͽ� ���� ������ �ȵȴ�. 

emp ���̺��� �⵵�� �Ի����� ��ȸ 

select *
from(
    select 
     extract( year from hiredate) year
    from emp
    )
pivot (count(year) for year in(1980, 1981, 1982) );


select extract(year from hiredate)"year", count(*)
from emp
group by  extract(year from hiredate)
order by extract(year from hiredate) asc;


select  
      count(decode(to_char(hiredate,'yyyy'),1980,'o')) "1980��"
     ,count(decode(to_char(hiredate,'yyyy'),1981,'o')) "1981��"
    ,count(decode(to_char(hiredate,'yyyy'),1982,'o')) "1982��"
from emp


--���̺� ���� 
���̺� �̸�:tbl_pivot 
Į��":no, name, jumsu

create table tbl_pivot(
 --not null�� �ʼ� �Է� 
 no number not null primary key -- ()��ȣ�Ⱦ��� �ִ�� ����,�⺻Ű ����
 , name varchar2(20) not null --�ѱ��� varchar2 6���ڱ��� ���尡�� 
 ,jumsu number(3) --�ִ밡 100�̴ϱ� ����3�ڸ����� ���� 
);
--�л��� �����߰� 
--insert into ���̺��(Į����) values(�ش� ���� ) ;

--������: ���� ������ ������ �־���Ѵ�. ���� ���� ���� 

insert into tbl_pivot(no,name,jumsu) values(1,'�ڿ���',90);
insert into tbl_pivot(no,name,jumsu) values(2,'�ڿ���',45);
insert into tbl_pivot(no,name,jumsu) values(3,'�ڿ���',90);

insert into tbl_pivot(no,name,jumsu) values(4,'�Ƚ���',56);
insert into tbl_pivot(no,name,jumsu) values(5,'�Ƚ���',45);
insert into tbl_pivot(no,name,jumsu) values(6,'�Ƚ���',12);

insert into tbl_pivot(no,name,jumsu) values(7,'���',99);
insert into tbl_pivot(no,name,jumsu) values(8,'���',85);
insert into tbl_pivot(no,name,jumsu) values(9,'���',100);

commit;

select *
from tbl_pivot;

--�ǹ����Ѽ� ���η� ��� 
--���̺��� �����ϴ°� ������, no�� 3���γ����� ���� 
select trunc((no-1)/3)+1 no,name,jumsu
    ,decode(mod(no,3),1,'����',2,'����',0,'����')subject
from tbl_pivot
order by no asc;

select no
    ,trunc((no-1)3)+1
from tbl_pivot;

select *
from (select trunc((no-1)/3)+1 no,name,jumsu
    ,decode(mod(no,3),1,'����',2,'����',0,'����')subject
    from tbl_pivot)
pivot ( max(jumsu) for subject in ('����','����','����') )
order by no asc;


-dbms.random()
�ڹ��� 0.0<=math.random <1.0
�ڹ��� ��Ű�� �����̶� �ٸ���. 
pl/sql Ȯ��� sql+pl(���������) 

select 
--dbms_random.value
--,dbms_random.value(0,100) 0<=x<100
--,dbms_random.value(0,45)  
--,floor(dbms_random.value)+1 1~45�� 
dbms_random.string('u',5) --u�� upper 
,dbms_random.string('l',5)--���� lower 
,dbms_random.string('a',5)--a�� ���ĺ�
,dbms_random.string('x',5) --�빮��+���� 5�� 
,dbms_random.string('p',5) --Ư������ 
from dual;

����)150<=����<=200 ������� 

select floor(dbms_random.value(0,51))+150 
from dual;

select dbms_random.value
,trunc(dbms_random.value*51) +150
,trunc(dbms_random.value(0,51))+150
,trunc(dbms_random.value(150,201))
from dual;

char
�������� �����ڷ���
1byte ~2000byte ���ĺ�(1����=1byte),�ѱ�(1����=3byte)

select vsize('a'), vsize('��')
from dual;

char(size [byte|char])
char(3) ==char(3 byte)
char(3 byte) ==3���� 
char 

��.�׽�Ʈ 
create table tbl_char(
    aa char
    ,bb char(3)
    ,cc char(3 char)
);

select *
from tbl_char;

insert into tbl_char(aa,bb,cc) values('a','kbs','kbs');
insert into tbl_char(aa,bb,cc) values('b','k','ĳ���');

2)nchar==n +char ==unicode+char
��.�����ڵ� ��� ����� 1���ڸ� 2����Ʈ�� ó��
��. ����
��.nchar[(size)]
��.�������� �ִ�2000����Ʈ 
��.nchar==nchar(1)
��.nchar(5)

create table tbl_nchar(
    aa char
    ,bb char(3 char)
    ,cc nchar(3)
);
insert into tbl_nchar values('a','ȫ��x','ȫ�浿');

select * 
from tbl_nchar;

3)varchar2=var+char
��.�������� �ִ� 4000����Ʈ
��.���� varchar2(size[byte|char]) �� �ó�� varchar
��.char==char(1 byt) varchar2==varchar2(4000 byte) 
varchar2== varchar2(4000 byte)
varchar2(10)==varchar2(10 byte)
varchar2(10 char)

��.��������/ �������� ������ 

char=��������
varchar=�������� 
'kbs'����
char        [k][b][s][][][][[][][][][]
varchar     [k][b][s]

��������: ��� ���� ���̰� ������ -��)�ֹε�Ϲ�ȣ
��������: ���̰� �� �ٸ� �� -��) ���� 

nvarchar2(size)
n�� ��繮�� �Ȱ��� ����Ʈ�� �����Ѵٴ¶� 
n(�����ڵ�)+var(��������)+char(���ڿ�)
�ִ� 4000����Ʈ 
nvarchar2[(size)]
nvarchar2==nvarchar2(�ִ밪)

long
���������� �����ڷ��� /2gb
number([p],[s]) 
��.����(����, �Ǽ�) 
��.precision ��Ȯ==��ü�ڸ��� , scale �Ը�(����)==�Ҽ��� ���� �ڸ��� �� ���Ӹ� 
��.number(p)����, number(p,s)�Ǽ�
��.number == number(38,127)
�׽�Ʈ 
create table tbl_number(
    kor number(3)
    ,eng number(3)
    ,mat number(3)
    ,tot number(3)
    ,avgs number(5,2)
);

insert into tbl_number (kor,eng,mat) values(90,85,100);
insert into tbl_number (kor,eng,mat) values(90,85,101);
insert into tbl_number (kor,eng,mat) values(90,85,-1);
commit;

select *
from tbl_number;

-- value larger than specified precision allowed for this column
--������ ũ�⺸�� �ʹ� ũ��. 
insert into tbl_number (kor,eng,mat) values(90,85,1001);

update tbl_number
set kor=trunc(dbms_random.value(0,101))
,   eng=trunc(dbms_ramdom.value(0,101))
,   mat=trunc(dbms_random.value(0,101))
;

update tbl_number
set tot=kor+eng+mat
,   avgs=(kor+eng+mat)/3;

commit;

update tbl_number
set avgs=89.23;

update tbl_number
set avgs=999.877;
set avgs=89.342999; 
set avgs=99999; --value larger than specified precision allowed for this column


date 
-����, �� ,��, �� ,+��,+�� ,�� �� �����ϴ� �ڷ��� �������� 7����Ʈ ���� 
�л� ������ �����ϴ� ���̺� tbl_number
Į��:
�й�  number(p,s) number(7) -1111111~1111111
�̸�  number(3) -999~999  0<= <=100 
����  number(3)  char , nchar, varchar2, nvarchar2 ,�������� varchar2(size BYTE|CHAR) 
����  number(3)  varchar2(20)
����  number(3) 0~300
����  number(3)
���  number(3)
���  number(3) 
����  date
�ֹι�ȣ char(14)
��Ÿ long


timestamp(n) date�� Ȯ��� �ڷ��� , ��/00000000 �����ʱ��� ��Ÿ�� 
timestamp==timestamp(6) 

interval year[(n)] to month n=2
interval day[(n1)] to second 

raw() 
long raw
�̹��� ����-> ���̺��� � �÷� 
test.gif img raw/long raw

lob(larger object)
��.b+lob=blob
��.c+lob=clob 
��.n+c+lob=nclob (�����ڵ� �ؽ�Ʈ ������) 

�ؽ�Ʈ long, �̹���, ���������� (long raw)+2gb �̻� (��뷮) lob

row id =���̺� ���� ���� ���� �ּҸ� ������ 64 ���� Ÿ��

--����Ŭ �ڷ��� ����--
��¥ -date, timestamp(n)-[���� ������� ��Ÿ��]
����- number(p,s) , float(p) x
����-char, nchar
varchar2==varchar, nvarchar2
long(2gb)
2�������� =raw, long raw 

----file----
blob Binary �����͸� 4GB���� ���� (4GB= (232 -1����Ʈ))
clob Binary �����͸� 4GB���� ���� (4GB= (232 -1����Ʈ))
nclob  Binary �����͸� 4GB���� ���� (4GB= (232 -1����Ʈ))
bfile  ���̺� ���� ���� ���� �ּҸ� ������ 64 ���� Ÿ��


--count
������ ���� ���� ��ȯ�Ѵ�.
COUNT(�÷���) �Լ��� NULL�� �ƴ� ���� ���� ����ϰ� COUNT(*) �Լ��� NULL�� ������ ���� ���� ����Ѵ�.
�����ġ�
	COUNT([* ? DISTINCT ? ALL] �÷���) [ [OVER] (analytic ��)] ������ ���� ������ �� ��ȯ 

select name, basicpay
    , count(*) over (order by basicpay asc) 
from insa;

select buseo, name, basicpay,count(*) over(partition by buseo order by basicpay desc)
from insa;


sum �Լ� -������ �� 
���ġ�
	SUM ([DISTINCT ? ALL] expr)
               [OVER (analytic_clause)]
select distinct buseo
,sum(basicpay ) over(order by buseo) ps
from insa
order by ps asc;

avgs
�����ġ�

AVG( [DISTINCT ? ALL] �÷���) [ [OVER] (analytic ��)]

--������ձ޿� ��
select buseo,name, basicpay, avg(basicpay) over (order by city)
from insa; 

select avg(basicpay)
from insa
where city='���';

���̺� ����, ����, ����= �߰�,����, ���� ��� 


���̺� table

--���̺����
Į��          Į����         �ڷ���                             ����� 
 ���̵�        id             ����/��������     varchar2 10          not null
 �̸�         name            ����/��������     varchar2 20          not null
 ����         age             ����/����        number    3    
 ��ȭ��ȣ       tel            ����             char    13           not null 
 ����         birth             ��¥           date         
 ��Ÿ         etc               ����           varchar2 200
 
 ���̺� ����

create table scott.tbl_memgber(
    id varchar2(10) not null primary key
   ,name varchar2(20) not null
    ,age number(3) 
    ,tel char(13)
    ,birth date 
    ,etc varchar2(200)
    );
    
select *
from tabs;
where table_name like '%memgber%';

--���̺� ����--
drop table tbl_memgber;

create table scott.tbl_member(
    id varchar2(10) not null primary key
   ,name varchar2(20) not null
    ,age number(3) 
    ,birth date 
    );
    
--���̺���-=  
desc tbl_member;

���� ���̺� Į���߰�-alter 

�����ġ��÷��߰�
	ALTER TABLE ���̺��
	ADD (�÷��� datatype [DEFAULT ��]
	    [,�÷��� datatype]...);

�����ġ�constraint�߰�
	ALTER TABLE ���̺��
	ADD (�÷��� datatype CONSTRAINT constraint�� constraint������
	    [,�÷��� datatype]...);

? �ѹ��� add ������� ���� ���� �÷� �߰��� �����ϰ�, �ϳ��� �÷��� �߰��ϴ� ��쿡�� ��ȣ�� �����ص� �ȴ�.
? �߰��� �÷��� ���̺��� ������ �κп� �����Ǹ� ����ڰ� �÷��� ��ġ�� ������ �� ����
? �߰��� �÷����� �⺻ ���� ������ �� �ִ�.
? ���� �����Ͱ� �����ϸ� �߰��� �÷� ���� NULL�� �Է� �ǰ�, ���� �ԷµǴ� �����Ϳ� ���ؼ��� �⺻ ���� ����ȴ�.

alter table tbl_member
    add(
        tel char(13) not null
        ,etc varchar2(200)
    );

desc  tbl_member;


modify ����� ���̺��� �÷��� �����ϰ��� �� �� ����Ѵ�.


�����ġ�
        ALTER TABLE ���̺��
        MODIFY (�÷��� datatype [DEFAULT ��]
               [,�÷��� datatype]...);

? �������� type, size, default ���� ������ �� �ִ�.
? ���� ��� �÷��� �����Ͱ� ���ų� null ���� ������ ��쿡�� size�� ���� �� �ִ�.
? ������ Ÿ���� ������ CHAR�� VARCHAR2 ��ȣ���� ���游 �����ϴ�.
? �÷� ũ���� ������ ����� �������� ũ�⺸�� ���ų� Ŭ ��쿡�� �����ϴ�.
? NOT NULL �÷��� ��쿡�� size�� Ȯ�븸 �����ϴ�.
? �÷��� �⺻�� ������ �� ���Ŀ� ���ԵǴ� ����� ������ �ش�.
? �÷��̸��� �������� ������ �Ұ����ϴ�.
? �÷��̸��� ������ ���������� ���� ���̺� ������ alias�� �̿��Ͽ� ������ �����ϴ�.
? alter table ... modify�� �̿��Ͽ� constraint�� ������ �� ����.

etc varchar2(200) Į���� ũ�⸦ 255�� ���� 
alter table tbl_member
    modify(etc varchar2(255));
    
desc tbl_member;

etc Į������ bigo Į�������� ���� 
alter table tbl_member
    rename column etc to bigo;
    
    
    
    ALTER TABLE ... DROP COLUMN �÷��� ���� �÷� ����
alter table ... drop ���� ���̺��� �����ϴ� ���� �ƴ϶�, Ư�� ���̺��� �÷��̳� constraint�� ������ �� ����Ѵ�. 

�����ġ�
        ALTER TABLE ���̺��
        DROP COLUMN �÷���; 

? �÷��� �����ϸ� �ش� �÷��� ����� �����͵� �Բ� �����ȴ�.
? �ѹ��� �ϳ��� �÷��� ������ �� �ִ�.
? ���� �� ���̺��� ��� �ϳ��� �÷��� �����ؾ� �Ѵ�.
? DDL������ ������ �÷��� ������ �� ����.

alter table tbl_member
drop column bigo;

desc tbl_member;

tbl_member ���̺��� �̸� ���� (tbl_customer )
rename tbl_member to tbl_customer ;
