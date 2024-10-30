<%@ page import="contactmanager.model.Contact" %>
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
    <title>编辑联系人</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>编辑联系人</h1>

<form action="ContactServlet?action=edit" method="post">
    <input type="hidden" name="id" value="<%=((Contact)request.getAttribute("contact")).getId()%>">
    姓名：<input type="text" name="name" value="<%=((Contact)request.getAttribute("contact")).getName()%>"><br>
    电话：<input type="text" name="phone" value="<%=((Contact)request.getAttribute("contact")).getPhone()%>"><br>
    邮箱：<input type="text" name="email" value="<%=((Contact)request.getAttribute("contact")).getEmail()%>"><br>
    <input type="submit" value="更新">
</form>
</body>
</html>
