<%-- <%
// URL: http://localhost:80/jspPro/days03
// realPath: 
String filepath = application.getInitParameter("filePath"); // days03
String realPath = application.getRealPath("") + filepath;
out.println("> realpath: " + realPath + "<br>");
%>

<%
File dir = new File(realPath);
File[] fileList = dir.listFiles();
%>

<h3>ex02.jsp</h3>
<h4>/days03</h4>


<form action="" id="form1">
    <label for="/days03"></label><br />
    <select name="file" id="file">
        <%
        for(int i = 0; i < fileList.length; i++) {
            %>
        <option><%=fileList[i].getName() %></option>
        <%
        }
        %>
    </select>
</form>

<%
//     out.println(fileList[0].getName());
FileReader in = null;
BufferedReader br = null;

// ?file=ex10.jsp
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
content = content
    .replaceAll("<", "&lt;")
    .replaceAll(">", "&gt;")
    .replaceAll("\r\n", "<br>");
%>

<div
     style="border: solid 1px gray; padding: 5px; margin-top: 10px; max-height: 500px; overflow: auto">
    <code>
        <%=content %>
    </code>
</div>

<script>
    $("#file").change(function(event) {
        $("form").submit();    
    });
</script> --%>