<%-- <%@page import="java.util.Iterator"%>
<%@page import="days02.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
   String contextPath = request.getContextPath();
   //ArrayList<EmpDTO> list = (ArrayList<EmpDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 16.-오후 12:01:04</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h3>ex06_emp</h3>

<table border="1"style="width: 100%">
<thead>


</thead>
<tbody>
<%
   if(list==null){
%>
   <tr>
      <td colspan="5"style="height: 200px">사원이 존재하지 않습니다.</td>
   </tr>
<%
   }else{
   Iterator<EmpDTO> ir = list.iterator();
   while(ir.hasNext()){
      EmpDTO dto = ir.next();
%>
   <tr>
   <td><%=dto.getDeptno() %></td>
   <td><%=dto.getEmpno() %></td>
   <td><%=dto.getEname( )%></td>
   <td><%=dto.getJob() %></td>
   <td><%=dto.getHiredate() %></td>
   </tr> 
<%
    }//while
   }//if
%>
</tbody>
<tfoot>
        <tr>

            <td colspan="5">
                ${param.selDept}번 부서원은 총 <%=list==null?0:list.size()%>명 입니다.
            </td>
        </tr>
    </tfoot>
</table>
<a href="<%=contextPath%>/scott/dept">다시하기</a>



</body>
</html> --%>