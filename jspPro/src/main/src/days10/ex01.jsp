<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 27.-오전 9:18:35</title>
</head>
<body>
<h3></h3>
1) 오라클 DB+게시판 테이블 생성

글번호(seq:PK) + 제목(subject) 

 1                           첫번째게시글 
 2                           두번째게시글 
 3							  세번째게시글
 4 						  2-1 답글 
  5 						 ㄴ 2-2 답글 
   6 						 ㄴ 2-2-1답글 
   7						ㄴ3-1답글
   
 1-2)list.jsp 글목록페이지 
 -최신글 먼저 출력 order by seq desc
 글번호                제목
 7							ㄴ3-1답글
 6 						 ㄴ 2-2-1답글 
 5 						 ㄴ 2-2 답글 
  4 						 ㄴ 2-1 답글 
 3						세번째게시글
 2						두번째게시글
 1						첫번째게시글
 
 최신글 처럼 하면 저렇게 출력되는것이 맞지만, 답글형게시판에서는 이렇게 오도록 해야한다. 
  
  글번호                제목

 3						세번째게시글
  7							ㄴ3-1답글
 2						두번째게시글
 5 						 ㄴ 2-2 답글 
 6 						       ㄴ 2-2-1답글 
 4 						 ㄴ 2-1 답글 
 1						첫번째게시글
 

 
 답글위한 선행조건 ) 
 ㄱ.보고자 하는 게시글 2)클릭 view.do->view.jsp 
 [수정][삭제][답글달기][홈]


답글	list.jsp 관련된 게시글 				그룹화면출력하는방법
				ㄴ답글
				      ㄴ답답글
				  ㄴ답글
				  해결방법- > 그룹화 칼럼추가 (REF)
				  
				  
1) 오라클 DB+게시판 테이블 생성

글번호(seq:PK)  제목(subject)  그룹 (REF) 순번(STEP) 깊이(DEPTH)
1							첫번째 게시글		1         	 1						0
2 							두번째 게시글 		2           1						0
3							세번째 게시글 		3 			 1						0


1-2)list.jsp 글 목록 페이지
-최신글 먼저 출력 order by seq desc 
글번호(seq:PK)  제목(subject)

1) 첫번째 게시글 (새글 ) 쓰기 
    ㄱ. 글 그룹 (REF)는 글 번호(SEQ)랑 동일한 값으로 설정한다. 
	ㄴ.새글의 순번(STEP)은 				1 로 설정한다. 
	ㄷ.새글의 깊이(DEPTH)는 			1로 설정한다.
	
2)답글쓰기 
    ㄱ. 글 그룹 (REF)는 글 번호(SEQ)랑 동일한 값으로 설정한다. 
	ㄴ.새글의 순번(STEP)은 				1 로 설정한다. 
	ㄷ.새글의 깊이(DEPTH)는 			1로 설정한다.
	
DTO 생성
 days10.replyboard.controller             MV[C]
  days10.replyboard.command              [M]VC
  days10.replyboard.domain                  DTO
 	ㄴ.ReplyBoardDTO.java 
  days10.replyboard.persistence          DAO
  days10.replyboard.service                  SERVICE
</body>
</html>