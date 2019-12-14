<%--
  Created by IntelliJ IDEA.
  User: Vova
  Date: 14.12.2019
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <title>XMLParsers</title>
</head>
<body>
<div id="inputs">
    <form method="post" id="formParse" action="/XMLParser/parse" enctype="multipart/form-data">
        <p>
            <input id="file" type="file" name="file" class="inputfile" accept=".xml">
            <label for="file">Choose a file</label>
        </p>
        <p>
            <select name="type" class="combobox">
                <option value="SAX">SAX</option>
                <option value="StAX">StAX</option>
                <option value="DOM">DOM</option>
            </select>
        </p>
        <p>
            <button id="getSax" class="button">Send</button>
        </p>
    </form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/Controller.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
