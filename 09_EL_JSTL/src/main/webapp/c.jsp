<%--
  Created by IntelliJ IDEA.
  User: candk
  Date: 10/5/21
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1", "pageContext1");
        pageContext.setAttribute("key2", "pageContext2");
    %>

    ${pageContext.getAttribute("key1")}<br/>
    ${pageScope.key1}<br/>
    ${pageContext.getAttribute("key2")}<br/>
    ${pageScope.key2}<br/>

    ${pageContext.request.scheme}<br/>
    ${pageContext.request.serverName}<br/>
    ${pageContext.request.serverPort}<br/>
    ${pageContext.request.contextPath}<br/>
    ${pageContext.request.method}<br/>
    ${pageContext.request.remoteHost}<br/>
    ${pageContext.session.id}<br/>

    ${param.username}<br/>
    ${paramValues}<br/>

    ${cookie.JSession.name}<br/>
    ${cookie.JSession.value}<br/>

    ${initParam}
</body>
</html>
