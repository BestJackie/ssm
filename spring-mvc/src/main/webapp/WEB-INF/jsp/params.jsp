<%--
  Created by IntelliJ IDEA.
  User: haichaoyang3
  Date: 2020/7/9
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>参数</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(
            function () {
                var data={
                    roleName: 'Role_json_test',
                    note: 'Role_json_note',
                    pageParam: {
                        start: '12',
                        limit: '123'
                    }
                }
                var roleList=[{
                    roleName: 'Role_json_test',
                    note: 'Role_json_note'
                },
                    {
                        roleName: 'Role_json_test',
                        note: 'Role_json_note'
                    },
                    {
                        roleName: 'Role_json_test',
                        note: 'Role_json_note'
                    }];
                $.post({
                    url: "./common?json",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function(){
                        alert("req success");
                    }
                });
                $.post({
                    url: "./addRoles",
                    contentType: "application/json",
                    data: JSON.stringify(roleList),
                    success: function(result){
                        alert("req success"+result.total);
                    }
                });
                $("#commit").click(function () {
                    let str=$("#form3").serialize();
                    $.post({
                        url: "./common",
                        // contentType: "application/json",
                        data: $("#form3").serialize(),
                        success: function(){
                            alert("req success");
                        }
                    });
                })


            }
        )
    </script>
</head>
<body>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<script type="text/javascript">
    alert("<%=basePath%>");
</script>
<form id="form1" action="common">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input name="roleName" value=""></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input name="note" value=""></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<br/>
<form id="form2" action="common?pojo">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input name="roleName" value=""></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input name="note" value=""></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>

<form id="form3">
    <table>
        <tr>
            <td>角色名称</td>
            <td><input name="roleName" value=""></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input name="note" value=""></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="button" id="commit" value="提交"></td>
        </tr>
    </table>
</form>

</body>
</html>
