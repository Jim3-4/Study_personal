<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
String gender=request.getParameter("gender");
//값이 여러개일 수 있으니 
String[] pets = request.getParameterValues("pet");
%>
<%
Enumeration<String> en=request.getParameterNames();
while(en.hasMoreElements()){
	String pname=en.nextElement();

%>
<li><%= pname %></li>
<%
}
%>
<%
          // pname  pvalue  entry 
   Map<String, String[]> map = request.getParameterMap();
   Set<Entry<String, String[]>> set = map.entrySet();
   Iterator<Entry<String, String[]>>  ir= set.iterator();
   while( ir.hasNext() ){
      Entry<String, String[]>  entry = ir.next();
      String k = entry.getKey();
      String [] v = entry.getValue();
%>
  <li type="circle"><%=   String.format("key=%s, value=%s<br>", k , Arrays.toString(  v ) )  %></li>
<%
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 15.-오후 4:08:46</title>
</head>
<body>
<h3></h3>
>이름 : <%= name %><br>
>이름: ${param.name} <br>
>성별: <%= gender %><br>
성별: 
<input type="radio" name="gender" value="m"  <%=gender.equals("m")? "checked":"" %>>남자
<input type="radio" name="gender" value="f" <%=gender.equals("f")? "checked":"" %>>여자

<input type="radio" name="gender" value="m" >남자
<input type="radio" name="gender" value="f" >여자
좋아하는 동물 : 
<%=Arrays.toString(pets) %> 
<br>
<input type="checkbox" name="pet" value="puppy"/>개
<input type="checkbox" name="pet" value="pig"/>돼지
<input type="checkbox" name="pet" value="cat"/>고양이
<br>
 <script >
 $(":radio[name=gender]").each(function(i,element){
	 if(element.value=="<%=gender%>"){
		 element.checked=true;
	 }
 });
 
  
  $(":radio[name=gender]").val("<%=gender%>").attr("checked",true);
 </script>
 
 <script >
 $(":checkbox[name=pet]").each(function(i,element){
	 if('<%=Arrays.toString(pets)%>'.indexOf(element.value)!=-1){
		 element.checked="true";
	 }
 });
 </script>
</body>
</html> --%>