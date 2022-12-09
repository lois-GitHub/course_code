<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加软件</title>
</head>
<body>
<h3>添加软件</h3>
<form action="/web_work/addServlet" method="post">
    软件名称：<input name="name"><br>
    软件类别：<input name="depart"><br>
    软件描述：<input name="description"><br>
    软件评分：<input name="score"><br>


    <input type="submit" value="提交">
</form>
</body>
</html>