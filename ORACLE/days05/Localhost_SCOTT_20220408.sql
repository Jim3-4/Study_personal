-- SCOTT 계정 접속 -- 

7. SET(집합) 연산자
  ㄱ. UNION 연산자     - 합집합 
  ㄴ. UNION ALL 연산자 - 합집합 + ALL
  ㄷ. INTERSECT 연산자 - 교집합
  ㄹ. MINUS 연산자     - 차집합
  
  9:50분 문제 + 10 쉬는 시간
  10:00 수업시작~

------------------------------------------------------------------------------------

1. 오류 메시지에 대해서 설명하세요 .
 ㄱ. ORA-01438: value larger than specified precision allowed for this column
     dname varchar2(14)  14byte   '아름다운부서'  3byte*6=18byte
     
 ㄴ. ORA-00001: unique constraint (SCOTT.PK_DEPT) violated
    INSERT             deptno = 30 고유키 중복되기 때문에 PK 위배된다. 
    
 ㄷ. ORA-00923: FROM keyword not found where expected 
   SELECT
   FROM 절 앞 뒤에 구문 잘못되었다. 
   
 ㄹ. ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found
    dept - pk(deptno)10,20,30,40  부모테이블    
    관계 
    emp  - fk(deptno)  60 부서 사원 추가 자식테이블

 
2. RR과  YY의 차이점에 대해서 설명하세요 .
  RR    50~99  1900년대     0~ 49  2000년대
  YY    2000년대
  현재 시스템의 2000년대/21세기

3. JAVA :  5 % 2  코딩을 오라클로 나머지 구해서 출력하는 쿼리를 작성하세요.
  SELECT MOD(5,2)   -- MOD() 함수      JAVA % X     FLOOR()
        , REMAINDER(5,2)                        -- ROUND()    
  FROM dual;

4. dept 테이블을 사용해서 각 DML문의 형식을 적고, 쿼리 작성하고 실행하세요. 

   INSERT INTO 테이블명 ( 컬럼명,,, ) VALUES ( 컬럼값,,, );
   UPDATE 테이블명
   SET 컬럼명=컬럼값 [,컬럼명=컬럼값,컬럼명=컬럼값,..]
   [WHERE 조건절;]
   DELETE FROM 테이블명
   [WHERE 조건절;]   
   커밋, 롤백

 ㄱ. 새로운 부서를 추가(insert)하는 쿼리 작성 및 확인 
    1) (  50, QC, SEOUL )
    INSERT INTO dept ( deptno, dname, loc ) VALUES ( 50, 'QC', 'SEOUL' );
    2) (  60, T100%, SEOUL )
    3) (  70, T100T, BUSAN )
    
 ㄴ. 60번 부서의 부서명,  지역명을 수정 
     ( 원래 부서명 뒤에 'X' 문자열 추가해서 수정, 지역명은 DAEGU 로 수정 )    
    UPDATE dept
    SET dname= dname || 'X' , loc= 'DAEGU'
    WHERE deptno = 60;
    
 ㄷ. LIKE 연산자를 사용해서 부서명에 '%' 문자가 포함된 부서 정보 조회하는 쿼리 작성
     ( ESCAPE 옵션 이해 ? 와일드카드 %가 아니라 부서명을 나타내는 일반 문자로 처리. )
     WHERE dname LIKE '%\%%' ESCAPE '\';
     
 ㄹ. REGEXP_LIKE() 함수를 사용해서 부서명에 '%' 문자가 포함된 부서 정보 조회하는 쿼리 작성
     WHERE REGEXP_LIKE( dname, '%' );
     
 ㅁ. 부서번호 50, 60, 70번 부서 삭제
     DELETE FROM dept
     WHERE deptno BETWEEN 50 AND 70 ;  -- >=  <= 비교연산자
     WHERE deptno IN ( 50, 60, 70 );
     WHERE deptno >= 50; 
     
    COMMIT;
 
5. 한글 한 문자와 알파벳 한 문자가 몇 바이트인지 출력하는 쿼리 작성
   VSIZE() 오1라클 함수 기억?
   SELECT VSIZE('가'), VSIZE('a')
   FROM dual;

6. insa 테이블에서 남자는 'X', 여자는 'O' 로 성별(gender) 출력하는 쿼리 작성

    NAME                 SSN            GENDER
    -------------------- -------------- ------
    홍길동               771212-1022432    X
    이순신               801007-1544236    X
    이순애               770922-2312547    O
    김정훈               790304-1788896    X
    한석봉               811112-1566789    X
    
    -- 1. 
    SELECT t.*
            , REPLACE(    REPLACE( t.gender ,'1','X') , '2', 'O') gender
    FROM (      -- 인라인 뷰( inline view )
                SELECT name, ssn
                     , SUBSTR(  ssn, -7, 1 ) gender 
                FROM insa
          ) t;
          
    -- 2. null 관련된 함수 :      NVL(?,?), NVL2(?,?,?) ,  NULLIF(?,?)  같으면 null 반환, 같지않으면 ? 반환
    SELECT name, ssn
    , SUBSTR( ssn, -7, 1) gender
    , MOD( SUBSTR( ssn, -7, 1), 2 ) gender  -- 0 여자  1 남자
    , NVL2(  NULLIF(  MOD( SUBSTR( ssn, -7, 1), 2 ) , 1 )  , 'O', 'X' ) gender
    FROM insa;
    
    -- 숫자 : 왼쪽 정렬되어져 있으면 문자열  '1'
    -- 숫자 : 오른쪽 정렬되어져 있으면 숫자   1

7. insa 테이블에서 2000년 이후 입사자 정보 조회하는 쿼리 작성

    NAME                 IBSADATE
    -------------------- --------
    이미성               00/04/07
    심심해               00/05/05
    권영미               00/06/04
    유관순               00/07/07
                :
    
    SELECT name, ibsadate
    FROM insa
    WHERE EXTRACT( YEAR FROM ibsadate ) >= 2000
    -- WHERE TO_CHAR( ibsadate, 'YYYY' ) >= 2000     --  오류?  '2000' >= 2000       
    -- X WHERE SUBSTR( ibsadate, 0, 2) >= '00'
    -- WHERE ibsadate >= '2000.01.01'
    ORDER BY ibsadate ASC;  -- 오라클 비교연산자 : 숫자, 문자, 날짜 비교
    
8-1. Oracle의 날짜를 나타내는 자료형 2가지를 적으세요.
   ㄱ. DATE
   ㄴ. TIMESTAMP
   
8-2. 현재 시스템의 날짜/시간 정보를 출력하는 쿼리를 작성하세요.

 -- SYSDATE 함수  : 현재 시스템의 날짜 + 시간 분 [초] 반환
 -- CURRENT_DATE 함수 : 현재 세션(session)의 날짜 + 시간 분 초 반환
--                     반환되는 DATE 데이터타입은 Gregorian calendar이다
--  CURRENT_TIMESTAMP함수 : 

-- 오라클 인스턴스        : DB서버 시작   -> 서버종료
-- 오라클 세션(session)  :  사용자 로그인 -> 로그아웃

SELECT (ㄱ), (ㄴ), (ㄷ)
SELECT SYSDATE, CURRENT_DATE, CURRENT_TIMESTAMP
FROM dual;

-- 22/04/08     22/04/08    22/04/08 10:52:18.000000000 ASIA/SEOUL


-- 11:05 수업 시작~
9. HR 계정으로 접속해서 
   SELECT * FROM scott.dept;
   위의 쿼리를 실행하면 ORA-00942: table or view does not exist 오류가 발생한다.
   그래서
   HR 계정에서도 scott.dept 테이블을 SELECT할 수 있도록 권한부여 및 arirang 이란 이름으로 
   시노님( SYNONYM )을 생성해서
   HR 계정에서도 SELECT * FROM arirang 쿼리를 사용할 수 있도록 설정하고 테스트하는 
   모든 쿼리를 순서대로 작성하세요. 
   
   시노님 제거 DROP PUBLIC SYNONYM arirang;
   권한 제거   REVOKE 문
   
10. emp 테이블에서 사원명(ename)에 'e'문자를 포함한 사원을 검색해서 아래와 같이 출력.

    ENAME   SEARCH_ENAME
    --------------------
    ALLEN	ALL[E]N
    JONES	JON[E]S
    BLAKE	BLAK[E]
    TURNER	TURN[E]R
    JAMES	JAM[E]S
    MILLER	MILL[E]R
    
    :변수명    
    ㄱ. 바인드 변수 ( bind variable )
    ㄴ. 세션(session)이 유지되는 동안 사용할 수 있는 변수
    
    SELECT ename
            , REPLACE( ename, UPPER( :input ) , '[' || UPPER(:input) || ']'  ) SEARCH_ENAME
    FROM emp
    WHERE REGEXP_LIKE( ename, :input , 'i' );

11.   UPDATE 문에 WHERE 조건절이 없는 경우는 어떻게 되나 ? 모든 레코드가 수정
11-2. DELETE 문에 WHERE 조건절이 없는 경우는 어떻게 되나 ? 모든 레코드가 삭제

12. DML( INSERT, UPDATE, DELETE ) 문 실행 후 반드시 무엇을 해 주어야 하나 ? 

------------------------------------------------------------------------------------
13. insa 테이블에서 
   ㄱ. 출신지역(city)가 인천인 사원의 정보(name,city,buseo)를 조회하고
   ㄴ. 부서(buseo)가 개발부인 사원의 정보(name,city,buseo)를 조회해서
   두 결과물의 합집합(UNION)을 출력하는 쿼리를 작성하세요. 
   ( 조건 : SET(집합) 연산자 사용 )
   
------------------------------------------------------------------------------------
SELECT name, city, buseo
FROM insa
WHERE city = '인천';

-- 9명 --
이순애	인천	개발부
이기자	인천	개발부
황진이	인천	개발부
엄용수	인천	개발부
정영희	인천	개발부
최석규	인천	홍보부
이미성	인천	개발부
전용재	인천	영업부
김신제	인천	기획부


SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';

-- 14명 --
이순애	인천	개발부
이기자	인천	개발부
장인철	제주	개발부
황진이	인천	개발부
이상헌	경기	개발부
엄용수	인천	개발부
이성길	전북	개발부
홍길남	경기	개발부
정영희	인천	개발부
채정희	경기	개발부
이기상	전남	개발부
이미성	인천	개발부
임수봉	서울	개발부
김신애	서울	개발부



SELECT name, city, buseo
FROM insa
WHERE city = '인천'
UNION   -- SET 연산자
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';

  3  [6]  8   == 17명
------------------------------------------------------------------------------------
SELECT name, city, buseo
FROM insa
WHERE city = '인천' OR buseo = '개발부';

------------------------------------------------------------------------------------

SELECT name, city, buseo
FROM insa
WHERE city = '인천'
UNION ALL
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';

 23명
 
 인천  인천&개발부   개발부
  3       6         8         U   17명
                              UA   23명   
 UNION / UNION ALL 차이점                               
------------------------------------------------------------------------------------
 SELECT ename, sal   -- , comm  ORA-01789: query block has incorrect number of result columns
 FROM emp 
 UNION
 SELECT name , basicpay  -- , buseo -- ORA-01790: expression must have same datatype as corresponding expression
 FROM insa;

------------------------------------------------------------------------------------

SELECT name, city, buseo
FROM insa
WHERE city = '인천'
MINUS -- 차집합
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';
김신제	인천	기획부
전용재	인천	영업부
최석규	인천	홍보부

SELECT name, city, buseo
FROM insa
WHERE city = '인천' AND buseo != '개발부';

------------------------------------------------------------------------------------

SELECT name, city, buseo
FROM insa
WHERE city = '인천'
INTERSECT -- 교집합
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부'; 

엄용수	인천	개발부
이기자	인천	개발부
이미성	인천	개발부
이순애	인천	개발부
정영희	인천	개발부
황진이	인천	개발부

SELECT name, city, buseo
FROM insa
WHERE city = '인천' AND buseo = '개발부';

------------------------------------------------------------------------------------
IS NAN  == NOT A NUMBER
IS INFINITE == 무한대
IS NULL  널이니?

----오라클 함수--------------------------------------------------------------------------------
1. 함수 ?   복잡한 쿼리문 -> 간단히 처리(조작) -> 결과 반환
2. 함수기능
  ㄱ. 데이터 계산    루트4 == 2   sqrt(4)
  ㄴ. 데이터 변경    UPPER( 'abc' )
  ㄷ. 그룹의 결과를 출력       그룹함수( group function ) == 집계함수   COUNT()
  ㄹ. 날짜 형식을 변경  TO_CHAR( 날짜형 )
  ㅁ. 컬럼 데이터 타입 변경  ==  형변환함수
     날짜형 <-> 문자열  변경
     문자열 <-> 숫자형
     
     중복함수(== 오버로딩)
     TO_CHAR( 날짜 ) ***
     TO_CHAR( 숫자 )
     TO_CHAR( 문자열 )
  
  문제) insa테이블에서    총 사원수가 몇명인지 ? 60
  SELECT COUNT(*) 총사원수
  FROM insa
  WHERE buseo = '영업부';
  
  문제) emp 테이블에서 각 부서별 사원수와 총 사원수를 파악(조회)
  
  10번 부서 : 3명
  20번 부서 : 3명
  30번 부서 : 6명
  40번 부서 : 0명
  총사원수 : 12명
  
  
  SELECT COUNT(*) 
  FROM emp
  WHERE deptno = 10
  UNION ALL
  SELECT COUNT(*) 
  FROM emp
  WHERE deptno = 20
  UNION ALL
  SELECT COUNT(*) 
  FROM emp
  WHERE deptno = 30
  UNION ALL
  SELECT COUNT(*) 
  FROM emp
  WHERE deptno = 40
  UNION ALL
  SELECT COUNT(*) 
  FROM emp;
  
3. 함수의 종류(유형)
12:06 수업 시작~

   ㄱ. 단일행 함수
SELECT ename, UPPER( ename )
       , LOWER( ename ) 
FROM emp

   ㄴ. 복수행 함수 == 그룹함수 ( 집계함수 )
SELECT COUNT(*)   
FROM emp;


4. 단일행 함수 중에   "숫자 함수"
SELECT SQRT(4)   -- 제곱근, 루트
       -- , SIN()       , COS()       , TAN()
       -- , LOG()
       -- , LN() 자연로그값
       , POWER( 2, 3) -- 누승  Math.pow()
       , MOD( 5, 2 )
       , ABS( 100), ABS(-100) -- 절대값   100   Math.abs()
FROM dual;
  ㄱ. ROUND(  NUMBER [, -위치] )  :  "특정 위치"에서 반올림하는 함수
      【형식】
	   ROUND ( n [,integer])
       ROUND(a,b)는 
       - a를 [소수점 이하 b+1자리에서 반올림하여 b자리까지 출력한다.]
       - [ b가 없으면(== b 0 )  소수점 첫번째 자리(  b+1 )에서 반올림 ]
       - , b값이 음수이면 소수점 왼쪽 b자리에서 반올림하여 출력한다.
       
SELECT  3.141592  PI
     , ROUND( 3.141592 , 0 )  -- 3           0+1 소숫점 첫번째 자리에서 반올림.
     , ROUND( 3.641592 , 0 )  -- 4
     , ROUND( 3.141592 , 2 )  -- 3.14 b2+1   소숫점 세번째 자리에서 반올림
     , ROUND( 123.141592 , -2 ) -- 100        10의 자리에서 반올림
FROM dual;

     문제) emp 테이블의 pay( sal + comm ) 총급여합(27125) / 총사원수(12) == 평균급여(pay)
        소숫점 3번째 자리에서 반올림한 평균급여를 출력하세요. 

SELECT COUNT(*) total_number  -- 12
FROM emp;

-- SUM() 집계함수== 그룹함수 == 복수행함수
SELECT  SUM( sal + NVL(comm, 0))    total_pay  -- 27125
FROM emp;

-- 2260.416666666666666666666666666666666667
-- 2260.42
SELECT ROUND( 27125/12 , 2 )   avg_pay
FROM dual;


SELECT ROUND( (SELECT  SUM( sal + NVL(comm, 0))  FROM emp ) / (SELECT COUNT(*) FROM emp) , 2 )   avg_pay
FROM dual;

SELECT  SUM( sal+ NVL(comm, 0) )
      , COUNT(*)
      , SUM( sal+ NVL(comm, 0) ) / COUNT(*)
FROM emp;
                절삭할 특정 위치
  ㄴ. TRUNC( n [, m])  절삭(내림)함수 + 절삭할 "특정 위치"                     ==> 정수값, 실수
      FLOOR()  절삭(내림)함수 + 무조건 소숫점 1번째 자리에서 절삭        ==> 정수값

     TRUNC( n ) == FLOOR( n ) == TRUNC( n, 0 )   m+1 == 절삭 위치


SELECT 123.141592
     , FLOOR( 123.141592 )  -- 123 소숫점 첫 번째 자리에서 절삭
     , FLOOR( 123.941592 )  -- 123 소숫점 첫 번째 자리에서 절삭
     , TRUNC( 123.941592 )
     , TRUNC( 123.941592, 0 )
     , TRUNC( 123.941592, 1 ) -- 123.9   소수점 두 번째 자리에서 절삭 (1+1)
     , TRUNC( 123.941592, -1 ) -- 120  일의 자리에서 절삭  
FROM dual;

   ㄷ. CEIL()  소숫점 첫 번째 자리에서 올림
               특정 위치에서 올림하는 함수 X
SELECT  CEIL( 3.141592 )  -- 4               
      , CEIL( 3.941592 )  -- 4             
FROM dual;               


   -- ROUND(), CEIL() , FLOOR(), TRUNC()

  문제) 게시판에서
       총 게시글 수 : 652 
       한 페이지에 출력할 게시글 수 : 15
       총 페이지 수 ? 44 페이지
       -- 43.46666666666666666666666666666666666667
       SELECT  CEIL(  652 / 15  )
       FROM dual;
  
  문제) 소숫점 3 자리에서 올림(절상) 
   힌트) 절상할 특정 위치를 소수점 1 자리로 맞춰서 CEIL() 절상 -> 다시
  문제)  십의 자리에서 절상(올림)  1300
  SELECT 1234.5678           --> 1234.57
     , CEIL( 1234.5678 * 100 )/100
     , CEIL( 1234.5678 / 100 )*100  -- 1300
  FROM dual;
  
  ㄹ. SIGN    숫자의 값에 따라   양수라면 1 , ㅇ 이라면 0 , 음수라면  -1 반환하는 함수
  【형식】
      SIGN( number )

  SELECT SIGN( 100) , SIGN( 0 ) , SIGN(-100)
  FROM dual;
  
  문제) emp 테이블에 평균 급여보다 많이 받으면 1 적게 받으면 -1 같으면 0이 출력되도록 하자.
       많다
       적다
  SELECT t.*
        , ABS( t.pay - t.avg_pay )
         , SIGN( t.pay - t.avg_pay )
         , NVL2( NULLIF( SIGN( t.pay - t.avg_pay ), 1), '평균 급여보다 적다', '평균 급여보다 많다')
  FROM (
          SELECT ename, sal + NVL(comm, 0) pay
               -- , ROUND(  AVG( sal + NVL( comm, 0) ), 2  )  avg_pay
               , ( SELECT   ROUND(  AVG( sal + NVL( comm, 0) ), 2  )   FROM emp ) avg_pay
          FROM emp
       ) t;
  오류 -
  ***** ORA-00937: not a single-group group function
          단일 그룹   그룹함수가 아니다.
  
  -- AVG() 집계함수
  SELECT AVG( sal + NVL( comm, 0) )
     , ROUND(  AVG( sal + NVL( comm, 0) ), 2  )  avg_pay
  FROM emp;
  --
  SELECT COUNT(*), AVG(sal), SUM(sal)
  FROM emp;
  
 -- 문자함수 --
 SELECT 'Kbs'
       , UPPER( 'Kbs' )  -- 'KBS'
       , LOWER( 'Kbs' )  -- 'kbs'       
       , INITCAP('admin') -- Admin
 FROM dual;
 
 SELECT job
    , LENGTH( job ) -- 문자열 길이
    , CONCAT(  empno, ename ) -- 문자열 연결
 FROM emp;
  
 -- INSTR ( string, substring [, position [,occurrence] ] )   0
 SELECT   ename
       , INSTR( ename , 'IN' )
       -- JAVA    indexOf()   lastIndexOf()      -1
 FROM emp;  
  
 --                                [, position 찾기시작위치 [,occurrence 발생]
SELECT 
      instr( 'corporate floor','or' ) 
   ,  instr('corporate floor','or',      3) 
   ,  instr('corporate floor','or',      3,       2) 
   ,  instr('corporate floor','or',      -3,       2) 
FROM dual;
  
  문제) 전화번호 테이블 
       테이블명 TBL_TEL
       번호(순번)  NUMBER
       전화번호    02)123-1234
                  054)7223-2323
                  031)9837-8933
-- CREATE TABLE 테이블명

SELECT *
FROM tbl_tel;

  문제) 오라클 숫자, 문자 함수를 사용해서 
   번호 / 전화번호의 지역번호만 출력/ 전번1 만 출력/ 전번2 /만 출력
-- [ 출력결과  ]
--번호(no)   지역번호          전번1               전번2
--1          02               123               4567
--2          054              76322             9867   

SELECT no, tel
       , INSTR( tel , ')' )      ") 위치"
       , INSTR( tel, '-' , -1 )     "- 위치"
       , SUBSTR( tel, 0, INSTR( tel , ')' )-1) 
       , SUBSTR( tel, INSTR( tel , ')' ) +1 , INSTR( tel, '-' , -1 ) - INSTR( tel , ')' ) -1 ) 
       , SUBSTR( tel, INSTR( tel, '-' , -1 )+1  ) 
FROM tbl_tel;

-- RPAD / LPAD
【형식】
      RPAD (expr1, n [, expr2] )
--  ORA-01722: invalid number
SELECT ename, sal + NVL( comm, 0 ) pay
         , LPAD( '\' || ( sal + NVL( comm, 0 ))  , 10  , '*'      )
         , RPAD(  sal + NVL( comm, 0 )  , 10  , '*'      )
FROM emp;

-- [문제]
SELECT ename, sal + NVL( comm, 0 ) pay
     ,  ROUND(  (sal + NVL( comm, 0 )) / 100   ) "#갯수"
     ,  RPAD( ' ', ROUND(  (sal + NVL( comm, 0 )) / 100   ) + 1 , '#' )
FROM emp;

SMITH	800	8	 ########
ALLEN	1900	19	 ###################
WARD	1750	18	 ##################
JONES	2975	30	 ##############################
MARTIN	2650	27	 ###########################
BLAKE	2850	29	 #############################
CLARK	2450	25	 #########################
KING	5000	50	 ##################################################
TURNER	1500	15	 ###############
JAMES	950	10	 ##########
FORD	3000	30	 ##############################
MILLER	1300	13	 #############

 4:11 수업시작~
  문제) 
SELECT name, ssn  
   , RPAD(  SUBSTR( ssn, 0 , 7 ) , 14 , '*'  )
FROM insa;
 
-- ASCII( char )     오라클 문자 자료형  : char
SELECT ename
       , SUBSTR( ename, 0, 1 )
       , ASCII( SUBSTR( ename, 0, 1 ) ) 
       , ASCII( '가' )  -- 3바이트
       , CHR( 65 )
       , CHR( 15380608 )
FROM emp;

-- GREATEST( ? , ? , ? ... )
-- LEAST( ? , ? , ? )
SELECT 
      GREATEST( 500, 10, 200, 10000, 2 )  -- 숫자 
      , LEAST( 500, 10, 200 )
      , GREATEST( 'KBS', 'ABC'  , 'XYZ'  )  -- 문자
FROM dual;

-- 날짜 함수 --
SELECT SYSDATE
      , CURRENT_DATE
      , CURRENT_TIMESTAMP
FROM dual;


    TRUNC( date ) 날짜 절삭(내림)     
    ROUND( date ) 날짜 반올림         

-- 숫자 함수 --
    TRUNC( number ) 절삭(내림)    특정 위치
    ROUND( number ) 반올림        특정 위치



-- X ROUND( date [, format ] )
SELECT SYSDATE        -- 22/04/08	
    , ROUND( SYSDATE )-- 22/04/[09]   오후 4:27  "정오를 기준으로 반올림"
    , ROUND( SYSDATE , 'DD' )
    , ROUND( SYSDATE , 'MM' )
    , ROUND( SYSDATE , 'YY' )
    , ROUND( SYSDATE , 'DAY' ) -- 요일
FROM dual;

-- TRUNC( date ) 자주 사용.. *** 절삭
SELECT SYSDATE               -- 22/04/08 16:34:50
       , TRUNC(  SYSDATE )   -- 22/04/08 00:00:00 절삭
       , TRUNC(  SYSDATE , 'DD')
       , TRUNC(  SYSDATE , 'MM')
       , TRUNC(  SYSDATE , 'YY')
FROM dual;


-- 날짜형 + 숫자 = 날짜형
-- 날짜형 - 숫자 = 날짜형
-- 날짜형 - 날짜 = 일수(숫자)             일수
-- 날짜형 + 숫자/24 = 날짜형

SELECT SYSDATE   -- 22/04/08 
  , SYSDATE + 3  -- 22/04/11
  , SYSDATE - 3  -- 22/04/05
FROM dual;


-- 문제)emp 테이블에서 사원들의 근무일수 조회
SELECT ename, hiredate   -- DATE 날짜자료형
       , SYSDATE  -- DATE 날짜자료형
       , CEIL( ABS( hiredate - SYSDATE ) ) "근무일수" -- 날짜-날짜 = 근무일수
       -- 지금부터 2시간 후에 만나 ?
       , TO_CHAR( SYSDATE - 2/24, 'YYYY/MM/DD  HH24:MI:SS')
FROM emp;


-- MONTHS_BETWEEN 함수 부터 ~ [월]





