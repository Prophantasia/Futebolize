<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%// @Desenvolvido por: Matheus Campos %>

<%
    // Verifica se o atributo na sessão é diferente de null
    if(request.getSession().getAttribute("usuarioLogado") != null)
        response.sendRedirect("sobreLogado.jsp");
%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <title>Futebolize</title>
    <link rel="icon" href="../assets/images/ball.ico">
    <link href="../css/sobre.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!-- Cabeçalho -->
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
            <li><a href="sobre.jsp">SOBRE</a></li>
            <li><a href="login.html">LOGIN</a></li>
        </ul>
    </nav>

</header>

<main>

    <div class="containerSobre">

        <div class="textSobre">
            <div class="titulo">
                <h3>
                    <br>
                    SUA<br><strong>PARTIDA PERFEITA</strong> <br>COMEÇA AQUI!!<br><br></h3>
            </div>
            Olá, que bom que você chegou ao Futebolize, seu mais novo<br>site de Aluguel de Quadras de Futebol!<br><br>

            Aqui você pode contar com uma ampla seleção de quadras e<br> uma experiência de reserva fácil, que vão tornar os
            seus jogos<br> inesquecíveis. Descubra nossos recursos exclusivos:<br><br><br>

            <div class="sub1">
                <h3> Reservas Online Simplificadas</h3> <br>
            </div>
            Reserve sua quadra de futebol em poucos cliques, escolhendo<br> a
            localização, data e horário que mais lhe convém.</li><br><br>

            <div class="sub2">
                <h3> Variedade de Quadras</h3> <br>
            </div>
            Oferecemos uma variedade de quadras cobertas e ao ar livre,<br> com diferentes tamanhos
            e superfícies, para atender às suas<br> preferências e necessidades de jogo.</li><br><br>

            <div class="sub3">
                <h3> Tarifas Acessíveis</h3> <br>
            </div>
            Preços competitivos e opções de aluguel flexíveis para se<br>  adequarem ao seu orçamento
            e agenda.</li>
            </h3>

        </div>

        <div class="buttonSobre">
            <button><a href="login.html"> QUERO ALUGAR UMA QUADRA!</a> </button>
        </div>

        <div class="img-sobre">
            <img class="imgSobre" src="/assets/images/img-futebolize-sobre-1Ativo 1@2x.png">
        </div>
    </div>

</main>

<footer>
    <p>&copy; 2024 - Todos os direitos reservados</p>
    <p>Entre em contato pelo e-mail: futebolize@contato.com</p>
</footer>

<script src="../javascript/script.js"></script>

</body>
</html>