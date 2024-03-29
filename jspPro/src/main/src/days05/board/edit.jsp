<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/include.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
    /*  padding:3px;  */

}

table {
    width: 600px;
}
</style>
<title>Insert title here</title>
</head>
<body>

    <div align="center">
      <h2>수정하기</h2>
      <!--  http://localhost/jspPro/cstvsboard/edit.htm?seq=146 -->
      <form method="post">
         <table>
            <tr>
               <td colspan="2" align="center"><b>글을 수정합니다</b></td>
            </tr>
            <tr>
               <td align="center">이름</td>
               <td>
                 <input type="text" readonly name="writer" size="15" value="${dto.writer }">
               </td>
            </tr>
            <tr>
               <td align="center">Email</td>
               <td>
                 <input type="email" name="email" size="50" value="${dto.email }">
               </td>
            </tr>
            <tr>
               <td align="center">제목</td>
               <td>
                 <input type="text" name="title" size="50"   value="${dto.title }">
               </td>
            </tr>
            <tr>
               <td align="center">내용</td>
               <td><textarea name="content" cols="50" rows="10">${dto.content }</textarea>
               </td>
            </tr>
            <tr>
               <td align="center">HTML</td>
               <td>
                       tag: ${dto.tag }
                  <input type="radio" name="tag" value="1">적용
                  <input type="radio" name="tag" value="0">비적용
                  <script>
                      $(":radio[name=tag][value=${dto.tag}]").attr("checked", true);
                  </script>
                   </td>
            </tr>
            <tr>
               <td align="center">비밀번호</td>
               <td><input type="password" name="pwd" size="15"></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                 <input type="submit" value="작성 완료">
                 &nbsp;&nbsp; 
                 <input type="button" onClick="history.back();" value="이전으로">
               </td>
            </tr>
         </table>
      </form>
   </div>
</body>
</html>