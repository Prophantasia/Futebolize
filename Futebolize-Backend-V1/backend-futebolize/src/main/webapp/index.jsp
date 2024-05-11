<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  if(request.getSession().getAttribute("usuarioEmail") != null)
    response.sendRedirect("/html/indexLogado.jsp");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <!-- @Desenvolvido por: Rafael Soares-->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
  <title>Futebolize</title>
  <link rel="icon" href="assets/images/ball.ico">
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- Cabeçalho -->
<header>
  <nav>
    <a href="index.jsp">
      <img class="logo" src="assets/images/logo.png" alt="Logo">
    </a>
    <div class="mobile-menu">
      <div class="line1"></div>
      <div class="line2"></div>
      <div class="line3"></div>
    </div>
    <ul class="nav-list">
      <li><a href="html/quadras.html">QUADRAS</a></li>
      <li><a href="html/sobre.html">SOBRE</a></li>
      <li><a href="html/login.html">LOGIN</a></li>
    </ul>
  </nav>
</header>

<!-- Conteúdo -->
<main>
  <div class="catch-phrase-main">
    <p>Jogue com paixão, alugue com facilidade!</p><br>
    <h2 id="link-quadra"><a href="html/login.html">Alugue sua quadra</a></h2>
  </div>

  <div class="img-main">
    <img class="ney" src="assets/images/img-ney-main.png" alt="Neymar">
  </div>
</main>

<footer>
  <p>&copy; 2024 - Todos os direitos reservados</p>
  <p>Entre em contato pelo e-mail: futebolize@contato.com</p>
</footer>

<script src="javascript/script.js"></script>

</body>

</html>