<%--
  Created by IntelliJ IDEA.
  User: candk
  Date: 10/2/21
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%!
        private int num = 100;
    %>

    <%=num%><br/>
    <%="num"%><br/>
    <%=request.getParameter("username")%>

    <%
        System.out.println("1111");
    %>
</body>
</html>
