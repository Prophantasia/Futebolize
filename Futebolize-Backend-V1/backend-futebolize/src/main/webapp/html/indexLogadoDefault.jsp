<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null)
        response.sendRedirect("../index.jsp");
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- @Desenvolvido por: Rafael Abrantes -->

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <title>Futebolize</title>
    <link rel="icon" href="../assets/images/ball.ico">
    <link href="../css/styleLogadoDefault.css" rel="stylesheet" type="text/css" />
</head>

<body>

<header>
    <nav>
        <a href="../index.jsp">
            <img class="logo" src="/assets/images/logo.png"> </a>
        <div class="mobile-menu">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>
        <ul class="nav-list">
            <li><a href="quadras.jsp">QUADRAS</a></li>
            <li><a href="perfil.jsp">MEU PERFIL</a></li>
            <li><a href="sair.jsp">SAIR</a></li>
        </ul>
    </nav>

</header>

<h1>
    <BR><BR><BR>
    Olá! Bem vindo a área de usuário Futebolize!
</h1>

<div class="text_log">
    <p>Por aqui você pode acessar os nossos conteúdos disponibilizados para quem quer jogar ou precisa alterar algum dado
        do perfil , como por exemplo: </p>
    <li>Quadras cadastradas no sistema;</li>
    <li>Se cadastrar para jogos;</li>
    <li>Atualização do seu perfil;</li>
</div>

<div class="text_log2">
    <p>Explore o mundo do futebol e participe de partidas com seus amigos da forma que mais gostarem!</p><br>
    <p>Bora encontrar sua próxima partida?<a href="quadrasLogadoDefault.jsp">Clique aqui!</a></p>

</div>
<script src="../javascript/script.js"></script>
</body>

</html>