-- SCOTT 계정 접속 -- 

--9:40 까지 문제 풀고
--9:41 수업시작~
-----------------------------------------------------------------------------------
1. EMP 테이블의 사원수를 조회하는 쿼리 작성.
    집계함수 / 그룹함수 / 복수행 함수
    COUNT(), SUM(), AVG()
    MAX(), MIN()
    STDDEV() 표준편차, VARIANCE() 분산
    
-- *** ORA-00937: not a single-group group function    
SELECT COUNT(*) 사원수  -- 12명    NULL 값도 포함한 레코드(행) 갯수를 카운팅하겠다.
       -- , COMM
       --, COUNT( COMM ) -- 4   *** 주의할 점) NULL  값을 제외한 ***
       --, SUM( sal + NVL( comm, 0 ) ) total_pay  -- 총급여합
       --, SUM( sal + NVL( comm, 0 ) )/COUNT(*)   --평균급여
       --, AVG( sal + NVL( comm, 0 ) ) avg_pay
       , MAX( sal + NVL( comm, 0 ) ) max_pay -- 최고급여액
       , MIN( sal + NVL( comm, 0 ) ) mix_pay -- 최저급여액
FROM emp;    

 문제)  10:06 수업 시작~ 
      emp 테이블에서 최고급여액을 받는 사원의 정보를 출력(조회)
      ( deptno, ename, job, hiredate 등등 )
SELECT MAX( sal + NVL(comm, 0) )   max_pay 
FROM emp;

SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MAX( sal + NVL(comm, 0) )   max_pay FROM emp);

WHERE  sal + NVL(comm, 0) = 5000;

문제) emp 테이블에서 최저급여액 받는 사원의 정보 조회.

SELECT MIN( sal + NVL(comm, 0)  ) min_pay
FROM emp;

SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MIN( sal + NVL(comm, 0) )   max_pay FROM emp);

문제) emp 테이블에서 최고, 최저 급여를 받는 사원의 정보를 조회(출력)
-- 1. 
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MIN( sal + NVL(comm, 0) )   max_pay FROM emp)
UNION
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MAX( sal + NVL(comm, 0) )   max_pay FROM emp);
-- 2. 
SELECT *
FROM emp
WHERE sal + NVL(comm, 0) = ( SELECT MIN( sal + NVL(comm, 0) )   max_pay FROM emp)
      OR
     sal + NVL(comm, 0) = ( SELECT MAX( sal + NVL(comm, 0) )   max_pay FROM emp);
-- 3.  IN ( LIST ) 

SELECT *
FROM emp
WHERE sal + NVL(comm, 0) IN ( ( SELECT MIN( sal + NVL(comm, 0) )   max_pay FROM emp)
                            , ( SELECT MAX( sal + NVL(comm, 0) )   max_pay FROM emp) );
                            
-- 주의( 기억) 
SELECT *
FROM emp
WHERE sal + NVL(comm, 0 )
         IN (SELECT MIN( sal + NVL(comm, 0) )  , MAX( sal + NVL(comm, 0) ) FROM emp );
WHERE sal + NVL(comm, 0) IN ( ( SELECT MIN( sal + NVL(comm, 0) )  , ( SELECT MAX( sal + NVL(comm, 0) )   FROM emp) );


SELECT MIN( sal + NVL(comm, 0) ) 
     , MAX( sal + NVL(comm, 0) )  
FROM emp

-- 최고급여자, 최저급여자
SELECT *
FROM emp
WHERE  sal + NVL(comm, 0) <= ALL ( SELECT sal+NVL(comm, 0) FROM emp );
WHERE  sal + NVL(comm, 0) >= ALL ( SELECT sal+NVL(comm, 0) FROM emp );
800
1900
1750
2975
2650
2850
2450
5000
1500
950
3000
1300


SELECT *
FROM emp
-- WHERE 조건절의 서브쿼리의 결과가 존재한다면 true 반환
WHERE EXISTS ( SELECT DISTINCT mgr FROM emp WHERE mgr IS NOT NULL );
WHERE EXISTS( SELECT deptno FROM dept );

2. 현재 시스템의   날짜를 출력하는 쿼리 작성
SELECT SYSDATE   --현재 시스템의 날짜/시간
  , CURRENT_DATE -- 세션의 날짜/시간
  , CURRENT_TIMESTAMP --            + 나노초 ( 확장 )
FROM dual;

3. SQL 집합 연산자의 종류와 설명을 하세요
   UNION
   UNION ALL
   INTERSECT
   MINUS
   
   주의사항 ) 컬럼 자료형, 컬럼 갯수 동일.


4. 함수 설명
  ㄱ. 반올림 함수를 선언형식을 적고 설명하세요             ROUND( , ??)
  ㄴ. 절삭(내림) 함수를 선언형식을 적고 설명하세요.        TRUNC(  , 0) == FLOOR()
  ㄷ. 절상(올림) 함수를 선언형식을 적고 설명하세요.        CEIL()
  
5. 게시판에서 총 게시글 수가 : 65 개 이고  한 페이지에 : 15개의 게시글 출력할 때
    총 페이지 수를 계산하는 쿼리 작성.
SELECT CEIL(65/15) 총페이지수    
FROM dual;    
    
6. emp 테이블에서 사원들의 평균 급여보다 많은 급여를 받으면 1
                                     적은 급여를 받으면 -1
                                     같으면           0 
  을 출력하는 쿼리 작성.
  
  -- PL/SQL
  SELECT t.ename, t.pay, t.avg_pay
--       , if( t.pay == t.avg_pay)   0
--          else if(    >                1
--          else                           -1
        , SIGN(  t.pay  - t.avg_pay  ) 
  FROM (
              SELECT ename, sal + NVL(comm, 0) pay
               --, AVG X
                 , ( SELECT  FLOOR(  AVG( sal + NVL(comm, 0) ))  FROM emp ) avg_pay
              FROM emp
  ) t;

7. insa테이블에서 80년대( 80년~89년생 )에 출생한 사원들만 조회하는 쿼리를 작성
  ㄱ. LIKE 사용
  WHERE ssn LIKE '8%'  -- 와일드카드  %  _
  ㄴ. REGEXP_LIKE 사용
  WHERE REGEXP_LIKE( ssn, '^8' );
  ㄷ. BETWEEN ~ AND 사용   
  WHERE SUBSTR( ssn, 0, 2) BETWEEN 80 AND 89;
  
8. insa 테이블에서 주민등록번호를 123456-1******  형식으로 출력하세요 . ( LPAD, RPAD 함수 사용  )
[실행결과]
홍길동	770423-1022432	770423-1******
이순신	800423-1544236	800423-1******
이순애	770922-2312547	770922-2******

     SUSTR( ssn, 0, 8 ) || '******')
     SELECT 
            RPAD( SUBSTR( ssn, 0, 8 ) , 14, '*')
     FrOM insa;

8-2. emp 테이블에서 30번 부서만 PAY를 계산 후 막대그래프를 아래와 같이 그리는 쿼리 작성
   ( 필요한 부분은 결과 분석하세요~    PAY가 100 단위당 # 한개 , 반올림처리 )
[실행결과]
DEPTNO ENAME PAY BAR_LENGTH      
---------- ---------- ---------- ----------
30	BLAKE	2850	29	 #############################
30	MARTIN	2650	27	 ###########################
30	ALLEN	1900	19	 ###################
30	WARD	1750	18	 ##################
30	TURNER	1500	15	 ###############
30	JAMES	950	    10	 ##########

SELECT deptno, ename, sal + NVL(comm,0) pay
        , ROUND( sal + NVL(comm,0), -2  )/100 bar_length
        , RPAD ( ' ', ROUND( sal + NVL(comm,0), -2  )/100 + 1 , '#' )
FROM emp
WHERE deptno = 30;

8-3. insa 테이블에서  주민번호를 아래와 같이 '-' 문자를 제거해서 출력
[실행결과]
NAME    SSN             SSN_2
홍길동	770423-1022432	7704231022432
이순신	800423-1544236	8004231544236
이순애	770922-2312547	7709222312547

SELECT ssn
   , REPLACE( ssn, '-', '')
   , INSTR( ssn, '-')
   , SUBSTR( ssn, 0, 6) || SUBSTR( ssn, -7 )
FROM insa;

9. emp 테이블에서 각 사원의 근무일수, [ 근무 개월수, 근무 년수 ]를 출력하세요.

날짜형 - 날짜형 = 일수
날짜형 + 숫자 = 일(숫자)이 더해진 날짜형
날짜형 - 숫자 =             빼진 날짜형
날자형 + 숫자/24 = 시간이 더해진 날짜형
날자형 - 숫자/24 = 시간이 빼진 날짜형

-- 근무일수 / 365 = 근무년수  + 윤년

-- 11:11 수업시작~~
SELECT empno, ename, hiredate        
            , CEIL(  ABS(hiredate - SYSDATE) ) 근무일수
FROM emp;

-- MONTHS_BETWEN() 함수 : 날짜, 날짜 사이의 개월수 리턴하는 함수
-- ORA-00904: "MONTHS_BETWEN": invalid identifier
SELECT  ROUND(  ABS( MONTHS_BETWEEN(hiredate , SYSDATE) ) ,2  )    근무개월수
      , ROUND( ABS( MONTHS_BETWEEN(hiredate , SYSDATE) ) / 12 , 2) 근무년수
FROM emp;


10. 개강일로부터 오늘날짜까지의 수업일수 ?   -- 토/일/공유일
( 개강일 : 2022.2.15 )

--            날짜형 - 날짜형 = 일수
-- ORA-00932: inconsistent datatypes: expected CHAR got DATE
--            불일치 자료형                      char     date
-- 오라클    '문자열'   '날짜형'
--  '2022.02.15' 날짜형이 아닌 문자열로 처리
--  문자열 - 날짜형   오류가 발생한 것.
--  문자열을 날짜형 형변환 ? 
--  C#   이름을 키보드로 부터 입력 화면(콘솔) 출력 ?
--         표준 입력              표준출력
-- 파이썬

-- TO_DATE() 함수로 형변환
-- 문자열( varchar2 , nvarchar2,  char , nchar ) -> 날짜형으로 형변환하는 함수
【형식】
     TO_DATE( char [,'fmt' [,'nlsparam']])
     
     
SELECT  TO_DATE( '2022.02.15' ) - SYSDATE
      -- ORA-01843: not a valid month
     ,  TO_DATE( '02/15/2022' , 'MM/DD/YYYY' ) - SYSDATE
FROM dual;


10-2.  오늘부터 수료일까지 남은 일수 ?  
( 수료일 : 2022.7.29 ) 

SELECT   CEIL( TO_DATE('2022.7.29') - SYSDATE )
FROM dual;

10-3. emp 테이블에서 각 사원의 입사일을 기준으로 100일 후 날짜, 10일전 날짜, 1시간 후 날짜, 3개월 전 날짜 출력

SMITH	80/12/17	81/03/27	80/12/07	80/12/17	81/03/17	80/09/17
ALLEN	81/02/20	81/05/31	81/02/10	81/02/20	81/05/20	80/11/20
WARD	81/02/22	81/06/02	81/02/12	81/02/22	81/05/22	80/11/22

SELECT ename, hiredate
         , hiredate + 100
         , hiredate - 10
         , hiredate + 1/24
         , ADD_MONTHS( hiredate, 3) -- 3개월 후   ADD_MONTHS(개월수)
         , ADD_MONTHS( hiredate, - 3 ) -- 3개월 전
FROM emp;

【형식】
    ADD_MONTHS(date, month)


-- MONTHS_BETWEEN() 개월차

SELECT t.f , t.s
       , MONTHS_BETWEEN( t.f, t.s )  -- 1.03225806451612903225806451612903225806
       , 1/31                        --   0.0322580645161290322580645161290322580645
FROM (
        SELECT TO_DATE('02-02-2022', 'MM-DD-YYYY')    f
              , TO_DATE('01-01-2022', 'MM-DD-YYYY')   s
        FROM dual
        ) t;

-- ADD_MONTHS() 함수
SELECT  ADD_MONTHS(TO_DATE('02-01-2022', 'MM-DD-YYYY'),  1)
       , ADD_MONTHS(TO_DATE('02-28-2022', 'MM-DD-YYYY'),  1)  -- 3-31
       , ADD_MONTHS(TO_DATE('02-27-2022', 'MM-DD-YYYY'),  1)  -- 3-27
FROM dual;

--  LAST_DAY() 함수는 특정날짜가 속한 달(월)의 가장 마지막 날짜를 반환
--  년/월 /                "일(날짜)"만 얻어오고 싶다. 
SELECT  LAST_DAY( SYSDATE )
      , TO_CHAR( LAST_DAY( SYSDATE ), 'DD')
FROM dual;
    
    
  -- 돌아오는 수요일은 휴강입니다. / 다음 주 금욜일은 휴강입니다. 
 -- NEXT_DAY() 함수 : 명시된 요일이 돌아오는 [가장 최근의 날짜]를 리턴하는 함수

SELECT SYSDATE
    -- 1(일) 2(월) ~ 7(토)
   ,  TO_CHAR( SYSDATE, 'D' ) ,  TO_CHAR( SYSDATE, 'DY' ),  TO_CHAR( SYSDATE, 'DAY' )
   , NEXT_DAY( SYSDATE, '금요일')
   , NEXT_DAY( SYSDATE, '월요일')
FROM dual;
 
11. function 설명
 ㄱ. ASCII()
 ㄴ. CHR()
 ㄷ. GREATEST()
 ㄹ. LEAST()
 ㅁ. UPPER()
 ㅂ. LOWER()
 ㅅ. LENGTH()
 ㅇ. SUBSTR()
 ㅈ. INSTR()
 
 SELECT ASCII('가'), ASCII('A')
       , CHR(15380608) , CHR(65)
       , GREATEST( 1,2,3,4,5), LEAST( 1,2,3,4,5)
       , LENGTH('abc')
       , INSTR( 'kenik', 'e')
 FROm dual;
 
 -- *****  날짜 절삭하는 것 이해(암기)
12. SELECT TRUNC( SYSDATE, 'YEAR' ) -- 2022/01/01
      , TRUNC( SYSDATE, 'MONTH' )     -- 2022/04/01
      , TRUNC( SYSDATE  )    -- 2022/04/11 00:00:00
    FROM dual;
    위의 쿼리의 결과를 적으세요 . 
    
    --                  2022/04/11 12:00:06
    SELECT  TO_CHAR(  SYSDATE , 'YYYY/MM/DD HH24:MI:SS' )
    FROM dual;
-----------------------------------------------------------------------------------    

-- 12:13 수업시작~
-- 문제) 이번 달 몇일 남았나요 ? 
SELECT SYSDATE
           , LAST_DAY( SYSDATE)
           -- , 날짜 - 날짜 = 일수
           , LAST_DAY( SYSDATE) - SYSDATE
FROM dual;

-- 오라클 형변환 함수 --
1. TO_NUMBER()  : 문자 -> 숫자 형변환
2. TO_DATE()
3. TO_CHAR()   : 숫자,날짜 -> 문자 형변환

SELECT TO_NUMBER( '10' )  -- 왼쪽 정렬 
       , 10  -- 오른쪽 정렬
       , TO_NUMBER( '10' ) + 10  -- '10' + 10   자동으로(암시적으로)  문자 -> 숫자 변환된다. 
FROM dual;
'10' -> 10 변환

-- insa테이블에서 남자 출력
SELECT *
FROM insa
-- WHERE    '2' = 1;  -- 암시적으로 형변환
WHERE TO_NUMBER( SUBSTR( ssn, -7, 1)) =  1; -- '1' 문자
-- MOD( TO_NUMBER( SUBSTR( ssn, -7, 1) ), 2 )


-- TO_DATE() 숫자,문자 -> 날짜
SELECT  TO_DATE( '2022.2.15' )
     , TO_DATE( '02/15/2022' , 'MM/DD/YYYY' )
     , TO_DATE( '2022' , 'YYYY' )  -- 22/04/01
     -- 2022 년도만 있는 문자열을 TO_DATE() 함수로 날짜로 변환하면 월은 해당월(4), 일( 1) 설정
     , TO_DATE('2022.03', 'YYYY.MM') -- 일( 1 ) 설정
     , TO_DATE( '20', 'DD'  ) -- 22/04/20
FROM dual;


SELECT SYSDATE today
--        , TO_CHAR( SYSDATE, 'YYYY' )  년도  -- 날짜 ->  문자열 '2022' 년도만 가져옴.
--        , TO_CHAR( SYSDATE, 'YY' ) 
--        , TO_CHAR( SYSDATE, 'MM' ) 월
--        , TO_CHAR( SYSDATE, 'DD' ) 일
--        , TO_CHAR( SYSDATE, 'HH' ) 시간
--        , TO_CHAR( SYSDATE, 'HH24' ) 시간
--        , TO_CHAR( SYSDATE, 'MI' ) 분
--        , TO_CHAR( SYSDATE, 'SS' ) 초
--        , TO_CHAR( SYSDATE, 'D' ) 요일  -- 일(1) ~ 토(7)
--        , TO_CHAR( SYSDATE, 'DY' ) 요일
--        , TO_CHAR( SYSDATE, 'DAY' ) 요일
--        , TO_CHAR( SYSDATE, 'CC' ) -- 21세기
--          , TO_CHAR( SYSDATE, 'Q' )  -- 2   (4월~6월)
--    , TO_CHAR( SYSDATE, 'WW' )  -- 15  년 중에 몇 번째 주
--    , TO_CHAR( SYSDATE, 'IW' )  -- 15  1년 중에 몇 번째 주
--    , TO_CHAR( SYSDATE, 'W' )    -- 2 월 중에 몇 번째 주
    , TO_CHAR( SYSDATE, 'TS' )    -- 오후 12:39:24
FROM dual;

-- 문제) 
-- SYSDATE -> TO_CHAR() 함수를 사용해서   '2022년 4월 11일 오후 12:40:12' 출력


SELECT SYSDATE
, TO_CHAR(SYSDATE, 'YYYY') || '년 ' || TO_CHAR(SYSDATE, 'MM') || '월 ' || TO_CHAR(SYSDATE, 'DD') || '일 ' || TO_CHAR(SYSDATE, 'TS') 날짜시간
, TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" TS' )
FROM dual;

-- 2022/04/11 오후 12:47:05

--      TO_CHAR( DATE )
-- **** TO_CHAR( NUMBER ) ****

SELECT 1234567
 -- 3자리마다 콤마 찍은 문자열로 변환    Java SimpleDateForamt sdf 
   , TO_CHAR( 1234567 , '9,999,999' )  -- ######
   , TO_CHAR( 1234567 , 'L9,999,999.99' )  -- ######  L 통화기호
   , TO_CHAR( 12 , '0999' )  -- 0012
FROM dual;

--
SELECT ename, TO_CHAR( sal + NVL(comm, 0 ) ,  'L9,999.00' ) pay
FROM emp;
-- 
SELECT name,  TO_CHAR( basicpay + sudang , 'L9,999,999' ) pay
FROM insa;

-- 문제) emp 테이블에서 각 사원의 입사일자를 기준으로 10년 5개월 20일째 되는 날은 ? 
SELECT ename, hiredate
     , ADD_MONTHS(  hiredate + 20, 10 * 12 + 5 )
FROM emp;

-- 문제)   문자열 '2021년 12월 23일' -> 날짜형으로 변환
--                   TO_DATE( 문자열 , 'fmt' )
--    ORA-01821: date format not recognized             /  .  ,
SELECT TO_DATE( '2021년 12월 23일' , 'YYYY"년" MM"월" DD"일"' )
FROM dual;

-- 문제)  insa 테이블에서 ssn 주민등록번호를 통해서  생일을 얻어오고
--       오늘을 기준으로 생일 지났다면 -1
--                                  0
--                     생일 지나지 않았다면 1
--       출력하는 쿼리 작성하자. 

-- 설문조사
SELECT name, ssn
      , TO_CHAR(   TO_DATE(  SUBSTR( ssn, 3, 4 ) , 'MMDD' ) , 'YYY/MM/DD HH24:MI:SS' )
      , TO_CHAR(   TRUNC( SYSDATE ) , 'YYY/MM/DD HH24:MI:SS' )
      , SIGN(   TO_DATE(  SUBSTR( ssn, 3, 4 ) , 'MMDD' ) - TRUNC( SYSDATE ) ) 
FROM insa; 


-- COALESCE () 값을 순차적으로 체크해서 NULL이 아닌 값을 반환하는 함수

형식】
        COALESCE(expr[,expr,expr,expr,expr,expr,expr,...])
--
SELECT ename, sal , comm
    ,  sal + NVL( comm, 0)    pay
    ,  sal + NVL2( comm, comm, 0) pay  -- 첫번째 값이 널이 아니면 두번째 값, 널이면 세번째값이 반환.
    ,  sal + COALESCE(comm, 0 ) pay
    , COALESCE(  sal + comm, sal , 0 ) pay
FROM emp;

-- ***** DECODE() 함수 *****
-- 1. 프로그램 언어( 자바)의 if문 
--     3.  if(  ==  ) 비교연산자     = 연산자만 사용가능.
-- 2. FROM 절에서만 사용할 수 없다.  X
-- 4. DECODE() 함수의 확장함수가 CASE() 함수이다. 
-- 5.  PL/SQL 에서 사용할 목적으로 만든 오라클 함수이다. 

-- 자바 --
int x = 10;
if( x == 11){
   return C;
}
--> DECODE(x,11,C);

if( x == 10){
     RETURN A
}else{
    RETURN B
}
--> DECODE( X, 10, A, B )

if(x == 1){
        A 
}else if( x == 10){
        B  
}else if( x == 12){
        C
}else if( x == 14){
        D 
}else{
        E
}
--> DECODE( x, 1, A, 10, B, 12, C, 14, D, E  )

-- 3:05 수업 시작~

--  문제)  insa 테이블에서  ssn 주민등록번호-> 생일을 얻어와서
--        생일 지났으면 1,   0 , 생일 지나지 않았으면 -1 출력.
--                   '생일 후', '오늘 생일', '생일 전'

/*
if( 생일 > 오늘 )   생일 후                        SIGN()  1 -1 0
else if( 생일 < 오늘 ) 생일 전
else    오늘 생일
*/
-- DECODE()를 사용하려면   <  > 비교 연산자 X ,                = 비교연산자만 사용

SELECT name, ssn
--       , SUBSTR( ssn, 3, 4)

--                   -1(생일전)  1(생일후) 0(오늘생일)
       ,  SIGN(  TRUNC( SYSDATE ) -  TO_DATE( SUBSTR( ssn, 3, 4) , 'MMDD' )  ) 
       
       , DECODE( SIGN(  TRUNC( SYSDATE ) -  TO_DATE( SUBSTR( ssn, 3, 4) , 'MMDD' )  ) 
                , -1 , '생일 전'
                , 1  , '생일 후'
                , '오늘 생일'  )
FROM insa;

-- 문제) insa 테이블에서 ssn을 가지고 '남자'/'여자'    라고 성별을 출력
--       (   DECODE ()  사용  )
-- 3:23 풀이

SELECT name, ssn
     , SUBSTR( ssn, -7, 1)  --  남자 1,3,5,7,9
     , DECODE(SUBSTR( ssn, -7, 1), 1 , '남자'
                                 , 3 ,  '남자'
                                 , 5 , '남자'
                                 , 7 , '남자'
                                 , 9 , '남자'
                                 , '여자')
    , DECODE( MOD( SUBSTR( ssn, -7, 1) , 2), 1, '남자', '여자') gender                              
FROM insa; 


-- 문제) insa테이블에서 남자 사원수, 여자 사원수 몇명인지 출력(조회)

SELECT '남자 사원수' "성별" , COUNT(*) "사원수"
FROM insa
WHERE    MOD( SUBSTR(ssn, -7, 1) , 2 ) = 1 
UNION
SELECT '여자 사원수' , COUNT(*)  
FROM insa
WHERE    MOD( SUBSTR(ssn, -7, 1) , 2 ) = 0 
UNION
SELECT '총 사원수' , COUNT(*)  
FROM insa;

-----------------------------
SELECT COUNT(*) 총사원수
      , COUNT(  DECODE(   MOD( SUBSTR(ssn, -7, 1) , 2 ) , 1 , '남자' ) ) 남자_사원수
      , COUNT(  DECODE(   MOD( SUBSTR(ssn, -7, 1) , 2 ) , 0 , '여자' ) ) 여자_사원수
FROM insa;

-- 아직 설명 X -- 
-- 여자  null
-- *****  ORA-00937: not a single-group group function ********
SELECT COUNT( * )
       , COUNT(  DECODE(  MOD( SUBSTR(ssn, -7, 1) , 2 ) , 1 ,'XXXXXXXX' ) ) gender
       , COUNT(  DECODE(  MOD( SUBSTR(ssn, -7, 1) , 2 ) , 0 ,'XXXXXXXX' ) ) gender
FROM insa;

-- 문제) emp 테이블에서  총사원수, 10번, 20번, 30번, 40번 사원수를 출력(조회)
SELECT COUNT(*)
FROM emp
UNION ALL
SELECT COUNT(*)
FROM emp
WHERE deptno =10
UNION ALL
SELECT COUNT(*)
FROM emp
WHERE deptno = 20
UNION ALL
SELECT COUNT(*)
FROM emp
WHERE deptno =30
UNION ALL
SELECT COUNT(*)
FROM emp
WHERE deptno =40;
--
SELECT COUNT(*) 총사원수
, COUNT( DECODE( deptno, 10, '10' ) ) 부서원10번
, COUNT( DECODE( deptno, 20, '10' ) ) 부서원20번
, COUNT( DECODE( deptno, 30, '10' ) ) 부서원30번
, COUNT( DECODE( deptno, 40, '10' ) ) 부서원40번
FROM emp;

-- 4:05 수업 시작~! 











