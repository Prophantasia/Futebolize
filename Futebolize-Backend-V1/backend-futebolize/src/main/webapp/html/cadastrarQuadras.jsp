<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%// @Desenvolvido por: Matheus Campos & Gabriel Alves %>

<%
  // Verifica se o atributo na sessão é null
  if(request.getSession().getAttribute("usuarioLogado") == null)
    response.sendRedirect("quadras.jsp");
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
  <!-- @Desenvolvido por: Matheus Campos & Rafael Abrantes & Gabriel Alves -->

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
  <title>Futebolize</title>
  <link rel="icon" href="../assets/images/ball.ico">
  <link href="../css/cadastroQuadras.css" rel="stylesheet" type="text/css" />
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
      <li><a href="sobre.jsp">SOBRE</a></li>
      <li><a href="perfil.jsp">MEU PERFIL</a></li>
    </ul>
  </nav>

</header>

<!-- Conteúdo -->
<main>
  <section class="area-login">

    <div class="login">
      <div>
        <a href="../index.jsp">
          <img class="logo" src="../assets/images/logo.png" alt="Logo"></a>
      </div>

      <!-- Elemento de conexão com o banco e backend-->
      <form action="/cadastrarQuadra" method="post" enctype="multipart/form-data" > <!---->

        <!-- Elementos do form-->
        <p>Nome da Quadra:</p>
        <input
                type="text"
                name="fieldName"
                placeholder="Digite o nome da quadra" autofocus
                required
                minlength="1" />

        <!--<p>Caminho para a imagem da quadra:</p>
        <input
                type="text"
                name="fieldImagePath"
                placeholder="informe o diretorio da imagem"
                required
                minlength="1" />-->

        <p>Imagem:</p>
        <input
                type="file"
                name="image"
                placeholder="Logradouro da quadra"/>


        <p>Logradouro:</p>
        <input
                type="text"
                name="fieldAddress"
                placeholder="Logradouro da quadra"
                required
                minlength="1" />

        <p>Estado:</p>
        <input
                type="text"
                name="fieldState"
                placeholder="Informe o estado"
                required />

        <p>Maximo de jogadores:</p>
        <input
                type="number"
                name="maxPlayers"
                placeholder="Informe a qtd. maxima de jogadores"
                required />

        <p>Valor do aluguel:</p>
        <input
                type="number"
                name="fieldRentValue"
                placeholder="Informe o valor do aluguel (por jogador)"
                required />
        <input type="submit" value="CADASTRAR QUADRA!">

      </form>
    </div>
  </section>
</main>

<script src="../javascript/script.js"></script>
</body>

</html>