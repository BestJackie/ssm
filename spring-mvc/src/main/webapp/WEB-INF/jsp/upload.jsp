<%--
  Created by IntelliJ IDEA.
  User: haichaoyang3
  Date: 2020/7/14
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload</title>
</head>
<body>
<form method="post" action="./upload" enctype="multipart/form-data"/>
    ServletAPI 上传文件<br/>
    <input type="file" name="file" placeholder="请选择上传的文件" />
    <input type="submit" value="提交" />
</form>
<hr/>
<form method="post" action="./uploadMultipartFile" enctype="multipart/form-data"/>
multipartFile 上传文件<br/>
<input type="file" name="file" placeholder="请选择上传的文件" />
<input type="submit" value="提交" />
</form>
<hr/>
<form method="post" action="./uploadPart" enctype="multipart/form-data"/>
Part 上传文件<br/>
<input type="file" name="file" placeholder="请选择上传的文件" />
<input type="submit" value="提交" />
</form>

</body>
</html>
