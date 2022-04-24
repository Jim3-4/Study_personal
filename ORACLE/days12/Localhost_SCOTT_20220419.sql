
1. �̹� �� 1�� ���� ������ ������ �Ʒ��� ���� ��� 
     ( LEVEL �ǻ��÷� ��� )
������) 
  ��¥	       ����    ����(IW)
21/11/01	��	44
21/11/02	ȭ	44
21/11/03	��	44
21/11/04	��	44
21/11/05	��	44
21/11/06	��	44 
 :
21/11/29	��	48
21/11/30	ȭ	48
SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1 ��¥
, TO_CHAR( :yyyymm, 'dy')���� , TO_CHAR(:yyyymm, 'iw')���� 
FROM dual
CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) );

 2-1.  �Ʒ��� ���� ���� ������ ����ϴ� ���� �ۼ�  ( �������� ���ǹ�)
������)
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
    

2-2. ���� JONES �������� �����ϴ� ���� �ۼ�. 
������)
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
3.  MERGE : ���� , ���� ���̺��� ������ �ٸ� ���̺� ����(�߰�)
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

���� �� ���̺��� ����(merge)�ؼ� �Ʒ��� ���� ����� �������� �����ϼ���.
[ ���� ��� ]
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
4. ��������( Contratrint ) 
  ��. ���������̶� ?    
       ������ ���Ἲ�� ���ؼ�  �Է� ���� �����Ҷ� ����Ǵ� �Ԥ�Ģ 
  ��. ���������� �����ϴ� 2���� ����� ���� �����ϼ���.
    ���̺� �����Ҷ� �����ϴ��� alter table ���̺�� add �� �����ϴ��� 
  ��. ���������� 5���� ���� 
  �⺻Ű ��������
  �ܺ�Ű ��������
 not null ��������
 unique ��������
 check �������� 
      
  ��. emp ���̺��� �������� Ȯ�� ���� �ۼ� 
     
     select *
     from  user_constraints 
     where table_name=upper('emp');
     
  ��. ������ ���Ἲ ���� �� ����
  ��ü ���Ἲ 
  �������Ἲ
  �����ι��Ἲ

5. �Ʒ� ���̺� ���� ���� ���� [�÷� ����] ������� 
   ��. deptno �� PK �� ����
   ��. dname�� NN �� ����
CREATE TABLE tbl_dept
(
    DEPTNO  NUMBER(2)   primary keyy
   , DNAME VARCHAR2(14)  not null
   , LOC   VARCHAR2(13)      
);

6. �Ʒ� ���̺� ���� ���� ���� [���̺� ����] ������� 
   ��. deptno �� PK �� ����
   ��. dname�� NN �� ����       
CREATE TABLE tbl_dept
(
    DEPTNO  NUMBER(2) 
   , DNAME VARCHAR2(14) 
   , LOC   VARCHAR2(13) 
   ,  primary key(deptno)
   ,  not null(dname)
);

7. tbl_dept ���̺��� ���� �� [��� �������� ����]�ϴ� ���� �ۼ�  
alter table tbl_dept 
drop constrainnt 
8. ALTER TABLE ���� ����ؼ� PK �������� ����. 
alter table tbl_dept
add primary key (Į����) 
9. UK ���� ���� ���� ���� �ۼ�
   ��) tbl_member���̺�  tel �÷��� UK_MEMBER_TEL �̶� �������Ǹ�����
     UNIQUE ���� ������ ������ ��� 
     alter table tbl_member
    drop constraint uk_member_tel;

10. FK ���� ���� ���� �� �Ʒ� �ɼǿ� ���� �����ϼ���
   CONSTRAINT FK_TBLEMP_DEPTNO FOREIGN KEY ( deptno ) 
                                REFERENCES tbl_dept(deptno )
                                
   ��. ON DELETE CASCADE 
   �ڽı��� ����
   ��. ON DELETE SET NULL 
���������� �����ϰ� �ִ� ���̺��� nulló�� 
11. taeyo.net


----------------------
�Ĳ����� �� ���� 
-----------
equi join��  �����̺��̻� ���� Į���� ���� ��쿡 ���
join on , from where , join using ���� ��� 
using�� ����ϸ� ��ü, ��Ī ��� ���� 
natural join�� ����������  equi join�̶� ����.


���� dept, emp�� �����ؼ�
 empno, deptno, dname, ename, hiredate Į�� ��ȸ 
 
 �θ����̺� dept: deptno(pk), dname
 �ڽ����̺� emp : empno(pk), deptno(fk), ename, hiredate 
 
 1)
select e.deptno, dname, empno, ename, hiredate
from emp e join dept d on d.deptno = e.deptno; --equi����, ���߷� ���� 

2) using ���� ��â,��ü ��� ���� 
select deptno, dname, empno, ename, hiredate
from emp e join dept d using(deptno); 

3) ��Ī��� 
select e.deptno, dname, empno, ename, hiredate
from emp e, dept d
where d.deptno = e.deptno;

����) 
book, panmai, gogaek, danga ���� 

select b.b_id, title, p_su, price, g_name, p_su*price �Ǹűݾ�
from book b ,panmai p, gogaek g, danga d
where b.b_id=p.b_id and p.g_id=g.g_id and b.b_id= d.b_id;

join on ���� 
select  b.b_id, title, p_su, price, g_name, p_su*price �Ǹűݾ� 
from book b join panmai p on b.b_id = p.b_id
    join gogaek g on g.g_id = p.g_id 
    join  danga d on  b.b_id=d.b_id;
    
using ��� 
select  b_id, title, p_su, price, g_name, p_su*price �Ǹűݾ� 
from book b join panmai p using(b_id)
    join gogaek g using(g_id)
    join  danga d using(b_id);


���ǵ� å���� ���� �� ��� �ǸŵǾ����� ��ȸ ( �� �ǸűǼ�) 
panmai, book,danga ���� 



select b.b_id, title, sum(p_su) "�����ǸűǼ�" ,price
from panmai p join book b on b.b_id=p.b_id
              join danga d on b.b_id=d.b_id
group by b.b_id, title, price 
order by b.b_id asc;


select b.b_id, title, sum(p_su) qty
        ,(select sum(p_su) from panmai) total_qty
from panmai p join book b on b.b_id = p.b_id
              join danga d on b.b_id =d.b_id 
group by b.b_id, title, price;

-- ������������� �̿��Ͽ� ����Ǯ�� 


���� ) ������ å�� ��ü�Ǹŷ��� �� �ۼ�Ʈ�� �ش�Ǵ��� ��� 

select b.b_id, title ,price 
    --id���� group by �Ͽ��⿡ ������ �ǸűǼ� 
    , sum(p_su) "�����ǸűǼ�" 
    ,(select sum(p_su) from panmai) "��ü�Ǹŷ���"
    ,round(sum(p_su)/ (select sum(p_su) from panmai),2)*100 ||'%' "�ۼ�Ʈ"
from panmai p join book b on b.b_id=p.b_id
              join danga d on b.b_id=d.b_id
group by b.b_id, title, price 
order by b.b_id asc;

book���̺��� �ǸŰ� �� ���� �ִ� 
�Ǹŵ� ���� ���� 

select count(*)
from book; --9

select count(*)
from panmai; --10 (�ߺ��Ȱ��� �־) 

select b_id
from panmai; --10

select count(distinct b_id)
from panmai; --6 

--�Ǹŵ����� ���� å�� ���� 3 

select distinct b_id
from panmai;

with
a as (
    ---�ǸŰ� �� �� ���� 
    select distinct b_id
    from panmai
),
--��� å���� 
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

--�Ǹŵ� ���� ���� å 
select  b.b_id, title, price
from book b join danga d on b.b_id=d.b_id
where b.b_id not in (select distinct b_id from panmai);

select b.b_id, title, price
from book b join (select distinct b_id from panmai)p  on b.b_id=p.b_id
            join danga d on b.b_id=d.b_id;


outer ���� 

���� ���� �ǸŰ� �� å�� ������ ��ȸ 
åid, ���� ���� �� �Ǹŷ� 

1: top-n ��� : rownum�̶�� �ϴ� �ǻ�Į���� ����ϴ� ��� 


select t.*,rownum
from(
select b.b_id, title, price ,sum(p_su) qty
from book b join danga d  on b.b_id=d.b_id
            join panmai p on b.b_id=p.b_id
group by b.b_id, title, price 
order by qty desc)t
where rownum=1;

2: rank() �Լ� 


�� ���ɸ� ;; 


�ǸŰ� �� ����; ���� å ����
select b.b_id, title, p_su, price
from book b left join panmai p on b.b_id =p.b_id
    join danga d on b.b_id=d.b_id
where p_su is null;

cross join 
Cartesian Product�� ������ ��� ���� ����� ����Ѵ�.
cross join�� cartesian product�� ���� ANSI/ISO SQL-99�� ǥ�� �����̴�.
���̺� aa�� bb�� �� ���� ���� 3, 2 �̹Ƿ� ��� ����� 3x2=6�� ��µȴ�

