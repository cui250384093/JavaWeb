<%--
  Created by IntelliJ IDEA.
  User: candk
  Date: 10/4/21
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key", "request");
    %>

    <%= request.getAttribute("key")%><br/>

    ${key}



</body>
</html>
