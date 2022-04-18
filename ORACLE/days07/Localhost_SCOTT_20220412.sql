-- SCOTT 계정 접속 -- 

-- 김민/도성한
-- 9:50 + 10
-- 10:00 수업 시작~

      TO_CHAR()   숫자, 날짜 -> 문자열 형변환 함수

1.  TO_CHAR( 날짜 ,  'fmt') 함수에서 'format'에 사용되는 기호를 적으세요.
  ㄱ. 년도 : Y, [YY], YYY, [YYYY], SYYYY, I, IY, IYY, IYYY, IYYYY, YEAR, SYEAR , RR, RRRR
  ㄴ. 월 :  [MM], MONTH, MON
  ㄷ. 월의 일 : [DD]
      주의 일 : D
      년의 일 : DDD
  ㄹ. 요일 : DY, DAY
  ㅁ. 월의 주차 : W
      년의 주차 : WW, IW
  ㅂ. 시간/24시간 : HH, HH24 , HH12
  ㅅ. 분 : MI
  ㅇ. 초 : SS , 
  ㅈ. 자정에서 지난 초 : SSSSS  ms
  ㅊ. 오전/오후 : AM , PM
  
  TS
  DS , DL
  
2. 본인의 생일로부터 오늘까지 살아온 일수, 개월수, 년수를 출력하세요..

  생일 : '1993.12.10' (가정)
  
  -- ORA-01722: invalid number
  -- TO_DATE() 함수 :  문자열 -> 날짜 형변환
  -- MONTHS_BETWEN() 함수
  SELECT 
      -- SYSDATE - TO_DATE( '1993.12.10' , 'YYYY.MM.DD' ) -- 날짜-날짜=일수
      CEIL(  SYSDATE - TO_DATE( '1993.12.10'  ) ) "살아온 일수" -- 날짜-날짜=일수
      , MONTHS_BETWEEN(SYSDATE,TO_DATE( '1993.12.10'  ) ) 
      , MONTHS_BETWEEN(SYSDATE,TO_DATE( '1993.12.10'  ) ) / 12
  FROM dual;

   반올림 ROUND()
   절삭(내림) TRUNC(), FLOOR()
   절상(올림) CEIL()

3. emp  에서  comm 이 null 사원수 ?? 
 -- IS NULL, IS NOT NULL   SQL연산자
 
SELECT   COUNT( *  ) -- NULL 값을 제외한 집계
FROM emp
WHERE comm IS NULL;

SELECT COUNT( DECODE(  comm, null, 'O' ) )
FROM emp;

SELECT COUNT( 
         CASE
             WHEN  comm IS NULL THEN 'o'
             ELSE  null
         END
       )
FROM emp;

 
4. 
  4-1. 이번 달이 몇 일까지 있는 확인.\
  -- LAST_DAY()함수 사용
  SELECT SYSDATE
        , LAST_DAY(SYSDATE)
        , TO_CHAR( LAST_DAY(SYSDATE), 'DD' )
        , EXTRACT( DAY FROM LAST_DAY(SYSDATE))
  FROM dual;
  
  4-2. 오늘이 년중 몇 째 주, 월중 몇 째주인지 확인. 
   SELECT SYSDATE
       , TO_CHAR( SYSDATE, 'WW') -- 년
       , TO_CHAR( SYSDATE, 'IW') -- 년
       , TO_CHAR( SYSDATE, 'W')  -- 월
   FROM dual;
  

5. emp 에서  pay 를 NVL(), NVL2(), COALESCE()함수를 사용해서 출력하세요.
    
   SELECT sal + NVL( comm, 0 ) pay 
   
         , sal + NVL2( comm, comm,  0 ) pay 
         , NVL2( comm, sal+comm,  sal ) pay 
         
         , sal + COALESCE( comm, 0 ) pay 
         , COALESCE( sal + comm, sal, 0 ) pay
   FROM emp;

5-2. emp테이블에서 mgr이 null 인 경우 -1 로 출력하는 쿼리 작성
      ㄱ. nvl()
      ㄴ. nvl2()
      ㄷ. COALESCE()
SELECT e.* 
      , NVL( MGR, -1) 
      , NVL2( MGR, MGR,  -1) 
      , COALESCE( MGR, -1) 
FROM emp e;
--WHERE mgr IS NULL;


6. insa 에서  이름,주민번호, 성별( 남자/여자 ), 성별( 남자/여자 ) 출력 쿼리 작성-
    ㄱ. DECODE()
    ㄴ. CASE 함수

SELECT name, ssn
--       , SUBSTR( ssn, -7, 1 ) gender
--       , MOD( SUBSTR( ssn, -7, 1 ), 2 ) gender  -- 1, 0
       , DECODE(    MOD( SUBSTR( ssn, -7, 1 ), 2 ) , 1 , '남자', '여자'                 ) gender
       , CASE  MOD( SUBSTR( ssn, -7, 1 ), 2 )
               WHEN 1 THEN '남자'
               ELSE '여자'
         END gender
       , CASE  
               WHEN MOD( SUBSTR( ssn, -7, 1 ), 2 ) = 1 THEN '남자'
               ELSE '여자'
         END gender  
FROM insa;    


7. emp 에서 평균PAY 보다 같거나 큰 사원들만의 급여합을 출력.
SELECT  SUM(sal+NVL(comm,0))/COUNT(*)  avg_pay
       , AVG( sal+NVL(comm,0) ) avg_pay
FROM emp;
-- 2260.416666666666666666666666666666666667

-- ORA-00904: "PAY": invalid identifier
-- ORA-00937: not a single-group group function
SELECT  
   --empno, ename
   SUM(  sal+NVL(comm,0) )  total_pay   -- 18925
FROM emp
WHERE sal+NVL(comm,0) >= (  SELECT    AVG( sal+NVL(comm,0) )  FROM emp );
-- WHERE sal+NVL(comm,0) >= 2260.416666666666666666666666666666666667;
-- WHERE pay >= 2260.416666666666666666666666666666666667;

-- DECODE() / CASE() 함수를 사용해서 푸어보자.
-- 11:00 수업시작~
SELECT
     --t.ename, t.pay, t.avg_pay
     --, SIGN(  t.pay - t.avg_pay )   -- 0 , 1 
      SUM( DECODE( SIGN(  t.pay - t.avg_pay ), -1 , null, t.pay ) ) total_pay
      , SUM( 
           CASE SIGN(  t.pay - t.avg_pay )
               WHEN -1 THEN null
               ELSE  t.pay
           END
      ) total_pay
FROM (
        SELECT ename, sal + NVL(comm, 0) pay
             , ( SELECT  AVG(sal + NVL(comm, 0))   FROM emp ) avg_pay
        FROM emp
) t;

8. emp 에서  사원이 존재하는 부서의 부서번호만 출력
8-2. emp 에서  사원이 존재하지 않는 부서의 부서번호만 출력

SELECT deptno
FROM dept
MINUS
SELECT DISTINCT deptno
FROM emp
ORDER BY deptno ASC;

9. 함수 설명
    9-1. NULLIF() 함수 설명
    9-2. COALESCE() 함수 설명
    9-3. DECODE() 함수 설명
    9-4. LAST_DAY() 함수 설명
    9-5. ADD_MONTHS() 함수 설명
    9-6. MONTHS_BETWEEN() 함수 설명
    9-7. NEXT_DAY() 함수 설명
    9-8. EXTRACT() 함수 설명

10. emp 테이블의 ename, pay , 최대pay값 5000을 100%로 계산해서
   각 사원의 pay를 백분률로 계산해서 10% 당 별하나(*)로 처리해서 출력
   ( 소숫점 첫 째 자리에서 반올림해서 출력 )
 SELECT MAX( sal + NVL(comm, 0) ) max_pay
      , MIN( sal + NVL(comm, 0) ) min_pay
 FROM emp;

 SELECT t.*
        , t.pay*100 / t.max_pay || '%'  "percent"
       -- , ROUND( ( t.pay*100 / t.max_pay ) / 10 ) START_COUNT
        , RPAD( ' ' , ROUND( ( t.pay*100 / t.max_pay ) / 10 ) + 1 , '*' ) STAR_BAR
 FROM (   
     SELECT ename, sal + NVL(comm, 0) pay  
         , ( SELECT MAX( sal + NVL(comm, 0) ) FROM emp) max_pay
     FROM emp
 ) t;

11. 아래 코딩을  DECODE()를 사용해서 표현하세요.
    ㄱ. [자바]
        if( A == B ){
           return X;
        }
       DECODE( A , B, X )
    ㄴ. [자바]
        if( A==B){
           return S;
        }else if( A == C){
           return T;
        }else{
           return U;
        }
    DECODE( A , B, S, C ,T , U )
    ㄷ.  [자바]
        if( A==B){
           return XXX;
        }else{
           return YYY;
        }
        DECODE( A , B, XXX, YYY )
        
12. insa테이블에서 1001, 1002 사원의 주민번호의 월/일 만 10월10일로 수정하는 쿼리를 작성 
SELECT  name, ssn
FROM insa
WHERE num IN ( 1001, 1002 );
홍길동	771212-1022432
이순신	801007-1544236

UPDATE insa
SET    ssn = SUBSTR( ssn, 0, 2)  || '1010' || SUBSTR( ssn, 7 )
WHERE num IN ( 1001, 1002 );

ROLLBACK;
COMMIT;


12-2. insa테이블에서 '2022.10.10'을 기준으로 아래와 같이 출력하는 쿼리 작성.  

결과)
장인철	780506-1625148	생일 후
김영년	821011-2362514	생일 전
나윤균	810810-1552147	생일 후
김종서	751010-1122233	오늘 생일
유관순	801010-2987897	오늘 생일
정한국	760909-1333333	생일 후

SELECT name, ssn 
--       , TO_CHAR(  TO_DATE( '2022.10.10' ) , 'HH24:MI:SS' )
--       , TO_CHAR( TO_DATE( SUBSTR( ssn, 3, 4 ) , 'MMDD'), 'HH24:MI:SS' )
         , CASE SIGN( TO_DATE( '2022.10.10' ) - TO_DATE( SUBSTR( ssn, 3, 4 ), 'MMDD' ) )  -- 날짜-날짜 = 일수
                  WHEN 1 THEN  '생일 전'
                  WHEN -1 THEN '생일 후'
                  ELSE  '오늘 생일'
           END
FROM insa; 

12-3. insa테이블에서 '2022.10.10'기준으로 이 날이 생일인 사원수,지난 사원수, 안 지난 사원수를 출력하는 쿼리 작성. 
SELECT 
  COUNT( DECODE( s, 0, 'O' ) ) "오늘 생일 사원수"
  , COUNT(  CASE  WHEN s=1 THEN  'o' ELSE null END  ) "생일 전 사원수"
  , COUNT(  CASE  WHEN s=-1 THEN  'o' ELSE null END  ) "생일 전 사원수"
  -- t.name, t.ssn, t.s , DECODE( s, 0, 'O' )
  , COUNT(*) "전체 사원수"
FROM 
( 
    SELECT name, ssn
     , TO_DATE( '2022.10.10' )
     , TO_DATE( SUBSTR( ssn, 3, 4 ) , 'MMDD')
     , SIGN(   TO_DATE( '2022.10.10' ) -   TO_DATE( SUBSTR( ssn, 3, 4 ) , 'MMDD')   )  s
    FROM insa
) t;

-- GROUP BY 절 사용
-- ORA-00937: not a single-group group function
SELECT DECODE( t.s, 1, '생일 전', -1 , '생일 후', '오늘 생일' ) 구분, COUNT(*)
FROM 
( 
    SELECT name, ssn 
     , SIGN(   TO_DATE( '2022.10.10' ) -   TO_DATE( SUBSTR( ssn, 3, 4 ) , 'MMDD')   )  s
    FROM insa
) t
GROUP BY t.s;

결과)
오늘이 생일인 사원수 생일 안지난 사원수  생일 지난 사원수
----------- 	     ---------- 	 ----------
          5          	9         	   46
          
 

13.  emp 테이블에서 10번 부서원들은  급여 15% 인상
                20번 부서원들은 급여 10% 인상
                30번 부서원들은 급여 5% 인상
                40번 부서원들은 급여 20% 인상
  하는 쿼리 작성.     
  
  SELECT deptno, ename, sal + NVL(comm, 0) pay
       , DECODE(  deptno, 10 , 15 , 20, 10, 30, 5, 40 , 20 ) || '% 인상' "인상율"
       , ( sal + NVL(comm, 0) ) * DECODE(  deptno, 10 , 15 , 20, 10, 30, 5, 40 , 20 ) / 100 "인상금액"
       , CASE deptno 
              WHEN 10 THEN ( sal + NVL(comm, 0) )*1.15
              WHEN 20 THEN ( sal + NVL(comm, 0) )*1.1
              WHEN 30 THEN ( sal + NVL(comm, 0) )*1.05
              WHEN 40 THEN ( sal + NVL(comm, 0) )*1.2
         END 인상된금액
  FROM emp;

          
14. emp 테이블에서 각 부서의 사원수를 조회하는 쿼리
SELECT deptno, ename
FROM emp
ORDER BY deptno ASC;

SELECT COUNT( DECODE( deptno, 10, 'O'  ) ) "10번 사원수"
, COUNT( DECODE( deptno, 20, 'O'  ) ) "20번 사원수"
, COUNT( DECODE( deptno, 30, 'O'  ) ) "30번 사원수"
, COUNT( CASE  WHEN deptno=40 THEN  'O' ELSE null END  ) "40번 사원수"
, COUNT( * ) "총 사원수"
FROM emp;

-- GROUP BY 절 : 40번 0 출력 , [ OUTER JOIN ]  --
SELECT 0 deptno,  COUNT(*) FROM emp
UNION ALL
SELECT dept.deptno  , COUNT( ename ) 
FROM emp RIGHT OUTER JOIN dept ON dept.deptno = emp.deptno
GROUP BY dept.deptno 
ORDER BY deptno ASC;

15. emp, salgrade 두 테이블을 참조해서 아래 결과 출력 쿼리 작성.

ENAME   SAL     GRADE
----- ----- ---------
SMITH	800	    1
ALLEN	1900	3
WARD	1750	3
JONES	2975	4
MARTIN	2650	4
BLAKE	2850	4
CLARK	2450	4
KING	5000	5
TURNER	1500	3
JAMES	950	    1
FORD	3000	4
MILLER	1300	2

SELECT ename, sal 
   , CASE 
                           -- LOSAL  HISAL 컬럼
            WHEN sal BETWEEN 700 AND 1200 THEN  1
            WHEN sal BETWEEN 1201 AND 1400 THEN  2
            WHEN sal BETWEEN 1401 AND 2000 THEN  3
            WHEN sal BETWEEN 2001 AND 3000 THEN  4
            WHEN sal BETWEEN 3001 AND 9999 THEN  5
     END grade
FROM emp;

-- JOIN 쿼리 작성.    -- [ 처리 과정 설명 ]  14:00 수업시작~
SELECT e.ename, e.sal, s.grade
FROM emp e, salgrade s 
WHERE e.sal BETWEEN s.losal AND s.hisal ;
--WHERE e.ename = 'SMITH' AND e.sal BETWEEN s.losal AND s.hisal;




-- [ JOIN( 조인 ) 사용 ]
-- 문제) deptno, [dname], empno, ename , hiredate , job 컬럼을 출력(조회)
-- 자식( emp  ) 테이블  : deptno(FK), empno(PK), ename, hiredate, job
-- 부모( dept ) 테이블  : deptno(PK), dname

-- ORA-00918: column ambiguously defined
--            컬럼    모호하게   선언(정의)됨
-- SELECT *
SELECT dept.deptno, dname, empno, ename, hiredate, job
FROM dept  JOIN  emp  ON dept.deptno = emp.deptno;

-- dept, emp  조인 :           JOIN ~ ON 조인조건  구문을 사용해서 조인
SELECT d.deptno, dname, empno, ename, hiredate, job
FROM dept d  JOIN  emp e  ON d.deptno = e.deptno;

SELECT d.deptno, dname, empno, ename, hiredate, job
FROM dept d  ,  emp e  
WHERE d.deptno = e.deptno; -- 조인조건식

-- emp 과 dept 테이블은 deptno 컬럼으로 참조(관계)되고 있다.

SELECT deptno, empno, ename, hiredate, job
FROM emp;

SELECT dname
FROM dept;


SELECT *
FROM salgrade;
등급 LOSAL  HISAL
1	700	    1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999


16. emp 테이블에서 급여를 가장 많이 받는 사원의 empno, ename, pay 를 출력.

-- 5000 
SELECT MAX( sal + NVL( comm, 0 ) ) max_pay
FROM emp;

--  비교연산자 + SOME , ANY, ALL              
--  EXISTS
SELECT empno, ename, sal + NVL( comm, 0 ) pay
FROM emp
WHERE sal + NVL( comm, 0 )  >=  ALL( SELECT sal + NVL(comm, 0) FROM emp );
WHERE sal + NVL( comm, 0 ) = ( SELECT MAX( sal + NVL( comm, 0 ) ) max_pay FROM emp );

SELECT sal + NVL(comm, 0) FROM emp;
 

16-2. emp 테이블에서 각 부서별 급여를 가장 많이 받는 사원의 pay를 출력

SELECT  10 as deptno,  MAX( sal + NVL(comm, 0 ) ) max_pay 
      , MIN( sal + NVL(comm, 0 ) ) min_pay 
FROM emp
WHERE deptno = 10
UNION ALL
SELECT  20,  MAX( sal + NVL(comm, 0 ) ) max_pay 
      , MIN( sal + NVL(comm, 0 ) ) min_pay 
FROM emp
WHERE deptno = 20
UNION ALL
SELECT 30,   MAX( sal + NVL(comm, 0 ) ) max_pay 
      , MIN( sal + NVL(comm, 0 ) ) min_pay 
FROM emp
WHERE deptno = 30
UNION ALL
SELECT 40,  MAX( sal + NVL(comm, 0 ) ) max_pay 
      , MIN( sal + NVL(comm, 0 ) ) min_pay 
FROM emp
WHERE deptno = 40;

-- GROUP BY 절
SELECT deptno
      , MAX( sal + NVL(comm, 0 ) ) max_pay 
      , MIN( sal + NVL(comm, 0 ) ) min_pay 
FROM emp
GROUP BY deptno
ORDER BY deptno ASC;

-- 
SELECT    
    ( SELECT MAX(sal) FROM emp WHERE deptno = 10 )       "10번최고급여액"
    , ( SELECT MAX(sal) FROM emp WHERE deptno = 20 )    "20번최고급여액"
    , ( SELECT MAX(sal) FROM emp WHERE deptno = 30 )    "30번최고급여액"
    , ( SELECT MAX(sal) FROM emp WHERE deptno = 40 )    "40번최고급여액"
FROM dual;

-- [질문]
-- ORA-00979: not a GROUP BY expression
SELECT 
      -- empno, 
      deptno, MAX(sal+NVL(comm, 0)) max_pay
FROM emp
GROUP BY deptno;

-- 
SELECT deptno, ename, sal + NVL(comm, 0) pay
FROM emp
WHERE deptno = 30 AND sal + NVL(comm, 0) = 2850 
OR deptno = 20 AND sal + NVL(comm, 0) = 3000
OR deptno = 10 AND sal + NVL(comm, 0) = 5000;

-- *** 상관 관계(Correlated) 서브 쿼리 ---
-- main query의 값(e.deptno)을  sub query에서 사용한 후 결과값을 다시 main query에서 사용.
-- correlated subquery는 한개의 행을 비교할 때마다 결과가 main으로 리턴된다.

-- ORA-00904: "E"."DEPTNO": invalid identifier

SELECT deptno, ename, sal + NVL(comm, 0) pay
FROM emp e
WHERE sal + NVL(comm, 0) = ( SELECT MAX(sal + NVL(comm, 0)) FROM emp WHERE deptno = e.deptno );

30	BLAKE	2850
10	KING	5000
20	FORD	3000

-- 문제) 각 부서별로 각 부서의 평균 급여보다 크면 사원정보를 출력하는 쿼리 작성하세요. 
SELECT deptno, ename, sal + NVL(comm, 0) pay
       , (  SELECT  AVG(sal + NVL(comm, 0))  FROM emp WHERE deptno =  e.deptno  ) deptno_avg_pay
FROM emp e
WHERE sal + NVL(comm, 0)  > (  SELECT  AVG(sal + NVL(comm, 0))  FROM emp WHERE deptno =  e.deptno  )
ORDER BY deptno ASC;


-- 3:10 풀이 + 수업 시작


-- [Java    days10.Ex05_05.java]
-- 문제) insa 에서
-- 만나이 = 올해년도 - 생일년도 (  -1  생일지나지 않으면)  AmericanAge
-- 세는나이 = 올해년도 - 생일년도 + 1                  CountingAge

 -- 1900 / 2000 / 1800
 -- 주민등록번호 -[성별]   1/2/5/6  1900   3/4/7/8 = 2000  9/0 1800
SELECT t.name, t.ssn
      , CASE t.isBCheck
           WHEN -1 THEN t.now_year - t.birth_year - 1    -- 생일이 지나지않으면
           ELSE         t.now_year - t.birth_year
        END americanAge
      , t.now_year - t.birth_year + DECODE( t.isBCheck , -1, -1, 0 )   americanAge  
      
      , t.now_year - t.birth_year + 1 countingAge
FROM (         
        SELECT name, ssn 
               , TO_CHAR(  SYSDATE , 'YYYY' )  now_year
               ,  CASE
                    WHEN  SUBSTR( ssn, -7, 1 ) IN ( 1,2,5,6 )THEN  1900 + SUBSTR( ssn, 0, 2) 
                    WHEN  SUBSTR( ssn, -7, 1 ) IN ( 3,4,7,8 )THEN  2000 + SUBSTR( ssn, 0, 2) 
                    ELSE  1800 + + SUBSTR( ssn, 0, 2) 
                  END  birth_year 
               ,  SIGN( TRUNC(  SYSDATE  ) - TO_DATE( SUBSTR(ssn, 3,4) , 'MMDD' ) )   isBCheck  -- -1 생일전
        FROM insa
) t;

-- 문제) emp 테이블에서 pay를 많이 받는 3명 출력. ( TOP-N 방식 )
SELECT ROWNUM, t.*
FROM (
        SELECT deptno, ename, sal+NVL(comm, 0) pay
        FROM emp
        ORDER BY pay DESC
) t 
WHERE ROWNUM <= 3; 
WHERE ROWNUM BETWEEN 3 AND 5;  -- X
WHERE ROWNUM <= 1;  -- 가장 많은 급여액 사원

-- [ 순위 매기는 함수 ]  4:10 수업시작~ 
-- 1. DENSE_RANK()
ㄱ. 그룹 내에서 차례로 된 행의 rank를 계산하여 NUMBER 데이터타입으로 순위를 반환한다.
ㄴ. 해당 값에 대한 우선순위를 결정(중복 순위 계산 안함) 
9 9 10

【Aggregate 형식】
      DENSE_RANK ( expr[,expr,...] ) WITHIN GROUP
        (ORDER BY expr [[DESC ¦ ASC] [NULLS {FIRST ¦ LAST} , expr,...] ) 
【Analytic 형식】
      DENSE_RANK ( ) OVER ([query_partion_clause] order_by_clause )

-- 2. RANK()
ㄴ. 해당 값에 대한 우선순위를 결정(중복 순위 계산 함) 
      9 9 11
 -- 문제) emp 테이블에서 pay를 많이 받는 3명 출력. ( DENSE_RANK() 사용해서   )
WITH pay_rank_emp AS (
            SELECT ename, sal  pay
                  , DENSE_RANK() OVER(  ORDER BY sal  DESC ) dr_seq
                  , RANK() OVER(  ORDER BY sal  DESC ) r_seq
                  , ROW_NUMBER() OVER(  ORDER BY sal  DESC ) rn_seq
            FROM emp
)
SELECT e.*
FROM pay_rank_emp  e;

WHERE e.seq BETWEEN 3 AND 5;
WHERE e.seq <= 5 ;
WHERE e.seq = 1 ;


--    ROWNUM 함수X, 의사( pusedo )컬럼 = 가짜컬럼
-- 3) ROW_NUMBER () 함수
이 함수는 분석(analytic) 함수로서, 분할별로 정렬된 결과에 대해 순위를 부여하는 기능이다.
분할은 전체 행을 특정 컬럼을 기준으로 분리하는 기능으로 GROUP BY 절에서 그룹화하는 방법과 같은 개념이다. 

【형식】
      ROW_NUMBER ()   OVER ([query_partition_clause] order_by_clause )


-- 문제) emp 테이블에서 각 부서별로 급여(pay)를  가장 많이 받는 사원 1명 출력...

-- 1) UNION ALL SET연산자(합집합)
SELECT MAX( sal ) max_pay
FROM emp
WHERE deptno = 40;
WHERE deptno = 30;
WHERE deptno = 20;
WHERE deptno = 10;

-- 2) 상관서브쿼리  mq <->  sb
SELECT  deptno,   sal  max_pay
FROM emp e
WHErE sal = ( SELECT MAX(sal) FROM emp WHERE deptno = e.deptno );

-- 3) 순위 함수 
SELECT t.*
FROM (
    SELECT deptno, sal pay
        -- , RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) seq
        -- , DENSE_RANK() OVER( PARTITION BY deptno ORDER BY sal DESC ) seq
        , ROW_NUMBER() OVER( PARTITION BY deptno ORDER BY sal DESC ) seq
    FROM emp
) t
WHERE t.seq <= 2;

-- 문제) emp 에서 sal(pay) 가 상위 20% 까지  사원 정보를 조회(출력)
--
--12:100 = ? : 20
--? = 24/100
--  = 0.24

SELECT t.*  
FROM   (
    SELECT deptno, ename, sal pay 
       , RANK() OVER( ORDER BY sal DESC )     r_seq
    FROM emp
) t
WHERE t.r_seq <= FLOOR( 2.4 );


-- PERCENT_RANK() 백분률 함수
이 함수는 CUME_DIST 함수와 유사하게 percent_rank 값을 반환한다. 
【aggregate 형식】
      PERCENT_RANK(expr,...) WITHIN GROUP 
        (ORDER BY expr { [DESC ¦ ASC]
                         [NULLS {FIRST ¦ LAST}]
                       },...)
또는 
【Analytic 형식】
       PERCENT_RANK() OVER ( 
                             [query_partition_clause]
                              order_by_clause
                            )
SELECT t.*                            
FROM ( 
    SELECT deptno, ename, sal pay
        , PERCENT_RANK() OVER ( ORDER BY sal DESC ) p_rank
    FROM emp
) t
WHERE p_rank <= 0.2;  -- 20%











