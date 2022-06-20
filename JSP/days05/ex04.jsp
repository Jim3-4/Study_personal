<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.jspf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 20. - 오후 12:17:10</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h3>ex04.jsp</h3>

<a href="<%= contextPath %>/cstvsboard/list.htm">게시판 글 목록</a>

<pre>
   1. sqldeveloper 실행 +  scott 계정으로 접속.
   2. TBL_CSTVSBOARD  테이블 생성
       SEQ_TBL_CSTVSBOARD 시퀀스 확인
       
  CREATE TABLE "SCOTT"."TBL_CSTVSBOARD" 
   (	"SEQ" NUMBER NOT NULL ENABLE, 
	"WRITER" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"PWD" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"EMAIL" VARCHAR2(100 BYTE), 
	"TITLE" VARCHAR2(200 BYTE) NOT NULL ENABLE, 
	"WRITEDATE" DATE DEFAULT SYSDATE, 
	"READED" NUMBER DEFAULT 0, 
	"TAG" NUMBER(1,0) DEFAULT 0, 
	"CONTENT" CLOB, 
	 PRIMARY KEY ("SEQ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("CONTENT") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
      
    3.  days05 폴더 안에  board 폴더 생성
    4.  days05.board 패키지 생성
          ㄱ. BoardDTO
          ㄴ. BoardDAO 
          ㄷ. BoardDAOImpl
                                                                   오후 2시 수업 시작
    5.      /jspPro/cstvsboard/list.htm  ->  서블릿 클래스   List.java 추가  ->  days05/board/list.jsp 포워딩.
    6.     /jspPro/cstvsboard/write.htm   글쓰기      링크 태그 클릭
              Write.java    doGet(){}      -> 포워딩   write.jsp
    6-2. write.jsp
            새 게시글 정보 입력 한 후          "작성완료" 버튼 클릭  ->   
            /jspPro/cstvsboard/write.htm  +  POST 방식    -> Write.java 서블릿
             -> doPost(){
                        dao.새 게시글 쓰기()  DB 저장 
            }
       4:14 수업 시작  
    7.  페이징 처리            <<  1                   2 3 4 5 6 7 8 9 10 »
                         이전버튼   시작번호                                  끝번호  , 다음버튼 ㅅtrue
                         
       PageBlock.java  클래스 선언                
       
       
        내일 코딩X  [ 로직 처리 ]
    8. 내일( 6/21(화)) 
         1)    글 목록  에서     글번호의  제목을 클릭하면 ->    글 상세보기
         2)   글 상세보기  
         3)   글 수정
         4)   글 삭제
         
         
         
</pre>

</body>
</html>




    



















