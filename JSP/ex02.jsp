<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<title>2022. 6. 14.-오후 2:48:05</title>
</head>
<body>
<h3></h3>
jsp=java Server page
<form action="ex02_ok.jsp" method="get">
이름:<input type="text" name="name" autofocus="autofocus" tabindex="1"><br>
나이: <input type="text" name="age" tabindex="2"><br>
<input type="submit" tabindex="3">
<input type="reset">
</form>
<script>
    $(function(){
        $("form").submit(function(event){
            if($(":text[name=name]").val().trim()==""){
                alert("이름 입력 필수 사항");
                event.preventDefault();
                $(":text[name=name").focus();
                return;
            }
            if($(":text[name=age]").val().trim()==""){
                alert("나이 입력 필수 사항");
                event.preventDefault();
                $(":text[name=age").focus();
                return;
            }
        });
    });
</script>
</body>
</html>