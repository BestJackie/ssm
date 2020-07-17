<%--
  Created by IntelliJ IDEA.
  User: haichaoyang3
  Date: 2020/7/15
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>formatter</title>
</head>
<body>
<form action="./formatter">
    <table>
        <tr>
            <td>日期</td>
            <td><input name="date1" type="date" value="2020-07-15" /></td>
        </tr>
        <tr>
            <td>金额</td>
            <td>￥<input name="amount" type="number" value="123,000.00" /></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
