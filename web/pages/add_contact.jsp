<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/10/24
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>添加联系人</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>添加联系人</h1>
<form action="ContactServlet?action=add" method="post">
  姓名：<input type="text" name="name"><br>
  电话：<input type="text" name="phone"><br>
  邮箱：<input type="text" name="email"><br>
  <input type="submit" value="添加">
</form>
</body>
</html>
