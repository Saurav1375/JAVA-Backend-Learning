<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Saurav gupta
  Date: 1/30/2025
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%--Directive Block--%>
<%@ page import="java.util.Random" %>
<html>
<head>
    <title>Greet</title>
</head>
<body>
<%!
    int i  = 3; //declarative block
%>
<%

    //scriptlet
    String name = request.getParameter("name");
    PrintWriter outPrinter = response.getWriter();
    outPrinter.println("Hello " + name);
    $
    /*
    * Session
    * out
    * Application (Servlet Config)
    * response and request
    * config -> ServletConfig
    * pageContext
    */
%>
<%= name%> <%--expression block--%>

</body>
</html>
