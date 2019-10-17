<%@ page import="entity.Apartment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alexandro
  Date: 11.10.2019
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p2>All Apartments</p2>

<%
    List<Apartment> apartments = (List<Apartment>) request.getAttribute("apartments");
    for (Apartment ap : apartments) {
        out.print("<p>");
        out.print("<br>");
        out.print(ap.getId() + ", "+ ap.getRegion()+", "+ ap.getAddress() + ", " +
                ap.getArea()+ ", "+ ap.getCountOfRooms()+ ", "+ ap.getPrice());
        out.print("</p>");
    }
%>

</body>
</html>
