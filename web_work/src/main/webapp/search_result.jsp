<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询结果展示</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<%--<form method="post" action="/web_work/selectByNameServlet">--%>
<%--    通过软件名称查询： <input placeholder="请输入软件名称" name="name">--%>
<%--    <input type="submit" value="查询" id="search"><br>--%>
<%--</form>--%>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>软件排名</th>
        <th>软件名称</th>
        <th>类别</th>
        <th>描述</th>
        <th>评分</th>
        <th>操作</th>
        <th>查看详细信息</th>
    </tr>


    <tr align="center">
        <%--<td>${brand.id}</td>--%>
        <td>${software.id}</td>
        <td>${software.name}</td>
        <td>${software.depart}</td>
        <td>${software.description}</td>
        <td>${software.score}</td>

        <td><a href="/web_work/deleteServlet?id=${software.id}">删除</a></td>
        <td><a href="/web_work/deleteServlet?id=${software.id}">详细信息</a></td>
    </tr>


</table>

<script>
    document.getElementById("add").onclick = function () {
        location.href = "/web_work/addBrand.jsp";
    }

    // document.getElementById("search").onclick = function () {
    //     location.href = "/web_work/selectByIdServlet";
    // }

</script>
</body>
</html>