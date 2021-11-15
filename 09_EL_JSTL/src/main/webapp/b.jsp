<%@ page import="com.example.pojo.Person" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: candk
  Date: 10/5/21
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        Person person = new Person();
        person.setName("Lili");
        person.setPhones(new String[]{"15063626360", "18265670107"});

        List<String> cities = new ArrayList<String>();
        cities.add("Beijing");
        cities.add("Qingdao");
        cities.add("Shenzhen");
        person.setCities(cities);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        person.setMap(map);

        pageContext.setAttribute("person", person);
    %>

    ${person}<br/>
    ${person.name}<br/>
    ${person.phones}<br/>
    ${person.phones[0]}<br/>
    ${person.cities}<br/>
    ${person.map}<br/>
    ${person.map.key1}<br/>
    ${person.map.key3}<br/>

</body>
</html>
