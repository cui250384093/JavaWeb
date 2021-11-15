<%--
  Created by IntelliJ IDEA.
  User: candk
  Date: 10/4/21
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>scope.jsp</h1>

    <%
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>

    <%=pageContext.getAttribute("key")%><br/>
    <%=request.getAttribute("key")%><br/>
    <%=session.getAttribute("key")%><br/>
    <%=application.getAttribute("key")%><br/>

    <jsp:forward page="/include/main.jsp"></jsp:forward>
</body>
</html>
