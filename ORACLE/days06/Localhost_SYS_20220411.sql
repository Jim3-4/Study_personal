-- SYS 계정 접속 --

1. EMP 테이블의 사원수, 급여합, 급여평균를 조회하는 쿼리 작성.
SELECT COUNT(*), SUM( sal + NVL(comm, 0) ) , AVG( sal + NVL(comm, 0) )
FROM emp;
  

2. 현재 시스템의   날짜를 출력하는 쿼리 작성

SELECT SYSDATE, CURRENT_DATE, CURRENT_TIMESTAMP
FROM dual;

3. SQL 집합 연산자의 종류와 설명을 하세요
UNION
UNION ALL
INTERSECT
MINUS

4. 함수 설명
  ㄱ. 반올림 함수를 선언형식을 적고 설명하세요         ROUND( , )
  ㄴ. 절삭(내림) 함수를 선언형식을 적고 설명하세요.    TRUNC( , ) , FLOOR()
  ㄷ. 절상(올림) 함수를 선언형식을 적고 설명하세요.    CEIL()
  
5. 게시판에서 총 게시글 수가 : 65 개 이고  한 페이지에 : 15개의 게시글 출력할 때
    총 페이지 수를 계산하는 쿼리 작성.
SELECT CEIL(65/15)
FROM dual;    
    
6. emp 테이블에서 사원들의 평균 급여보다 많은 급여를 받으면 1
                                     적은 급여를 받으면 -1
                                     같으면           0 
  을 출력하는 쿼리 작성.
SELECT t.pay, t.avg_pay , SIGN( t.pay - t.avg_pay)
FROM (
SELECT sal+ NVL(comm, 0) pay
   ,  ( SELECT  ROUND(AVG( sal + NVL(comm, 0) ), 2)  FROM emp) avg_pay
FROM emp
) t;

7. insa테이블에서 80년대( 80년~89년생 )에 출생한 사원들만 조회하는 쿼리를 작성
  ㄱ. LIKE 사용
  ㄴ. REGEXP_LIKE 사용
  ㄷ. BETWEEN ~ AND 사용   
  WHERE ssn LIKE '8%';
  WHERE REGEXP_LIKE( ssn, ^8 );
  WHERE SUBSTR( ssn, 0, 2) BETWEEN 80 AND 89;
  
8. insa 테이블에서 주민등록번호를 123456-1******  형식으로 출력하세요 . ( LPAD, RPAD 함수 사용  )
[실행결과]
홍길동	770423-1022432	770423-1******
이순신	800423-1544236	800423-1******
이순애	770922-2312547	770922-2******

SELECT name, ssn
        , RPAD(  SUBSTR( ssn, 1, 8), 14, '*') 
FROM insa;

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

SELECT deptno, ename, sal+NVL(comm, 0) pay
, ROUND( sal+NVL(comm, 0) , -2)/100  bar_length
, RPAD( ' ',  ROUND( sal+NVL(comm, 0) , -2)/100+1 , '#')  
FROM emp
WHERE deptno = 30;

8-3. insa 테이블에서  주민번호를 아래와 같이 '-' 문자를 제거해서 출력
[실행결과]
NAME    SSN             SSN_2
홍길동	770423-1022432	7704231022432
이순신	800423-1544236	8004231544236
이순애	770922-2312547	7709222312547

SELECT name, ssn
   , INSTR( ssn, '-')
   , REPLACE( ssn, '-', '')
FROM insa;

9. emp 테이블에서 각 사원의 근무일수, 근무 개월수, 근무 년수를 출력하세요.

SELECT ename, hiredate , SYSDATE
      , CEIL( SYSDATE-hiredate ) 근무일수
      , MONTHS_BETWEEN( SYSDATE, hiredate) 근무개월수
      , ROUND( MONTHS_BETWEEN( SYSDATE, hiredate)/12, 2 ) 근무년수
FROM emp;

10. 개강일로부터 오늘날짜까지의 수업일수 ? 
( 개강일 : 2022.2.15 )

SELECT CEIL( ABS(TO_DATE( '2022.2.15' ) - SYSDATE ) ) 수업일수
FROM dual;

10-2.  오늘부터 수료일까지 남은 일수 ?  
( 수료일 : 2022.7.29 ) 

SELECT CEIL( ABS(TO_DATE( '2022.7.29' ) - SYSDATE ) ) 수업일수
FROM dual;

10-3. emp 테이블에서 각 사원의 입사일을 기준으로 100일 후 날짜, 10일전 날짜, 1시간 후 날짜, 3개월 전 날짜 출력

SMITH	80/12/17	81/03/27	80/12/07	80/12/17	81/03/17	80/09/17
ALLEN	81/02/20	81/05/31	81/02/10	81/02/20	81/05/20	80/11/20
WARD	81/02/22	81/06/02	81/02/12	81/02/22	81/05/22	80/11/22

SELECT ename, hiredate
       , hiredate + 100
       , hiredate - 10
       , hiredate +1/24
       , ADD_MONTHS( hiredate, -3 )
FROM emp;
    
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
 
 SELECT  ASCII('A')
 , CHR(65)
 , GREATEST(1,2,33,4,5)
 , LEAST(1,2,33,4,5)
 FROM dual;
 
 
 