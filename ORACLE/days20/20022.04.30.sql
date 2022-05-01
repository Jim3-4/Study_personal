-- SCOTT 계정 접속 --  

   1. 트랜잭션 설명.
   2. 동적쿼리
   3. 암호화/복호화
------------------------------------------------------------------------------------------   
ㄱ. 트랜잭션(Transaction)이란?
일의 처리가 완료되지 않은 중간 과정을 취소하여 일의 시작 전 단계로 되돌리는 기능이다.
즉,
결과가 도출되기까지의 중간 단계에서 문제가 발생하였을 경우
모든 중간 과정을 무효화하여 작업의 처음 시작 전 단계로 되돌리는 것이라 할 수 있다.

ㄴ. 일의 모두 완료를 알리는 commit과 일의 취소를 알리는 rollback이 쓰인다.

ㄷ. DML문을 실행하면 
  해당 트랜젝션에 의해 발생한 데이터가 다른 사용자에 의해 변경이 발생하지 않도록 LOCK(잠김현상)을 발생한다.  
  이 lock은 commit 또는 rollback문이 실행되면 해제된다.
ㄹ. 예) 트랜잭션 처리가 필요한 곳.
    [ 계좌 이체 작업 ]
    
    백경환 -> 김지민   100만원 이체
    
    1) 백경환 통장에서  UPDATE 100만원 차감하는 DML
    2) 김지민 통장에서  UPDATE  100만원 증가하는  DML
    
    1) + 2)  모두 완료  COMMIT;
    1) + 2)  하나라도 실패하면 ROLLBACK;
    
    예) 트랜잭션 처리 필요 + 트리거 생성 처리
    입고테이블                  INSERT 15
    A상품 15 입고
    
    재고테이블
    A상품   115개              UPDATE 

-- A 사용자가 원격으로 SCOTT 계정 접속 --
ㅁ. A 트랜잭션 테스트 
SELECT *
FROM emp;    

7369   SMITH   CLERK   7902   80/12/17   800      20
1) SMITH 사원의 JOB을 CLERK -> MANAGER 수정
UPDATE emp
SET job = 'MANAGER'
WHERE ename = 'SMITH';
-- 1 행 이(가) 업데이트되었습니다.  
-- DML문 실행하면 잠금(LOCK) 
-- COMMIT, ROLLBACK 잠금 해제 X    
7369   SMITH   MANAGER   7902   80/12/17   800      20  
COMMIT;
-- 커밋 완료.  
    
1) SMITH 사원의 JOB을 MANAGER -> CLERK 수정
UPDATE emp
SET job = 'CLERK'
WHERE ename = 'SMITH';    
-- 1 행 이(가) 업데이트되었습니다.   
-- DML문 실행하면 잠금(LOCK) 
-- COMMIT, ROLLBACK 잠금 해제 X 
COMMIT;


INSERT/UPDATE/DELETE DML 문 수행  커/롤    잠금해제X

-- DEAD LOCK( 데드락 )
백경환 - 책상수리 중  드라이버 X , 망치 O

-- A 망치 + 못X   UPDATE 실행중

DML 사용하면 자동으로 트랜잭션이 걸린다( LOCK ) -> 커밋, 롤백 잠금 해제

 DDL/ DCL 실행하면 트랜잭션 종료.
 데이터베이스 종료
 
-- SELECT DQL문에 사용할 수있는 절 : FOR UPDATE OF 문
SELECT *
FROM EMP
FOR UPDATE OF JOB NOWAIT;
DQL + 트랜잭션( LOCK ) 
COMMIT; ROLLBACK;

--------------------------------------------------
TCL문 - COMMIT, ROLLBACK,      SAVEPOINT문
COMMIT;  -- 커밋 완료!!!
-- 10:02 수업 시작
SELECT *
FROM dept;

LOCK
1) 삭제
SAVEPOINT sp_dept_delete;
DELETE FROM dept WHERE deptno = 60 ;     --잠금


2) 추가
SAVEPOINT sp_dept_insert;
INSERT INTO dept VALUES ( 50, 'AA','YY'); --잠금


3) 수정
SAVEPOINT sp_dept_update;
UPDATE dept
SET loc = 'SEOUL'
WHERE deptno = 40;  -- BOSTON             --잠금


SELECT *
FROM dept;

ROLLBACK;
ROLLBACK TO sp_dept_update;  -- SAVEPOINT 생략가능
ROLLBACK TO SAVEPOINT sp_dept_insert;
ROLLBACK TO SAVEPOINT sp_dept_delete;

------------------------------------------------------------------
-- ***** [ 동적 SQL ] *****
JAVA 동적 배열
    int [] m ;
    int length = 10;
    m = new int[length];

PL/SQL
 1. 동적 SQL ? 컴파일 시에 SQL문장이 확정이 되지 않는 경우  -> 실행할 때 SQl문장 확정

  SELECT *
  FROM 게시판테이블
  -- 제목 검색
  IF 제목 검색 THEN
    WHERE 제목 LIKE '길동';
  -- 제목   +  내용   검색
  ELSIF 제목 + 내용 THEN
    WHERE 제목 LIKE '길동' OR 내용 LIKE '길동' ;
  ELSIF 제목 + 내용 THEN
  END IF;
  5만 가지의 경우 

*** 2.   WHERE 조건절, SELECT 컬럼.... 항목이 동적으로 변하는 경우 사용한다. 
SELECT ???  ???...
FROM 
WHERE ? AND ? OR ? ????????...

*** 3. PL/SQL 에서 DDL 문을 실행하는 경우
  CREATE/ALTER/DROP + TRUNCATE 문
  
4. PL/SQL 에서 alter session/system 명령어를 실행하는 경우 DBA X


5. 동적 쿼리를 사용하는 2가지 방법
  ***** 1) 원시 동적 쿼리( Native Dynamic SQL :  NDS ) *****
  2) dbms_sql 패키지 사용 X

-- EXEC[UTE] 저장프로시저명( 파라미터,,);
-- SELECT ename INTO vename 변수 저장
CREATE OR REPLaCE PROCEDURE 프로시저명
(
   p IN OUT  INOUT 파라미터.
   p 파라미터.
   :
)
6. 동적 쿼리를 실행 방법     
  1) 형식
    EXECUTE IMMEDIATE  동적쿼리문
                       [INTO 변수명, 변수명 문 ]
                       [USING MODE(IN,OUT,INOUT) 파라미터, 파라미터,,,,문 ];
    
7. 동적 쿼리 생성(작성) -> 실행
 예1) 익명 프로시저를 사용해서 동적쿼리 작성 및 실행..
DECLARE
  vdsql varchar2(1000);  
  vdeptno emp.deptno%type;
  vempno emp.empno%type;
  vename emp.ename%type;
  vjob emp.job%type;
BEGIN
  -- ㄱ. 동적 퀄리 작성
  vdsql :=  'SELECT deptno, empno, ename, job ';
  vdsql :=   vdsql || 'FROM emp ';
  vdsql :=  vdsql ||  'WHERE empno = 7369 ' ;
  -- ㄴ. 동적 쿼리 실행
  EXECUTE IMMEDIATE vdsql
                    INTO vdeptno, vempno, vename, vjob ;

  DBMS_OUTPUT.PUT_LINE( vdeptno  || ', ' || vempno || ', ' || vename || ', ' || vjob );

-- EXCEPTION
END;

 예2) 저장 프로시저를 사용해서 동적쿼리 작성 및 실행..
CREATE OR REPLACE PROCEDURE up_dselEmp 
(
  pempno emp.empno%type
)
IS
  vdsql varchar2(1000);  
  vdeptno emp.deptno%type;
  vempno emp.empno%type;
  vename emp.ename%type;
  vjob emp.job%type;
BEGIN
  -- ㄱ. 동적 퀄리 작성
  vdsql :=  'SELECT deptno, empno, ename, job ';
  vdsql :=   vdsql || 'FROM emp ';
  vdsql :=  vdsql ||  'WHERE empno = :pempno ' ;
  -- ㄴ. 동적 쿼리 실행
  EXECUTE IMMEDIATE vdsql
                    INTO vdeptno, vempno, vename, vjob
                    USING pempno;

  DBMS_OUTPUT.PUT_LINE( vdeptno  || ', ' || vempno || ', ' || vename || ', ' || vjob );

-- EXCEPTION
END;

-- Procedure UP_DSELEMP이(가) 컴파일되었습니다.

EXEC UP_DSELEMP( 7369 );

SELECT * FROM Dept;
 예3) 저장 프로시저를 사용해서 동적쿼리 작성 및 실행..  ( INSERT )
CREATE OR REPLACE PROCEDURE up_dinsDept
(
  pdname dept.dname%type
  , ploc dept.loc%type
)
IS
  vdsql varchar2(1000);  
  vdeptno dept.deptno%type; -- 50
BEGIN

    SELECT MAX(deptno)+10 INTO vdeptno FROM dept;

  -- ㄱ. 동적 퀄리 작성
  vdsql :=  'INSERT INTO dept ';
  vdsql :=   vdsql || ' VALUES ( :deptno, :dname, :loc ) '; 
  
  -- ㄴ. 동적 쿼리 실행
  EXECUTE IMMEDIATE vdsql                    
                    USING vdeptno, pdname, ploc;

  -- COMMIT;
  
-- EXCEPTION
END;

-- Procedure UP_DINSDEPT이(가) 컴파일되었습니다.
SELECT * FROM dept;

EXEC UP_DINSDEPT( 'QC', 'SEOUL');

ROLLBACK;

예4) 익명프로시저를 사용해서  동적쿼리 + DDL ( CREATE 문 )

DECLARE 
  vsql varchar2(1000);
  vtableName varchar2(20);
BEGIN
   vtableName := 'tbl_nds';
   vsql := 'CREATE TABLE ' || vtableName ;
   -- vsql := 'CREATE TABLE  :tableName ' ;
   vsql := vsql || ' ( ' ;
   vsql := vsql || '         id number primary key  ' ;
   vsql := vsql || '         , name varchar2(20)  ' ;
   vsql := vsql || ' ) ' ;
   
   DBMS_OUTPUT.PUT_LINE( vsql );
   
   EXECUTE IMMEDIATE vsql;
                 -- USING vtableName;
   
END;
-- PL/SQL 프로시저가 성공적으로 완료되었습니다.

DESC tbl_nds;

예5) [OPEN FOR] 문 설명 ? [동적 SQL] 의 실행 결과가 [여러 개의 레코드(행)] 반환하는 [SELECT]문 + [커서]

CREATE OR REPLACE PROCEDURE up_nds02
(
  pdeptno dept.deptno%type
)
IS
  vsql varchar2(1000);
  vrow emp%ROWTYPE;
  vcursor SYS_REFCURSOR; -- 9i  REF CURSOR
BEGIN
   vsql := 'SELECT * ';
   vsql := vsql || 'FROM emp ';
   vsql := vsql || 'WHERE deptno = :deptno ';
   
   -- X EXECUTE IMMEDIATE 동적쿼리   
   -- OPEN FOR 문 사용한다. 
   OPEN  vcursor FOR vsql USING pdeptno;
   
   LOOP
      FETCH vcursor INTO vrow;
      EXIT WHEN vcursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE( vrow.empno || ', ' || vrow.ename );
   END LOOP;
   
   CLOSE vcursor;
END;

-- Procedure UP_NDS02이(가) 컴파일되었습니다.
EXEC UP_NDS02( 30 );
EXEC UP_NDS02( 10 );















