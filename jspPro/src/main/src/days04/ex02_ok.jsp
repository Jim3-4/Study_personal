<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="days04.DeptEmpSalgradeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="days04.SalgradeDTO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>2022. 6. 17.-오전 11:39:38</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
$( function() {
  $( "#accordion" ).accordion();
} );
</script>
</head>
<body>

<%
LinkedHashMap<SalgradeDTO, ArrayList<DeptEmpSalgradeDTO>> map = 
(LinkedHashMap<SalgradeDTO, ArrayList<DeptEmpSalgradeDTO>> )request.getAttribute("map");

%>



<h3>ex02_ok.jsp</h3>

<div id="accordion">

<%
   
   Set<Entry<SalgradeDTO, ArrayList<DeptEmpSalgradeDTO>>> set = map.entrySet();
   Iterator<Entry<SalgradeDTO, ArrayList<DeptEmpSalgradeDTO>>> ir = set.iterator();

   while (ir.hasNext()) {
       Entry<SalgradeDTO, ArrayList<DeptEmpSalgradeDTO>> entry =    ir.next();
       SalgradeDTO dto = entry.getKey();

%>    
  
 <h3><%= String.format("%d등급(%d~ %d)-%d명"
       , dto.getGrade(), dto.getLosal(), dto.getHisal(), dto.getCnt())%>;</h3> 
    
<%    
    
    
    // 
    ArrayList<DeptEmpSalgradeDTO>  list = entry.getValue();
    // 20   RESEARCH   7369   SMITH   800.00
    Iterator<DeptEmpSalgradeDTO>  vir = list.iterator();

%>

<div>
   <p>

<%
    while (vir.hasNext()) {
       DeptEmpSalgradeDTO edto =  vir.next();
 %>
   <li>
   <%=    
      String.format("\t\t%d\t%s\t%d\t%s\t%.2f\n"   
         , edto.getDeptno(), edto.getDname(), edto.getEmpno(), edto.getEname(), edto.getSal() ) 
   %>
  </li>
<%

    } // while
%>
 </p>
</div>
<%
 } // while
%>

<!-- 
  <h3>Section 1</h3>
  <div>
    <p>
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
    ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
    amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
    odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </p>
  </div>
 -->
  
  
</div>

</body>
</html>