<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%// @Desenvolvido por: Matheus Campos %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null)
        response.sendRedirect("sobre.jsp");
%>

<html>
<head>
    <title>Sobre Logado.</title>
</head>
<body>
    Sobre Logado.
</body>
</html>
