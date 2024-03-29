<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 20. - 오후 12:43:01</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
table, td, th {
	border: solid 1px gray;
}

table {
	border-spacing: 3px;
	border-collapse: separate;
}

table, tr, td {
	/* border-radius: 3px; */
	/* padding:3px;  */
	
}

tbody tr  td:nth-of-type(2) {
	text-align: left;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: red;
}
</style>
<!-- 페이징 처리 style -->
<style>
.pagination {
	margin: 0 auto;
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 4px 8px;
	text-decoration: none;
	transition: background-color .3s;
}

.pagination a.active {
	background-color: dodgerblue;
	color: white;
}

.pagination a:hover:not (.active ) {
	background-color: #ddd;
}
</style>
<style>
.searchWord {
	background-color: yellow;
	color: red;
}
</style>
<style>
.title {
	display: inline-block;
	white-space: nowrap;
	width: 90%;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>

</head>
<body>

<h3>days08/board/list.jsp</h3>

<div align="center">
  <h2>목록 보기</h2>
  <a href="<%= contextPath %>/board/write.do">글쓰기</a>
  <table style="width:600px;">
    <thead>
	    <tr>
	        <th width="10%">번호</th>
	        <th width="45%">제목</th>
	        <th width="17%">작성자</th>
	        <th width="20%">등록일</th>
	        <th width="10%">조회</th>
	      </tr>
    </thead>
    <tbody>
      <!-- empty EL 연산자 -->
      <c:if test="${  empty list }">
        <tr>
          <td colspan="5">등록된 게시글이 없습니다.</td>
        </tr>
      </c:if>
      <!-- not EL 연산자 -->
      <c:if test="${ not empty list }">
      	<!-- request.setAttribute("list", list); -->	
         <c:forEach items="${ list }" var="dto">
            <tr>
	           <td>${ dto.seq }</td>
	           <td><a href="<%= contextPath %>/board/view.do?seq=${ dto.seq }">${ dto.title }</a></td>
	           <td><a href="mailto:${ dto.email }">${ dto.writer }</a></td>
	           <td>${ dto.writedate }</td>
	           <td>${ dto.readed }</td>
	         </tr>
         </c:forEach>         
      </c:if>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="5" align="center">
          <div class="pagination"> 
          <%-- 
            <a href="#" class="active"> 1 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=2"> 2 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=3"> 3 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=4"> 4 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=5"> 5 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=6"> 6 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=7"> 7 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=8"> 8 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=9"> 9 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=10"> 10 </a> 
            <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=11"> &raquo; </a>
             --%> 
             <!-- request.setAttribute("pageBlock", pageBlock); -->
             <!-- << -->
             <c:if test="${ pageBlock.prev }">
                <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=${ pageBlock.startOfPageBlock -1 }">&laquo;</a>
                <!--  &searchCondigion=${ param.searchCondition}&seachWord=${ param.searchWord }   -->
             </c:if>
             <c:forEach begin="${ pageBlock.startOfPageBlock }" end="${ pageBlock.endOfPageBlock }" step="1" var="i">
                
                <c:if test="${  i == pageBlock.currentPage }">
                   <a href="#" class="active">${ i }</a>
                </c:if>
             
               <c:if test="${  i != pageBlock.currentPage  }">
                   <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=${ i}">${ i }</a>
               </c:if>
               
             </c:forEach>
             <!-- >> -->
             <c:if test="${ pageBlock.next }">
                <a href="<%= contextPath %>/cstvsboard/list.htm?currentpage=${ pageBlock.endOfPageBlock +1 }">&raquo;</a>
             </c:if>
          </div>
        </td>
      </tr>
      <tr>
        <td colspan="5" align="center">
          <form method="get">
             <select name="searchCondition" id="searchCondition">
              <option value="1">title</option>
              <option value="2">content</option>
              <option value="3">writer</option>
              <option value="4">title+content</option>
            </select>
            <input type="text" name="searchWord" id="searchWord" />
            <input type="submit" value="search" />
          </form>
        </td>
      </tr>
    </tfoot>
  </table>
</div>

<script>
    // list.htm?write=success
    if( '<%= request.getParameter("write") %>' == 'success'){
    	alert("글 쓰기 완료!!!");
    }	
    
    // list.htm?delete=success
    if( '<%= request.getParameter("delete") %>' == 'success'){
    	alert("글 삭제 완료!!!");
    }
</script>
<script>
  // 검색 후 검색조건,검색어 상태 유지(관리)
  // EL  안에서 삼항 연산자를 사용가능
  $("#searchCondition").val( '${ empty param.searchCondition ? 1  : param.searchCondition }' );
  $("#searchWord").val('${ param.searchWord}');
  
  // /list.htm?currentpage=2&searchCondigion=3&seachWord=검색
 $(".pagination a:not(.active)").attr("href", function ( i, val ){
	 return val + "&searchCondition=${ param.searchCondition}&searchWord=${ param.searchWord }"; 
 });		  
</script>
</body>
</html>













