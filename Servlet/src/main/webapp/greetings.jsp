<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: gupta
  Date: 1/30/2025
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greet</title>
</head>
<body bgcolor="#5f9ea0">
<%
    String name = request.getParameter("name");
    PrintWriter outPrinter = response.getWriter();
    outPrinter.println("Hello " + name);
%>

</body>
</html>
