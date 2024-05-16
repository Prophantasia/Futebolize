<%@ page import="br.com.futebolize.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.futebolize.model.Field" %>
<%@ page import="br.com.futebolize.dao.SearchFieldDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%// @Desenvolvido por: Matheus Campos %>

<%
    // Verifica se o atributo na sessão é diferente de null
    if(request.getSession().getAttribute("usuarioLogado") != null)
        response.sendRedirect("quadrasLogado.jsp");
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/quadras.css">
    <link rel="icon" href="../assets/images/ball.ico">
    <title>Quadras</title>
</head>

<body>
<header>
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
            <li><a href="quadras.jsp">QUADRAS</a></li>
            <li><a href="sobre.jsp">SOBRE</a></li>
            <li><a href="login.html">LOGIN</a></li>
        </ul>
    </nav>
</header>

<section class="quadras">
    <div id="quadras_1">
        <div class="quadra_1">
            <img src="/assets/images/quadra1-futebol.jpg" alt="Quadra 1">
            <p>Quadra São José do Rio Branco</p>
            <p>Rua Henrico Neves, 302</p>
        </div>

        <div class="quadra_2">
            <img src="/assets/images/quadra2-futebol.jpg" alt="Quadra 2">
            <p>Quadra José Carlos Albino</p>
            <p>Rua Carlos Lacerda, 524</p>
        </div>

        <div class="quadra_3">
            <img src="/assets/images/quadra3-futebol.jpg" alt="Quadra 3">
            <p>Quadra Jairo Almeida</p>
            <p>Rua Bonefácio Alves, 923</p>
        </div>
        <div class="quadra_4">
            <img src="/assets/images/quadra4-futebol.jpg" alt="Quadra 1">
            <p>Quadra São José do Rio Branco</p>
            <p>Rua Henrico Neves, 302</p>
        </div>

        <div class="quadra_5">
            <img src="/assets/images/quadra5-futebol.jpg" alt="Quadra 2">
            <p>Quadra José Carlos Albino</p>
            <p>Rua Carlos Lacerda, 524</p>
        </div>

        <div class="quadra_6">
            <img src="/assets/images/quadra1-futebol.jpg" alt="Quadra 3">
            <p>Quadra Jairo Almeida</p>
            <p>Rua Bonefácio Alves, 923</p>
        </div>
    </div>


</section>


<footer>
    <p>&copy; 2024 - Todos os direitos reservados</p>
    <p>Entre em contato pelo e-mail: futebolize@contato.com</p>
</footer>

<script src="../javascript/script.js"></script>
</body>
</html>