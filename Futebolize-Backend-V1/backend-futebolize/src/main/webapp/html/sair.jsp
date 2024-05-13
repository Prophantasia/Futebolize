<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: rafael.sabrantes
  Date: 10/05/2024
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>

<%
    request.getSession().removeAttribute("email");
    request.getSession().removeAttribute("pass");
    request.getSession().removeAttribute("usuarioLogado");
    request.getSession().invalidate();
    response.sendRedirect("../index.jsp");
%>

<html>
<head>
    <title>Deslogando</title>
</head>
<body>

</body>
</html>
