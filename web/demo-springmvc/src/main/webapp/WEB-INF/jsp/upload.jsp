<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2018/12/6
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传下载</title>
</head>
<body>
<ul>
    <li>
        <p>上传</p>
        <form action="/file/doUpload" method="POST" enctype="multipart/form-data">
            <input type="file" name="file1">
            <button type="submit">提交</button>
        </form>
    </li>
    <li><a href="/file/doDownload/123/jpg" target="_blank">下载</a> <a href="/file/doDownload/123/jpg">下载</a></li>
</ul>
</body>
</html>
