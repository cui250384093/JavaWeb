<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: candk
  Date: 10/5/21
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set scope="request" var="key1" value="value1" />
    ${key1}

    <c:if test="${12 == 12}">

    </c:if>

    <%
        request.setAttribute("height", 198);
    %>

    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h2>too high</h2>
        </c:when>

        <c:when test="${requestScope.height > 180}">
            <h2>high</h2>
        </c:when>

        <c:when test="${requestScope.height > 170}">
            <h2>normal</h2>
        </c:when>

        <c:otherwise>
            <h2>short</h2>
        </c:otherwise>
    </c:choose>

    <c:forEach begin="1" end="10" var="i">
        ${i}<br/>
    </c:forEach>

    <%
        request.setAttribute("arr", new String[]{"12345", "67890"});
    %>

    <c:forEach items="${requestScope.arr}" var="item">
        ${item}<br/>
    </c:forEach>

    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        request.setAttribute("map", map);
    %>


    <c:forEach items="${requestScope.map}" var="entry">
        ${entry}<br/>
    </c:forEach>


</body>
</html>
