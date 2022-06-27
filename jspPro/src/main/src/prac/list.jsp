<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 21.-오전 12:33:37</title>

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
<h3></h3>
<div align="center">
<h2>목록보기</h2>
<a href="<%=contextPath %>/cstvsboard/write.htm">글쓰기</a>
<table style="width:600px">
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
<c:if test="${empty list} ">
<tr>
<td colspan="5">등록된 게시물이없다. </td>
</tr> 
</c:if>
<c:if test="${not empty list} ">
<c:forEach items="${list }" var="dto" >
<tr>
<td>${dto.seq }</td>
<td>${dto.title }</td>
<td>${dto.writer }</td>
<td>${dto.writedate }</td>
<td>${dto.readed }</td>
</tr>
</c:forEach>
</c:if>
</tbody>
<tfoot>
<tr>
<td colspan="5" align="center">
<div class="pagination">
<c:if test="${ pageBlock.prev }">
<a href="<%= contextPath %>/cstvsboard/list.htm?"></a>
</c:if>
</div>
</td>
</tr>
</tfoot>
</table>
</div>
</body>
</html> --%>