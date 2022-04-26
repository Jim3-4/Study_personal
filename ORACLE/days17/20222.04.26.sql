-- SCOTT 계정 접속 --  
-- 문제1) 회원가입할때 "ID 중복 체크" 하는 저장 프로시저
--       emp 테이블에서 empno( ID )
--       출력용 파라미터 선언         0   사용가능     1  사용불가능
CREATE OR REPLACE PROCEDURE up_idCheck
(
   pempno IN emp.empno%TYPE  -- ID
   , pempnoCheck OUT NUMBER  --  0(사용가능)     1(사용불가능)
)
IS
BEGIN
  SELECT COUNT(*) INTO pempnoCheck
  FROM emp
  WHERE empno = pempno;
--EXCEPTION
END;
-- Procedure UP_IDCHECK이(가) 컴파일되었습니다.
DECLARE
  vempnoCheck NUMBER;
BEGIN
   UP_IDCHECK( 1111, vempnoCheck );
   DBMS_OUTPUT.PUT_LINE( vempnoCheck );
END;

---
--문제2) 회원가입 한 후에
--       ID(empno)/PWD(ename) 입력하고 로그인(인증)
--        로그인 성공, 실패 ( ID X, PWD X)

CREATE OR REPLACE PROCEDURE up_logon
(
   pempno IN emp.empno%TYPE    -- ID
   , pename IN emp.ename%TYPE  -- PWD
   , plogonCheck OUT NUMBER  --  0(로그인성공)     1(ID존재하지않으면)  -1(ID o, PWD X)
)
IS
  vename emp.ename%TYPE;
BEGIN
  SELECT COUNT(*) INTO plogonCheck  -- 1   , 0
  FROM emp
  WHERE empno = pempno;
  
  IF plogonCheck = 1  THEN  -- ID 존재한다면 
    SELECT ename INTO vename
    FROM emp
    WHERE empno = pempno; 
    IF vename = pename THEN  -- PWD 일치한다면
      plogonCheck := 0;  -- 로그인 성공
    ELSE
      plogonCheck := -1;  -- 로그인 실패
    END IF;
  ELSE 
     plogonCheck := 1;  -- ID 존재하지 않는경우
  END IF;
--EXCEPTION
END;

-- Procedure UP_LOGON이(가) 컴파일되었습니다.
DECLARE
  vlogonCheck NUMBER;
BEGIN
   --UP_LOGON( 7369, 'SMITH', vlogonCheck ); -- 0
   --UP_LOGON( 7369, 'KENIK', vlogonCheck ); -- -1
   UP_LOGON( 1111, 'KENIK', vlogonCheck );   -- 1
   DBMS_OUTPUT.PUT_LINE( vlogonCheck );
END;

------------------------------------------------------------------------------------
-- 저장 함수( Stored Function )
SELECT num, name, ssn, CASE MOD( SUBSTR( ssn, -7, 1 ), 2) 
                           WHEN 1 THEN '남자'
                           ELSE '여자'
                       END gender
FROM insa;

-- ssn 주민등록번호를 파라미터로 넘겨주면 남자/여자 를 반환하는 저장 함수
-- 저장함수 == 저장 프로시저 같지만 차이점 ? 리턴값이 유무

CREATE OR REPLACE FUNCTION uf_저장함수명
( 
)
RETURN 리턴자료형
IS 
BEGIN 


   RETURN (리턴값);
   RETURN 리턴값;

--EXCEPTION
END;

-- 문제) 주민등록번호를 입력받아서 성별을 반환하는 함수 uf_gender

CREATE OR REPLACE FUNCTION uf_gender
( 
    prrn VARCHAR2 
)
RETURN VARCHAR2  -- '남자'  '여자'
IS 
  vgender VARCHAR2(6) := '여자';
BEGIN 

   IF  MOD( SUBSTR(prrn, -7,1), 2 ) = 1 THEN
      vgender := '남자';
   END IF;

   RETURN vgender; 

--EXCEPTION
END;

-- Function UF_GENDER이(가) 컴파일되었습니다.

SELECT num, name, ssn, uf_gender( ssn ) gender
FROM insa;

-- 문제) uf_sum( 10 )  
-- 1~10까지의 합을 반환하는 함수 + 테스트 코딩

CREATE OR REPLACE FUNCTION uf_sum
(
    pnum NUMBER
)
RETURN NUMBER
IS
    vsum NUMBER := 0;
BEGIN
    FOR vnum IN REVERSE 1 .. pnum
    LOOP
        --DBMS_OUTPUT.PUT_LINE( vnum );
        vsum := vsum + vnum;
    END LOOP;
    
    RETURN vsum;
--EXCEPTION
END;


SELECT uf_sum(10)
FROM dual;
 
-- 문제) 주민등록번호를 입력받아서 생년월일( yyyy.mm.dd )로 반환하는 함수 uf_birth()

CREATE OR REPLACE FUNCTION uf_birth
(
    prrn NUMBER
)
RETURN VARCHAR2
IS
    vbirth VARCHAR2(10);
    vgender NUMBER(1);
    vcentry NUMBER(2);
    vrrn6 VARCHAR2(6);
BEGIN
    -- 1900, 1800, 2000 
    vrrn6 := SUBSTR( prrn, 0, 6 ) ;
    vgender := SUBSTR( prrn, -7, 1);
    vcentry := CASE
               WHEN vgender IN ( 1,2,5,6 ) THEN 19
               WHEN vgender IN ( 3,4,7,8 ) THEN 20
               ELSE 18
            END;
            -- 19790123
   vbirth :=  TO_CHAR( TO_DATE( CONCAT( vcentry, vrrn6) ) , 'YYYY.MM.DD' );       
    RETURN vbirth;
--EXCEPTION
END;

SELECT name, ssn
    , uf_birth( ssn )
FROM insa;
/*
ORA-01722: invalid number
01722. 00000 -  "invalid number"
*Cause:    The specified number was invalid.
*Action:   Specify a valid number.
*/

-- 문제) 주민등록번호를 입력받아서 만나이를 반환하는 함수 uf_age()
-- 10:15 부터 수업 시작

CREATE OR REPLACE FUNCTION uf_age
(
  prrn VARCHAR2
)
RETURN NUMBER 
IS
   vischeck number(1);
   vt_year  number(4);
   vb_year  number(4);
   vage     number(3);
BEGIN
   vischeck :=  SIGN(  TRUNC( SYSDATE ) -  TO_DATE(  SUBSTR( prrn, 3,4), 'MMDD') );
   vt_year  := TO_CHAR( SYSDATE  , 'YYYY');
   vb_year  := CASE  
                 WHEN SUBSTR( prrn, 8, 1 ) IN (1,2,5,6) THEN '1900' + SUBSTR( prrn, 1,2)
                 WHEN SUBSTR( prrn, 8, 1 ) IN (3,4,7,8) THEN '2000' + SUBSTR( prrn, 1,2)
                 ELSE                                       '1800'  + SUBSTR( prrn, 1,2)
             END;
   vage     :=  CASE  VISCHECK
                WHEN -1 THEN  -- 생일 안지난것
                 vt_year - vb_year-1
                ELSE   -- 0, 1
                 vt_year - vb_year
            END  ;        
   RETURN vage;         
--EXCEPTION
END;
-- Function UF_AGE이(가) 컴파일되었습니다.
--
SELECT name, ssn, UF_AGE(ssn) age
FROM insa;

-- 예제) 저장 프로시저   MODE : IN, OUT,  IN OUT 입출력용 파라미터( 매개변수 )
--      전화번호  8765-8652
--               8765  전화번호 앞자리 만 출력용

CREATE OR REPLACE PROCEDURE up_tel
(
   pphone IN OUT VARCHAR2
)
IS
BEGIN
    pphone := SUBSTR( pphone , 0, 4 );
-- EXCEPTION
END;
-- Procedure UP_TEL이(가) 컴파일되었습니다.

DECLARE
  vphone VARCHAR2(9) := '8765-8652';
BEGIN
  up_tel( vphone );
  
  DBMS_OUTPUT.PUT_LINE( vphone );
END;




