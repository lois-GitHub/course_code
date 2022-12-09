<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>软件下载中心</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="box">
    <div class="content">
        <div class="login-wrapper">
            <h1>登录</h1>
            <form method="post" action="/web_work/userServlet">
                <div class="login-form">
                    <div class="username form-item">
                        <span>用户名登陆</span>
                        <input type="text" class="input-item" name="username">
                    </div>
                    <div class="password form-item">
                        <span>密码</span>
                        <input type="password" class="input-item" name="password">
                    </div>
                    <button class="login-btn" type="submit" id="submit">登 录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
<%--<script>--%>
<%--    document.getElementById("submit").onclick = function () {--%>
<%--        location.href = "userServlet";--%>
<%--    }--%>

<%--</script>--%>
</html>