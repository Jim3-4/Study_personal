<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 17.-오후 3:42:30</title>
<style type="text/css">
   div{
      border:1px solid gray;
      padding : 5px;
      margin-top:10px;
      max-height:500px;
      overflow: auto;
   }
</style>
</head>
<body>
<h3>ex05_05.jsp</h3>
<%
String filePath=application.getInitParameter("filePath");
String realPath=application.getRealPath(filePath); %>
<%=realPath %>


<%
 File dir = new File(realPath);
 File[] fileList = dir.listFiles();
%>
<select name="file" id="file">
        <%
        for(int i = 0; i < fileList.length; i++) {
            %>
        <option><%=fileList[i].getName() %></option>
        <%
        }
        %>
    </select>
    
    
    <% 
//  out.println(fileList[0].getName());
FileReader in = null;
BufferedReader br = null;

//?file=ex10.jsp
String pFile = request.getParameter("file");
String file = pFile == null ? fileList[0].getName() : pFile;
String fileName = String.format("%s/%s", realPath, file);
StringBuffer sb = new StringBuffer();


try {
    in = new FileReader(fileName);
    br = new BufferedReader(in);
    String line = null;

    while((line = br.readLine()) != null) {
        sb.append(line + "\r\n");
    }

} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        in.close();
        br.close();
    } catch (Exception e) {

    }
}

String content = sb.toString();
    %>
    <div>
   <code>
   <%=content %>
   </code>
    </div>
    <script>
    $("#file").change(function(event){
    	$(this).parents().submit();
    });
    
    $("#file").val('<%=pFile%>');
    </script>
</body>
</html> --%>