<%--
  Created by IntelliJ IDEA.
  User: matheus.cspinto2
  Date: 03/05/2024
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(request.getSession().getAttribute("usuarioEmail") != null) {
        response.sendRedirect("/html/sobrePriv.html");



    } else
        response.sendRedirect("/html/sobrePriv.html");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Logado</p>
</body>
</html>
