<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%--1. 表单的提交的方式必须是POST请求（get请求对提交的数据）
2. 表单中必须有一个文件上传项:\<input type=\"file\" name=\"upload\"/\>，文件上传项必须有name属性和值；
3. 表单的enctype属性的值必须是multipart/form-data--%>
    <form action="/upload" method="post" enctype="multipart/form-data">
        用户名:<input type="text" name="username"/><br/>
        头&nbsp;像<input type="file" name="headImg"/><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
