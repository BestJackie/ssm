<%--
  Created by IntelliJ IDEA.
  User: haichaoyang3
  Date: 2020/7/10
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>attribute</title>
</head>
<body>
<%
    request.setAttribute("id",1);
    request.getRequestDispatcher("./attribute/reqAttribute").forward(request,response);
%>
</body>
</html>
