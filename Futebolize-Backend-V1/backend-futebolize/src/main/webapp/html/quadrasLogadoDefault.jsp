<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="br.com.futebolize.dao.SearchFieldDao"%>
<%@ page import="br.com.futebolize.model.Field" %>
<%@ page import="java.util.ArrayList" %>

<%// @Desenvolvido por: Matheus Campos e Gabriel Henrique %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null)
        response.sendRedirect("quadras.jsp");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/quadrasLogadoDefault.css">
    <link rel="icon" href="../assets/images/ball.ico">
    <title>Quadras</title>
</head>
<body>

<nav>
    <a href="../index.jsp">
        <img class="logo" src="/assets/images/logo.png" alt="Logo">
    </a>
    <div class="mobile-menu">
        <div class="line1"></div>
        <div class="line2"></div>
        <div class="line3"></div>
    </div>
    <ul class="nav-list">
        <li><a href="perfil.jsp">MEU PERFIL</a></li>
        <li><a href="sair.jsp">SAIR</a></li>
    </ul>
</nav>

<div id="divContainer">

</div>

<script>
    window.onload = function() {
        var divContainer = document.getElementById("divContainer");

        <%
            int qtdQuadrasJava = SearchFieldDao.showFields();
            SearchFieldDao fieldDao = new SearchFieldDao();
            ArrayList<Field> fields = fieldDao.listarFields();

            for (Field field : fields) {
                // Gere os elementos HTML para cada campo (field)
        %>
        var div = document.createElement("div");
        div.className = "quadra";

        var img = document.createElement("img");
        img.src = "../img/1715605541190-jdSuzana.jpeg";
        img.alt = "Imagem";
        div.appendChild(img);

        var p1 = document.createElement("p");
        p1.textContent = <%= field.getName()%>;
        div.appendChild(p1);

        var p2 = document.createElement("p");
        p2.textContent = <%= field.getAddress()%>;
        div.appendChild(p2);

        divContainer.appendChild(div);

        <%
            }
        %>
    };
</script>

</body>
</html>

