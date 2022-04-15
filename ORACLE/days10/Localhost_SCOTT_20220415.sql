-- SCOTT 계정 접속 -- 
-- 9:40 수업 시작~ 

1. 오라클 각 DataType 에 대해 상세히 설명하세요

   ㄱ. 문자,문자열
      ㄴ 고정길이        char   nchar
      ㄴ 가변길이        varchar2  nvarchar2      
      ㄴ Long 2GB
   
   ㄴ. 숫자
      ㄴ 정수  NUMBER( p , 0 )
      ㄴ 실수  NUMBER( p , s )
      
      p 전체자릿수  1~38
      s           -84~127 
      
      FLOAT 실수 =  NUMBER
  
   ㄷ. 날짜   
      ㄴ Date
      ㄴ Timestamp(n==6)
   
   ㄴ. LOB
      ㄴ CLOB 
      ㄴ BLOB
      ㄴ NCLOB
      
      BFILE

    등등


2.  emp 테이블에서 [년도별] [월별] 입사사원수 출력.( PIVOT() 함수 사용 )

    [실행결과]
    1982	1	0	0	0	0	0	0	0	0	0	0	0
    1980	0	0	0	0	0	0	0	0	0	0	0	1
    1981	0	2	0	1	1	1	0	0	2	0	1	2
    
    
    1) 피벗 대상 서브쿼리.
    
    SELECT EXTRACT(YEAR FROM hiredate) hiredate_year, EXTRACT(MONTH FROM hiredate) hiredate_month     FROM emp
    
    2) 목록
    
    SELECT *
    FROM  ( SELECT EXTRACT(YEAR FROM hiredate) hiredate_year, EXTRACT(MONTH FROM hiredate) hiredate_month     FROM emp )
    PIVOT ( COUNT(*) FOR hiredate_month IN ( 1,2,3,4,5,6,7,8,9,10,11,12 ));
    
    
2-2.   emp 테이블에서 각 JOB별 입사년도별 1월~ 12월 입사인원수 출력.  ( PIVOT() 함수 사용 ) 
    [실행결과]
    ANALYST		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1980	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1982	1	0	0	0	0	0	0	0	0	0	0	0
    MANAGER		1981	0	0	0	1	1	1	0	0	0	0	0	0
    PRESIDENT	1981	0	0	0	0	0	0	0	0	0	0	1	0
    SALESMAN	1981	0	2	0	0	0	0	0	0       

SELECT *
FROM (
    SELECT job, EXTRACT(YEAR FROM hiredate) hire_year, EXTRACT(MONTH FROM hiredate) hire_month
    FROM emp
)
PIVOT(COUNT(*) FOR hire_month IN (1 AS "1월",2 AS "2월",3 AS "3월",4 AS "4월",5 AS "5월",6 AS "6월",7 AS "7월"
    ,8 AS "8월",9 AS "9월",10 AS "10월",11 AS "11월",12 AS "12월")) 
ORDER BY  job;    
    
--  10:02 수업시작~

3. emp테이블에서 입사일자가 오래된 순으로 3명 출력 ( TOP 3 )
    [실행결과]
    1	7369	SMITH	CLERK	    7902	80/12/17	800		    20
    2	7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
    3	7521	WARD	SALESMAN	7698	81/02/22	1250	500	30    
    
    ㄱ. TOP-N : ROWNUM 의사컬럼
    SELECT *
    FROM (
            SELECT ROWNUM seq, emp.*
            FROM emp
            ORDER BY hiredate ASC
    )
    WHERE seq <= 3;
    
    ㄴ. RANK()~
    SELECT *
    FROM (
            SELECT emp.*
                , RANK() OVER( ORDER BY hiredate ASC) seq
            FROM emp
    )
    WHERE seq <= 3;
    
4. SMS 인증번호  임의의  6자리 숫자 출력 ( dbms_random  패키지 사용 )
-- LTRIM(), RTRIM() , TRIM()
   SELECT 
            SUBSTR(  LTRIM(   LTRIM( dbms_random.value , '0.' ) , '0') , 0, 6)
            , TRUNC(  dbms_random.value(100000,1000000) )  -- 100000<= 실수 <999999
            , dbms_random.string('A', 5)
   FROM dual;

4-2. 임의의 대소문자 5글자 출력( dbms_random  패키지 사용 )



5. "게시글을 저장하는 테이블" 생성
   ㄱ.   테이블명 : tbl_test
   ㄴ.   컬럼
         글번호    seq            자료형  크기    널허용여부    고유키
         작성자    writer     
         비밀번호 passwd      
         글제목    title       
         글내용    content
         작성일    regdate   
    ㄷ.  글번호, 작성자, 비밀번호, 글 제목은 필수 입력 사항으로 지정
    ㄹ.  글번호가  기본키( PK )로 지정
    ㅁ.  작성일은 현재 시스템의 날짜로 자동 설정
-- ORA-00907: missing right parenthesis
--            빠져있다(누락) 오른쪽 괄호
CREATE TABLE tbl_test(
   seq   NUMBER        NOT NULL   CONSTRAINTS PK_tbltest_seq  PRIMARY KEY
   , writer VARCHAR2(20) NOT NULL
   , passwd VARCHAR2(20) NOT NULL
   , title VARCHAR2(100) NOT NULL
   , content LONG
   , regdate DATE       DEFAULT SYSDATE
);

-- Table TBL_TEST이(가) 생성되었습니다.
    
5-2. 조회수    read   컬럼을 추가 ( 기본값 0 으로  설정 ) 
           read NUMBER DEFAULT 0

              DDL
 테이블 생성   CREATE
 테이블 수정   ALTER
 테이블 삭제   DROP

ALTER TABLE TBL_TEST
     ADD read NUMBER DEFAULT 0 ; -- 한 개 컬럼 추가할 때는  () 괄호 생략 가능
     ADD ();
-- Table TBL_TEST이(가) 변경되었습니다.

5-3. 글내용    content 컬럼의 자료형을 clob 로 수정 
   ( LONG -> CLOB ) 자료형 수정.
ALTER TABLE tbl_test
  MODIFY (  content clob );

-- Table TBL_TEST이(가) 변경되었습니다.

5-4. 테이블 구조 확인
DESC tbl_test;

5-5. 글제목     title 을   subject로 수정 ( 컬럼명 수정 )
SELECT title subject FROM tbl_test; -- 기억 ( 별칭 )

ALTER TABLE tbl_test
  RENAME COLUMN title TO subject;
-- Table TBL_TEST이(가) 변경되었습니다.

5-6.  tbl_test  -> tbl_board 테이블명 변경 
RENAME tbl_test TO tbl_board;
-- 테이블 이름이 변경되었습니다.

SEQ     NOT NULL NUMBER        
WRITER  NOT NULL VARCHAR2(20)  
PASSWD  NOT NULL VARCHAR2(20)  
SUBJECT NOT NULL VARCHAR2(100) 
CONTENT          CLOB          
REGDATE          DATE          
READ             NUMBER   

5-7. CRUD  ( insert, select, update, delete ) 
   ㄱ. 임의의 게시글 5개를 추가 insert
INSERT INTO tbl_board (seq, writer, passwd, subject, content, regdate, read )
             VALUES   ( 1, 'admin', '1234', 'test 1 ', 'test -1', SYSDATE, 0);

-- regdate, read 컬럼을 생략 - DEFAULT SYsDATE, 0
INSERT INTO tbl_board (seq, writer, passwd, subject, content )
             VALUES   ( 2, 'hong', '1234', 'hong 1 ', 'hong -1');       
-- 글내용(content) 필수입력 X             
INSERT INTO tbl_board (seq, writer, passwd, subject  )
             VALUES   ( 3, 'kenik', '1234', 'kenik 1 ' );   
             
COMMIT;   
   ㄴ. 게시글 조회 select
SELECT *
FROM tbl_board;


게시글 삭제, 수정할 때는  검색 후

   ㄷ. 3번 게시글의 글 제목, 내용 수정 update

SELECT seq, subject, content
FROM tbl_board
WHERE seq = 3;
--
UPDATE tbl_board
SET  subject =  '[e]' || subject, content =  '[e]' || NVL( content , '내용 무' )
WHERE seq = 3;
   
COMMIT;   
   ㄹ. 4번 게시글 삭제 delete

DELETE FROM tbl_board
WHERE seq = 4;
   
--   0개 행 이(가) 삭제되었습니다.
   
5-8. tbl_board 테이블 삭제  

-- SHFIT + DEL  완전 삭제
DROP TABLE tbl_board PURGE; -- 완전 삭제
휴지통 - 복구

6-1. 오늘의 날짜와 요일 출력 
 [실행결과]
오늘날짜  숫자요일  한자리요일       요일
-------- ---        ------   ------------
22/04/15  6             금      금요일      

SELECT SYSDATE
    , TO_CHAR( SYSDATE , 'D' )
    , TO_CHAR( SYSDATE , 'DY' )
    , TO_CHAR( SYSDATE , 'DAY' )
FROM dual;

6-2. 이번 달의 마지막 날과 날짜만 출력 
 [실행결과]
오늘날짜  이번달마지막날짜                  마지막날짜(일)
-------- -------- -- ---------------------------------
22/04/15 22/04/30 30                                30

SELECT SYSDATE
    , LAST_DAY ( SYSDATE  ) 
    , TO_CHAR(  LAST_DAY ( SYSDATE  ) , 'DD' )
FROM dual;
6-3.
 [실행결과]
오늘날짜    월의주차 년의 주차 년의 주차
--------    -       --      --
22/04/15    3       15      15

SELECT SYSDATE
   ,   TO_CHAR( SYSDATE, 'W')
   ,   TO_CHAR( SYSDATE, 'IW')
   ,   TO_CHAR( SYSDATE, 'WW')
FROM dual;

-- 네이버/구글 검색 :  IW   WW 차이점 파악
-- 11:00 수업 시작

[ 년 주차 ]
IW :  월요일 - 일요일을 기준   
WW :  1일   - 7일을 기준    2022.1.1~ 1.7
1/2/3    4
IW 13    14
WW 13  2~ 14

SELECT TO_CHAR( TO_DATE('2022.4.4'), 'IW')
     ,  TO_CHAR( TO_DATE('2022.4.4'), 'WW')
FROM dual;

----------------------------------------------------------------------------------
[ 테이블 생성하는 방법 ]
• ***  테이블을 만드는 가장 단순하면서도 일반적인 명령 형식으로 만드는 방법
• Extend table 생성  
【형식】
CREATE TABLE table
( 컬럼1  	데이터타입,
  컬럼2  	데이터타입,...)
STORAGE    (INITIAL  	크기
	    NEXT	크기
	    MINEXTENTS	크기
	    MAXEXTENTS	크기
	    PCTINCREASE	n
        );
  캐싱 테이블은 빈번하게 사용되는 테이블 데이터를 데이터버퍼 캐시영역에 상주시켜 
  검색시 성능을 향상시킴. 


• *** Subquery를 이용한 table 생성
• External(외부) table 생성
  - DB 외부에 저장된 data source를 조작하기 위한 접근 방법의 하나로 [읽기 전용 테이블]이다.
 
• NESTED(중첩) TABLE 생성
  - 테이블의 어느 컬럼이 하나의 데이터만 넣는 것이 아니라 그 컬럼은 여러 개의 속성을 가진 데이터를 넣을 수 있는 형식의 데이터타입이다.
  - 즉, 테이블 속의 어느 컬럼이 또 다른 테이블 형식을 가진다
  
• Partitioned Tables & Indexes 생성
----------------------------------------------------------------------------------
[• *** Subquery를 이용한 table 생성]
1. 이미 존재하는 테이블 있고
2. SELECT ~ 서브쿼리를 이용해서 
3. 새로운 테이블 생성 +  데이터 추가( INSERT )
4. 【형식】
	CREATE TABLE 테이블명 [컬럼명 (,컬럼명),...]
	AS subquery;
    • 다른 테이블에 존재하는 특정 컬럼과 행을 이용한 테이블을 생성하고 싶을 때 사용
    • Subquery의 결과값으로 table이 생성됨
    • 컬럼명을 명시할 경우 subquery의 컬럼수와 테이블의 컬럼수를 같게해야 한다.
    • 컬럼을 명시하지 않을 경우, 컬럼명은 subquery의 컬럼명과 같게 된다.
    • subquery를 이용해 테이블을 생성할 때 CREATE TABLE 테이블명 뒤에 컬럼명을 명시해 주는 것이 좋다.
5. 예)
    ㄱ. emp 테이블에서 10번 부서원 검색 ->  empno, ename, hiredate, sal+NVL(comm,0) pay 새로운 테이블 생성
    CREATE TABLE tbl_emp10  -- (  no, name, ibsadate, pay ) -- [컬럼명, 컬럼명, 컬럼명, 컬럼명]
    AS (
       SELECT empno, ename, hiredate, sal+NVL(comm,0) pay
       FROM emp
       WHERE deptno = 10
    );
-- Table TBL_EMP10이(가) 생성되었습니다.

6. 테이블의 구조 확인
DESC TBL_EMP10;

이름       널? 유형           
-------- -- ------------ 
EMPNO       NUMBER(4)      emp 테이블의 자료형
ENAME       VARCHAR2(10)   emp 테이블의 자료형
HIREDATE    DATE           emp 테이블의 자료형
PAY         NUMBER         시스템 자료형 설정

7. 원래 테이블은 그대로 두고, 복사해서 테이블 사용.
    CREATE TABLE tbl_empcopy  
    AS (
        SELECT * FROM emp
    );
    -- emp 테이블의 구조 + 12명의 사원(데이터) 그대로 복사-> 새로운 테이블 생성
    DESC tbl_empcopy;
    SELECT * 
    FROM tbl_empcopy;

8. 제약조건은 복사되지 않는다. ( NOT NULL 제약조건은 예외 ) 
  ㄱ. emp 제약조건
  SELECT *
  FROM user_constraints
  WHERE table_name = UPPER('emp');
  
OWNER
소유자   제약조건이름    제약조건타입
SCOTT	PK_EMP	       [P]           PK
SCOTT	FK_DEPTNO	   [R]           FK

  FROM tabs;
  FROM user_tables;
  
  ㄴ. tbl_empcopy 제약조건  -- PK, FK
  SELECT *
  FROM user_constraints
  WHERE table_name = UPPER('tbl_empcopy');


9. 테이블 삭제
DROP TABLE tbl_emp10 PURGE;
DROP TABLE tbl_empcopy PURGE;

10. 문제) 테이블은 기존테이블 서브쿼리를 사용해서 생성 + 데이터 X
   ( 테이블의 구조 )
   ㄱ. 
CREATE TABLE tbl_emp_copy
AS (
   SELECT *
   FROM emp
   WHERE 1 = 0
);
   ㄴ. 
DELETE FROM tbl_emp_copy;
COMMIT;
   ㄷ. 
SELECT *
FROM tbl_emp_copy;

DROP TABLE tbl_emp_copy PURGE;  -- Oracle 11g XE 

----------------------------------------------------------------------------------
DML - INSERT, UPDATE, DELETE  [COMMIT, ROLLBACK ]                 -- TRUNCATE
----------------------------------------------------------------------------------
1. tbl_member 테이블 있는지 확인
SELECT *
FROM user_tables
WHERE REGEXP_LIKE( table_name,'member' , 'i');
WHERE table_name LIKE '%member%';

2. tbl_member 테이블 삭제.
CREATE / ALTER / DROP

DROP TABLE TBL_MEMBER PURGE;

3. 테이블 생성

rrn 주민등록번호를 컬럼(속성)으로 추가. : 추출 속성 (나이, 생일, 성별 )

CREATE TABLE tbl_member
(
   id varchar2(10) NOT NULL  CONSTRAINT PK_TBLMEMBER_ID  PRIMARY KEY --회원ID, 고유키(PK) == ( 유일성 + NN )
  -- 12:07 수업시작
   , name varchar2(20) NOT NULL -- 회원이름
           , age NUMBER(3) -- 회원나이
           , birth DATE -- 회원생일
   , regdate DATE DEFAULT SYSDATE   -- 회원가입일
   , point NUMBER DEFAULT 100  -- 포인트
);
-- Table TBL_MEMBER이(가) 생성되었습니다.

SELECT *
FROM user_constraints
WHERE table_name  = 'TBL_MEMBER';

-- PK           P
-- NN           C
-- FK           R

-- 자동으로 제약조건 명을 지정하지 않으면   SYS_ ~~~~ 설정


-- 멤버 추가 
오류 보고 -
--ORA-01830: date format picture ends before converting entire input string
-- '1991/03/04'
INSERT INTO TBL_MEMBER (id, name, age, birth, regdate, point )
               VALUES  ('admin','관리자',32, TO_DATE( '03/04/1991', 'MM/DD/YYYY' ), SYSDATE, 100 );
               
-- ORA-00001: unique constraint (SCOTT.PK_TBLMEMBER_ID) violated      
-- PK = UK + NN
INSERT INTO TBL_MEMBER (id, name, age, birth, regdate, point )
               VALUES  ('admin','홍길동',22, '2001.01.01', SYSDATE, 100 );               

INSERT INTO TBL_MEMBER VALUES  ('hong','홍길동',22, '2001.01.01', SYSDATE, 100 );   

-- SQL 오류: ORA-00947: not enough values
INSERT INTO TBL_MEMBER ( id, name, age, birth ) VALUES  ('park','박지순',25, '1998.5.9' );   
COMMIT;

-- NULL 허용하는 컬럼은 
INSERT INTO TBL_MEMBER ( name, birth, id, age )  VALUES  ('이진수', null ,'kenik',25);   

SELECT *
FROM tbl_member;

-- [서브쿼리를 사용해서 INSERT 예제]. --
형식)
   INSERT INTO 테이블명 (서브쿼리);
--
1) tbl_emp10 테이블 유무 확인 -> 삭제
2) emp 테이블을 구조복사 O, 데이터 X  -> tbl_emp10 테이블 생성
CREATE TABLE tbl_emp10 -- 컬럼명....
AS
   (  
      SELECT *
      FROM emp
      WHERE 1=0
   );

SELECT * 
FROM tbl_emp10;

3. emp 테이블의 10번부서원들을 sELECT 해서 -> tbl_emp10테이블에 추가

INSERT INTO tbl_emp10 
  (
     SELECT *
     FROM emp
     WHERE deptno = 10
  ); 
-- 3개 행 이(가) 삽입되었습니다.
COMMIT;
DROP TABLE tbl_emp10 PURGE;

-- [ Multi Table insert 문]  -- 다중 테이블에 INSERT 문
-- 4가지 종류
--   조건 유무              전부/첫번째


-- 하나의 insert 문으로 여러 개의 테이블에 동시에 하나의 행을 입력하는 것이다.


--ㄱ) unconditional insert all 
--ㄴ) conditional insert all 
--ㄷ) conditional first insert 
--ㄹ) pivoting insert 


--ㄱ)   unconditional insert all 
  --   조건과 상관없이 기술되어진 여러 개의 테이블에 데이터를 입력한다
  • 서브쿼리로부터 한번에 하나의 행을 반환받아 각각 insert 절을 수행한다.
  • into 절과 values 절에 기술한 컬럼의 개수와 데이터 타입은 동일해야 한다.

【형식】
	INSERT ALL | FIRST
	  [INTO 테이블1 VALUES (컬럼1,컬럼2,...)]
	  [INTO 테이블2 VALUES (컬럼1,컬럼2,...)]
	  .......
	Subquery;

 -- INSERT INTO 테이블명 (컬럼명...) VALUES (컬럼값...);
 INSERT ALL
       INTO 테이블1 VALUES ( 컬럼값....)
       INTO 테이블2 VALUES ( 컬럼값....)
       INTO 테이블3 VALUES ( 컬럼값....)
       :
서브쿼리 ; SELECT (10개)
       


CREATE TABLE dept_10 AS SELECT * FROM dept WHERE 1=0;
CREATE TABLE dept_20 AS SELECT * FROM dept WHERE 1=0;
CREATE TABLE dept_30 AS SELECT * FROM dept WHERE 1=0;
CREATE TABLE dept_40 AS SELECT * FROM dept WHERE 1=0;

SELECT * FROM dept_10;  DELETE FrOM dept_10;
SELECT * FROM dept_20;  DELETE FrOM dept_20;
SELECT * FROM dept_30;  DELETE FrOM dept_30;
SELECT * FROM dept_40;  DELETE FrOM dept_40;



INSERT ALL
    INTO dept_10 VALUES( deptno, dname, loc  )
    INTO dept_20 VALUES(deptno, dname, loc )
    INTO dept_30 VALUES(deptno, dname, loc )
    INTO dept_40 VALUES(deptno, dname, loc )
SELECT deptno, dname, loc 
FROM dept;


COMMIT;
ROLLBACK;

DROP TABLE dept_10 PURGE;
DROP TABLE dept_20 PURGE;
DROP TABLE dept_30 PURGE;
DROP TABLE dept_40 PURGE;

-- ㄴ) conditional insert all 
      조건이 있는  ~
  
-- 문제) emp_10, emp_20, emp_30, emp_40 테이블 생성
--    emp 사원테이블-> 10부서원 -> emp_10 INSERT
--    emp 사원테이블-> 20부서원 -> emp_20 INSERT
--    emp 사원테이블-> 30부서원 -> emp_30 INSERT
--    emp 사원테이블-> 40부서원 -> emp_40 INSERT

-- emp테이블의 구조만 복사해서 테이블 생성....
CREATE TABLE emp_10 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp_20 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp_30 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp_40 AS SELECT * FROM emp WHERE 1=0;

SELECT * FROM Emp_10;

Conditional insert all 문은
조건없이 무조건 삽입되는 unconditional insert all 문과 달리
특정 조건들을 기술하여 그 조건에 맞는 행들을 원하는 테이블에 나누어 삽입한다.

서브쿼리로부터 한번에 하나의 행을 반환받아 when ... then 절에서 조건을 체크한 후
조건에 맞는 절에 기술된 테이블에 insert 절을 수행한다.

【형식】
	INSERT ALL
        WHEN 조건절1 THEN
          INTO [테이블1] VALUES (컬럼1,컬럼2,...)
        WHEN 조건절2 THEN
          INTO [테이블2] VALUES (컬럼1,컬럼2,...)
        ........
        ELSE
          INTO [테이블3] VALUES (컬럼1,컬럼2,...)
	Subquery;

• subquery로부터 한번에 하나씩 행을 리턴받아 WHEN...THEN절에서 체크한 후, 조건에 맞는 절에 기술된 테이블에 insert 절을 수행한다.
• VALUES 절에 지정한 DEFAULT 값을 사용할 수 있다. 만약 default값이 지정되어 있지 않다면, NULL 값이 삽입된다.



INSERT ALL
  WHEN deptno = 10 THEN
   INTO emp_10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
  WHEN deptno = 20 THEN
   INTO emp_20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
  WHEN deptno = 30 THEN   
   INTO emp_30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
  ELSE   
   INTO emp_40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
SELECT * FROM emp;

ROLLBACK;

SELECT * FROM emp_10;
SELECT * FROM emp_20;
SELECT * FROM emp_30;
SELECT * FROM emp_40;

-- emp_10 레코드 모두 삭제
DROP TABLE emp_10 PURGE; -- 테이블 완전 삭제

DELETE FROM emp_10;
COMMIT;

TRUNCATE TABLE emp_10; -- 모든 레코드 삭제 + 자동 커밋/ 롤백 X
TRUNCATE TABLE emp_20;
TRUNCATE TABLE emp_30;
TRUNCATE TABLE emp_40;

-- ㄷ. conditional first insert 
     조건 있는
     WHEN THEN

【형식】
INSERT FIRST
        WHEN 조건절1 THEN
          INTO [테이블1] VALUES (컬럼1,컬럼2,...)
        WHEN 조건절2 THEN
          INTO [테이블2] VALUES (컬럼1,컬럼2,...)
        ........
        ELSE
          INTO [테이블3] VALUES (컬럼1,컬럼2,...)
Sub-Query;

• conditional INSERT FIRST는 조건절을 기술하여 조건에 맞는 값들을 원하는 테이블에 삽입할 수 있다.
• 여러 개의 WHEN...THEN절을 사용하여 여러 조건 사용이 가능하다. 단, 첫 번째 WHEN 절에서 조건을 만족한다면, INTO 절을 수행한 후 다음의 WHEN 절들은 더 이상 수행하지 않는다.
• subquery로부터 한 번에 하나씩 행을 리턴 받아 when...then절에서 조건을 체크한 후 조건에 맞는 절에 기술된 테이블에 insert를 수행한다.
• 조건을 기술한 when 절들을 만족하는 행이 없을 경우 else절을 사용하여 into 절을 수행할 수 있다. else절이 없을 경우 리턴 딘 그행에 대해서는 아무런 작업도 발생하지 않는다.

--
SELECT *
FROM emp
WHERE deptno = 10;
--7782	CLARK	MANAGER	7839	81/06/09	2450		10
--7839	KING	PRESIDENT		81/11/17	5000		10
--[ 7934	MILLER	CLERK	7782	82/01/23	1300		10 ]  부서 10 AND 잡 CLERK

SELECT *
FROM emp
WHERE job = 'CLERK';
--7369	SMITH	CLERK	7902	80/12/17	800		20
--7900	JAMES	CLERK	7698	81/12/03	950		30
--[ 7934	MILLER	CLERK	7782	82/01/23	1300		10 ]  부서 10 AND 잡 CLERK

INSERT ALL

*** 7369	SMITH	CLERK	7902	80/12/17	800		20             INTO emp_20
*** 7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30     INTO emp_40
*** 7521	WARD	SALESMAN	7698	81/02/22	1250	500	30     INTO emp_40
7566	JONES	MANAGER	7839	81/04/02	2975		20
7654	MARTIN	SALESMAN	7698	81/09/28	1250	1400	30
7698	BLAKE	MANAGER	7839	81/05/01	2850		30
7782	CLARK	MANAGER	7839	81/06/09	2450		10
7839	KING	PRESIDENT		81/11/17	5000		10
7844	TURNER	SALESMAN	7698	81/09/08	1500	0	30
7900	JAMES	CLERK	7698	81/12/03	950		30
7902	FORD	ANALYST	7566	81/12/03	3000		20
*** 7934	MILLER	CLERK	7782	82/01/23	1300		10        INTO emp_10
--
INSERT FIRST
   WHEN deptno = 10 THEN
    INTO emp_10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
   WHEN job = 'CLERK' THEN
    INTO emp_20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
   ELSE
    INTO emp_40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
 SELECT * FROM emp;
 
-- 테이블 모두 삭제... 
DROP TABLE emp_10 PURGE;
DROP TABLE emp_20 PURGE;
DROP TABLE emp_30 PURGE;
DROP TABLE emp_40 PURGE;

"
강사님 
INSERT FIRST 절에서 밀러가 부서 10번이라 emp_10 에 들어간 후에, 
밀러 제외한 직업이 CLERK 인 사람들은 20번에 들어간거면
그 다음 절도 실행된것 아닌가요..?
"

--ㄹ. pivoting insert 
【형식】
INSERT ALL
    WHEN 조건절1 THEN
    INTO [테이블1] VALUES (컬럼1,컬럼2,...)
    INTO [테이블1] VALUES (컬럼1,컬럼2,...)
     ..........
Sub-Query;

• 여러 개의 INTO 절을 사용할 수 있지만, INTO 절 뒤에 오는 테이블은 모두 동일하여야 한다.
• 주로 여러 곳의 시스템으로부터 데이터를 받아 작업하는 dataware house에 적합하다. 정규화 되지 않은 data source들이나 다른 format으로 저장된 data source들을 Oracle의 관계형 DB에서 사용하기에 적합한 형태로 변환한다.
• 정규화 되지 않은 데이터를 oracle이 제공하는 relational한 형태로 테이블을 변경하는 작업을 pivoting이라고 한다.


create table tbl_sales(
    employee_id        number(6)   ,
    week_id            number(2)   ,
    sales_mon          number(8, 2),
    sales_tue          number(8, 2) ,
    sales_wed          number(8, 2) ,
    sales_thu          number(8, 2) ,
    sales_fri          number(8, 2)
); 
-- Table TBL_SALES이(가) 생성되었습니다. 

insert into tbl_sales values(1101,4,100,150,80,60,120); 
insert into tbl_sales values(1102,5,300,300,230,120,150);

COMMIT;

SELECT *
FROM tbl_sales;
--
create table tbl_sales_data(
   employee_id        number(6),
   week_id            number(2),
   sales              number(8,2)
);
-- Table TBL_SALES_DATA이(가) 생성되었습니다.

***   1101	4	100	150	80	60	120
1102	5	300	300	230	120	150

 
 insert all
    into tbl_sales_data values(employee_id, week_id, sales_mon)
    into tbl_sales_data values(employee_id, week_id, sales_tue)
    into tbl_sales_data values(employee_id, week_id, sales_wed)
    into tbl_sales_data values(employee_id, week_id, sales_thu)
    into tbl_sales_data values(employee_id, week_id, sales_fri)
    
    
    select employee_id, week_id, sales_mon, sales_tue, sales_wed,
           sales_thu, sales_fri
    from tbl_sales;
  
SELECT *
FROM tbl_sales_data;
---------------------------------------------------------------------------
-- 1)
INSERT INTO 테이블명 (컬럼명....) VALUES ( 컬럼값...);
-- 2) 서브쿼리를 사용한 INSERT 
INSERT INTO 테이블명 (서브쿼리);
-- 3) 다중테이블 INSERT
        ㄴ uc i a
        ㄴ c  i a
        ㄴ c  i f
        ㄴ p i
        
---------------------------------------------------------------------------
      이미존재하는 테이블을 사용해서 새로운 테이블 생성
문제) insa테이블의 num, name 컬럼만 복사해서 tbl_score 테이블 생성
    조건1) num <= 1005 자료(레코드)만 복사.
    
CREATE TABLE tbl_score
AS
   SELECT num, name
   FROM insa
   WHERE num <= 1005;
-- 
SELECT *
FROM tbl_score;

문제)  tbl_score 테이블에  kor, eng, mat, tot, avg, grade , rank 컬럼 추가
   ( k, e, m 기본값  0 ,           grade 한문자 )
   
ALTER TABLE tbl_score
   ADD (
          kor  NUMBER(3)  DEFAULT 0
          ,eng  NUMBER(3)  DEFAULT 0
          ,mat  NUMBER(3)  DEFAULT 0
          ,tot  NUMBER(3)
          ,avg   NUMBER(5,2)
          ,grade CHAR( 1 CHAR)
          ,rank NUMBER
   );
--   MODIFY
Table TBL_SCORE이(가) 변경되었습니다.

-- 3:05 수업 시작

DESC tbl_score;

-- 문제) 1001~ 1005 num, name
--       kor, eng, mat 임의의 점수를 발생시켜서 수정 ( UPDATE )
UPDATE tbl_score
SET   kor =   TRUNC( dbms_random.value(0, 101) )
    , eng =   TRUNC( dbms_random.value(0, 101) ) 
    , mat =    TRUNC( dbms_random.value(0, 101) );
 -- WHERE;
COMMIT;
-- 문제) tbl_score 테이블에   tot, avg  계산해서 수정( UPDATE )
UPDATE tbl_score
SET      tot = kor + eng + mat
      ,  avg = (kor + eng + mat)/3 ;
--WHERE;
COMMIT;

-- 문제) grade 등급 수정 ( UPDATE )
--  평균이 90 이상     A
--        80         B
--        70         C
--        60         D  
--                   F

UPDATE tbl_score
SET  grade = DECODE(  TRUNC(avg/10) , 10, 'A', 9, 'A', 8, 'B', 7, 'C', 6, 'D', 'F' );
COMMIT;

/*
UPDATE tbl_score
SET  grade = CASE
               WHEN avg BETWEEN 90 AND 100 THEN  'A'   -- avg >= 90
               WHEN avg BETWEEN 80 AND 89 THEN  'B'    -- avg >=80
               WHEN avg BETWEEN 70 AND 79 THEN  'C'    -- avg >=70
               WHEN avg BETWEEN 60 AND 69 THEN  'D'    -- avg >=60
               ELSE  'F'
             END;
*/
/*
UPDATE tbl_score
SET grade = 'A'
WHERE avg BETWEEN 90 AND 100;

UPDATE tbl_score
SET grade = 'B'
WHERE avg BETWEEN 80 AND 89;

UPDATE tbl_score
SET grade = 'C'
WHERE avg BETWEEN 70 AND 79;

UPDATE tbl_score
SET grade = 'D'
WHERE avg BETWEEN 60 AND 69;

UPDATE tbl_score
SET grade = 'F'
WHERE avg BETWEEN 0 AND 59;
*/
-- 문제) rank 등수 처리하는 UPDATE문 

SELECT num, tot
    , RANK() OVER( ORDER BY tot DESC ) rank
FROM tbl_score;
--
UPDATE tbl_score  y
SET rank = (  SELECT COUNT(*)+1 FROM tbl_score WHERE tot > y.tot  );
SET rank = (
               SELECT r
               FROM (
                    SELECT num, tot
                        , RANK() OVER( ORDER BY tot DESC ) r
                    FROM tbl_score
                    ) x
               WHERE  x.num = y.num   
             );
-- 
SELECT *
FROM tbl_score;
COMMIT;
ROLLBACK;

-- 4:05 수업 시작~~ 
                        -- 총점, 평균, 등급, 등수 수정 --
-- 문제) 모든 학생의 국어 점수를 5점 증가..( UPDATE )             -> [ PL/SQL ]
-- if( kor >= 95 )  kor = 100;
-- else             kor +=  5
UPDATE tbl_score
SET   kor  = CASE 
                     WHEN  kor >= 95  THEN   100
                     ELSE                    kor + 5
             END 
;
COMMIT;
1001	홍길동	36	14	4	54	18	F	5
1002	이순신	47	90	43	180	60	D	2
1003	이순애	10	60	88	158	52.67	F	4
1004	김정훈	100	61	62	223	74.33	C	1
1005	한석봉	34	67	67	168	56	F	3
                ↓
1001	홍길동	41	14	4	54	18	F	5
1002	이순신	52	90	43	180	60	D	2
1003	이순애	15	60	88	158	52.67	F	4
1004	김정훈	100	61	62	223	74.33	C	1
1005	한석봉	39	67	67	168	56	F	3


-- 문제) 1001 번 학생의 국어,영어 점수를 1005번학생의 국어,영어 점수로 수정
/*
UPDATE tbl_score
SET   kor = (   SELECT kor FROM tbl_score WHERE num =1005 )
WHERE num = 1001; 
UPDATE tbl_score
SET   eng = (   SELECT eng FROM tbl_score WHERE num =1005 )
WHERE num = 1001;
*/

/*
UPDATE tbl_score
SET  
        kor = (   SELECT kor FROM tbl_score WHERE num =1005 ) 
    ,   eng = (   SELECT eng FROM tbl_score WHERE num =1005 )
WHERE num = 1001;
*/


UPDATE tbl_score
SET    (kor, eng) = (SELECT kor, eng FROM tbl_score WHERE num = 1005)
WHERE  num = 1001;


SELECT kor, eng FROM tbl_score WHERE num = 1005;

COMMIT;

-- (문제) tbl_score 테이블에서 여학생들만 영어 점수 5점 증가 시키는 쿼리 작성
--      ( JOIN )
SELECT *
FROM tbl_score;

SELECT *
FROM insa;

-- 4:36 수업 시작.. 
-- 만년달력 --
SELECT   
           NVL( MIN( DECODE( TO_CHAR(dates, 'D'), 1,TO_CHAR(dates, 'DD') ) ), ' ')  일
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 2,TO_CHAR(dates, 'DD') ) ), ' ') 월
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 3,TO_CHAR(dates, 'DD') ) ), ' ') 화
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 4,TO_CHAR(dates, 'DD') ) ), ' ') 수
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 5,TO_CHAR(dates, 'DD') ) ), ' ') 목
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 6,TO_CHAR(dates, 'DD') ) ), ' ') 금
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 7,TO_CHAR(dates, 'DD') ) ), ' ') 토         
FROM (
        SELECT TO_DATE( :yyyymm, 'YYYYMM') + (LEVEL -1) dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT( DAY FROM LAST_DAY( TO_DATE( :yyyymm , 'YYYYMM') ) )
      ) t      
                                  --  일 
GROUP BY  DECODE( TO_CHAR(dates, 'D'), 1, TO_CHAR( dates, 'IW') +1,  TO_CHAR( dates, 'IW')   )  
ORDER BY  DECODE( TO_CHAR(dates, 'D'), 1, TO_CHAR( dates, 'IW') +1,  TO_CHAR( dates, 'IW')   );

-------------------------------------------------------------------------------------------
입력 :  202203
날짜 :  22/03/01
날짜 + 2 = 날짜
-- ORA-01788: CONNECT BY clause required in this query block  + LEVEL
SELECT TO_DATE( '202203' , 'YYYYMM') + LEVEL -1 
       , TO_CHAR(TO_DATE( '202203' , 'YYYYMM') + LEVEL -1  , 'D')
       ,  TO_CHAR( TO_DATE( '202203' , 'YYYYMM') + LEVEL -1, 'IW') 
FROM dual
CONNECT BY LEVEL <= 31;

-- 제약조건(월)
-- 조인(월/화)
-- 뷰(화)
-- DB 모델링(화/수)
-- PL/SQL(목/금)

토/일
월  --  동적쿼리(1~2)
화  --  암호화
수  --  
목
금
토/일

월- 오라클 발표

-------------------------------------------------------------------------------------------



















 