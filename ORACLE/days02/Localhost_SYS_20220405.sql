-- [ LocalHost_SYS_20220405.sql 파일로 저장 ]--

-- 블럭 단위로 주석처리 :    Ctrl + /

-- 1. SQL ? Structured Query Language
--          오라클 서버           DATA 조작 질의/응답              클라이언트 툴
-- 2. SQL 5가지 종류 
--       DQL : Query 조회, 검색 - [SELECT] 문
--       DDL : 정의             - [CREATE], [ALTER], DROP 문
--       DML : 조작             - [INSERT], UPDATE, DELETE 문  +                커밋(Commit) 또는 롤백(rollback)
--       DCL : 컨트롤        권한 부여,제거 - [GRANT], REVOKE 문
--       TCL : 컨트롤            - [COMMIT], ROLLBACK, SAVEPOINT 문       

-- SCOTT 계정 / tiger 비밀번호 계정 생성       +  권한 부여
CREATE USER  계정명 IDENTIFIED BY 비밀번호;
                                   추가옵션
                                   추가옵션
                                   추가옵션
-- 접속한 계정(SYS)이 권한이 있어야                                   
-- SCOTT 계정을 삭제
-- 계정을 삭제할 때 CASCADE 옵션을 추가하면 삭제할 계정이 소유하는 모든 객체도 삭제.
DROP USER scott CASCADE;
-- User SCOTT이(가) 삭제되었습니다.

--명령의 22 행에서 시작하는 중 오류 발생 -
--DROP USER scott CASCADE
--오류 보고 -
--ORA-01940: cannot drop a user that is currently connected
--01940. 00000 -  "cannot drop a user that is currently connected"
--*Cause:    Attempt was made to drop a user that is currently logged in.
--*Action:   Make sure user is logged off, then repeat command.

       
-- 모든 사원 정보를 조회(검색) : DQL  SELECT문
SELECT *
FROM all_users;

-- 1. scott 계정 / tiger 비밀번호 계정 생성
CREATE USER scott IDENTIFIED BY tiger;
-- User SCOTT이(가) 생성되었습니다.

-- 2. 권한 부여
GRANT RESOURCE, CONNECT TO scott;

-- 3. SCOTT 계정으로 오라클 서버에 접속(연결==CONNECT)

-- 4. 모든 사용자 계정을 조회(검색) DQL
SELECT *
FROM all_users;
--        HR 계정 확인

-- 5. HR 계정으로 오라클 서버에 접속(연결==CONNECT)
-- 6. HR 계정의 비밀번호를 lion 으로 수정
ALTER USER hr IDENTIFIED BY lion;
-- User HR이(가) 변경되었습니다.
--     10:10 수업 시작~
-- 7. HR 계정이 잠금 조회(확인)
SELECT * 
FROM dba_users;
FROM all_users; -- 계정명, 계정ID, 생성일   컬럼만 확인(조회)

-- 8. HR 계정의 잠금 해제
ALTER USER hr ACCOUNT UNLOCK;

-- 9.  계정 비밀번호도 수정 + 잠금 상태 해제
ALTER USER hr IDENTIFIED BY lion
               ACCOUNT UNLOCK;

-- 데이터( DATA ) ? 정보(자료)
-- 데이터베이스( DATABASE ) ? 데이터 집합
-- DBMS ? 소프트웨어
-- 데이터 모델 ? 관계형 데이터 모델
-- RDBMS = R + DBMS            오라클
-- 관계형 3 핵심 구성 요소  : 개체(릴레이션, 테이블), 속성( 열, 컬럼 ), 관계
 
ALTER USER SCOTT DEFAULT TABLESPACE USERS;  -- SYSTEM
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;



-- SCOTT 소유자 emp
SELECT *
FROM emp;

ORA-00942: table or view does not exist
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:
83행, 6열에서 오류 발생




