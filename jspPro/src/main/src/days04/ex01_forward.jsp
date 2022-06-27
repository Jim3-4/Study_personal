<%@page import="days02.DeptDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String contextPath = request.getContextPath();
   String name = (String)request.getAttribute("name");
   //DeptDTO arr = (DeptDTO)request.getAttribute("deptList");
   //System.out.println(arr.toString());
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 17.-오전 9:34:27</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
   table{
      width: 100%;
      min-width: 700px;
   }
   table, th, td{
      border: solid 1px gray;
   }
</style>
</head>
<body>
<h3>ex01_forward.jsp</h3>




> 서블릿 전송된 name = <%=name%>

<br>
<br>


<select name="deptno" id="selDept">
   <c:forEach items="${ deptList }" var="dto">
       <option value="${ dto.deptno }">${ dto.dname }</option>
   </c:forEach>

</select>

<br>
<br>


<table>
   <thead>
      <tr>
         <th><input type="checkbox"id="ckbAll"name="ckbAll">전체선택</th>
         <th>empno</th>
         <th>ename</th>
         <th>job</th>
         <th>mgr</th>
         <th>hiredate</th>
         <th>sal</th>
         <th>comm</th>
         <th>deptno</th>
         <th></th>
         <th></th>
      </tr>
   </thead>
   <tbody>
      <c:if test="${not empty empList}">
         <c:forEach items="${empList}" var="dto" varStatus="status">  <!-- 공백 띄우고 var 해야한다. -->
            <tr>
               <%-- <td><input type="checkbox"data-속성명="사원번호">${status.count}</td> --%>
               <td><input type="checkbox" name="empchk" data-empno="${ dto.empno }"  id="empno-${ dto.empno }">${ status.count }</td>
               <td>${dto.empno}</td>
               <td>${dto.ename}</td>
               <td>${dto.job}</td>
               <td>${dto.mgr}</td>
               <td>${dto.hiredate}</td>
               <td>${dto.sal}</td>
               <td>${dto.comm}</td>
               <td>${dto.deptno}</td>
            </tr>
         </c:forEach>
      </c:if>
      <c:if test="${empty empList}">
         <tr>
            <td colspan="9">employee does not exist</td>
         </tr>
      </c:if>
   </tbody>
   <tfoot>
      <tr>
         <td colspan="9"style="text-align: center">
            <button id="checked_empno">확인</button>
         </td>
      </tr>
   </tfoot>
</table>

<script>
//    http://localhost/jspPro/test/test00.htm?deptno=30
   
   $("#selDept").change(function(){
      //BOM
      location.href = "<%=contextPath%>/test/test00.htm?deptno="+$(this).val();
      //여기부분 물어보기
      //페이지 이동하게 하는 부분
   });
   
   //jQuery + EL
   //http://localhost/jspPro/test/test00.htm?deptno=30
         
   $("#selDept").val("${empty param.deptno?10:param.deptno}");
   
   
   $("#ckbAll").change(function(event){
      $("table tbody tr")
            .find("td:first-child :checkbox")
            .prop("checked", $(this).prop("checked"));
   });
   
   
    
   $("#checked_empno").on("click",function(){
      //ex01_finish.jsp
      //$("[name=empchk]:checked")
      var empnos = [];
      $("table tbody :checked").each(function(i,element){
         //element.id
         var empno = $(this).parent().next().html();
         empnos.push(empno);
      })
      
      
      
      
      <%-- location.href = "<%=contextPath%>/days04/ex01_finish.jsp?empno=1111&empno=7564; --%>
      
      location.href="<%= contextPath%>/days04/ex01_finish.jsp?empno=" + empnos.join("&empno=");

   });
    
    
    
    
   <%--  
    $("#okbtn").click(function (event) {
        let form = $("<form>");
        $("[name=empchk]:checked").each(function (i, element) {
            form.append("<input type='hidden' name= 'empno' value="+element.parentElement.nextElementSibling.innerText+">");
        })
        form.attr({
                id:"empsubmit",
                method:"get",
                action:"<%=contextPath%>/days03/test/test02.jsp"
            });
        $("body").append(form);
        $("#empsubmit").submit();
    });
     --%>
    
</script>


</body>
</html>