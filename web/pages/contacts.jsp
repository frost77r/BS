<%@ page import="contactmanager.model.Contact" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/10/24
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人通讯录系统</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>个人通讯录系统</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <%
        List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
        if (contacts!= null) {
            for (Contact contact : contacts) {
    %>
    <tr>
        <td><%=contact.getId()%></td>
        <td><%=contact.getName()%></td>
        <td><%=contact.getPhone()%></td>
        <td><%=contact.getEmail()%></td>
        <td>
            <a href="ContactServlet?action=edit&id=<%=contact.getId()%>">编辑</a>
            <a href="ContactServlet?action=delete&id=<%=contact.getId()%>">删除</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<p><a href="ContactServlet?action=add">添加联系人</a></p>
</body>
</html>
