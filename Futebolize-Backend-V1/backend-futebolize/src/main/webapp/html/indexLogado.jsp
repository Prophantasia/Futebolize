<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null){
        response.sendRedirect("../index.jsp");
    }

%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- @Desenvolvido por: Matheus Campos & Rafael Abrantes -->

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <title>Futebolize</title>
    <link rel="icon" href="../assets/images/ball.ico">
    <link href="../css/styleLogado.css" rel="stylesheet" type="text/css" />
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
            <li><a href="cadastrarQuadras.jsp">CADASTRAR QUADRA</a></li>
            <li><a href="perfil.jsp">MEU PERFIL</a></li>
            <li><a href="sair.jsp">SAIR</a></li>
        </ul>
    </nav>

</header>

    <h1>
        <BR><BR><BR>
        Ola! Bem vindo a área do dono Futebolize!
    </h1>

    <div class="text_log">
        <p>Por aqui você pode acessar todos os nossos conteúdos disponibilizados, como por exemplo: </p>
            <li>Quadras cadastradas no sistema;</li>
            <li>Cadastro de quadras novas;</li>
            <li>Atualização do seu perfil;</li>
    </div>

    <div class="text_log2">
        <p>Explore o mundo do futebol e organize partidas com seus amigos da forma que mais gostarem!</p><br>
        <p>Deseja cadastrar uma quadra?<a href="cadastrarQuadras.jsp">Clique aqui!</a></p>

    </div>

<script src="../javascript/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>

</body>

</html>