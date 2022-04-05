-- HR 계정 접속 --

-- 문제1) HT 계정이 소유한 테이블 목록 정보를 조회하는 쿼리(SQL)을 작성하세요.
SELECT *
FROM tabs;

-- 문제2) EMPLOYEES 테이블의 구조 확인하는  쿼리(SQL)을 작성하세요.
SELECT *
FROM EMPLOYEES; -- [컬럼명], 자료형, 크기 

DESC EMPLOYEES; 
DESCRIBE EMPLOYEES;
컬럼명           널허용    자료형(크기)
이름             널?       유형           
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)            사원ID  숫자(6)
FIRST_NAME              VARCHAR2(20) 
LAST_NAME      NOT NULL VARCHAR2(25) 
EMAIL          NOT NULL VARCHAR2(25) 
PHONE_NUMBER            VARCHAR2(20) 
HIRE_DATE      NOT NULL DATE         
JOB_ID         NOT NULL VARCHAR2(10) 
SALARY                  NUMBER(8,2)          숫자( 실수 ) 
COMMISSION_PCT          NUMBER(2,2)  
MANAGER_ID              NUMBER(6)    
DEPARTMENT_ID           NUMBER(4)    

-- 문제 3) EMPLOYEES 테이블에서 first_name 과 last_name 컬럼을 조회하는 쿼리를 작성하세요. 
--       조건1)  first_name 과 last_name 문자열 합쳐서 name  컬럼명으로 출력
SELECT first_name, last_name 
      --, 'full_name'
      -- , first_name + last_name -- 문자열 + 문자열
      , first_name || ' ' ||  last_name  AS "name"
      , concat( first_name ,  last_name ) "full name"  -- 별칭에 공백이 있는 경우는 반드시 " 붙인다. 
FROM employees;

ORA-00923: FROM keyword not found where expected
00923. 00000 -  "FROM keyword not found where expected"
*Cause:    
*Action:
35행, 8열에서 오류 발생


-- 오라클 연산자 중에 문자열을 연결(결합)연산자 ? 
--   오라클 연산자          +                덧셈 연산자 
--    자바 연산자          +                 덧셈 연산자, 문자열 연결 연산자          
--ORA-01722: invalid number
--01722. 00000 -  "invalid number"
--*Cause:    The specified number was invalid.

















