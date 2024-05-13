<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- @Desenvolvido por: Matheus Campos & Rafael Abrantes -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <title>Futebolize</title>
    <link rel="icon" href="../assets/images/ball.ico">
    <link href="../css/perfil.css" rel="stylesheet" type="text/css" />
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
            <li><a href="cadastrarQuadras.jsp">CADASTRAR QUADRA</a></li>
            <li><a href="sair.jsp">SAIR</a></li>
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
            <form action="/atualizar" method="post">

                <!-- Elementos do form-->
                <p>E-mail:</p>
                <input
                        type="text"
                        name="emailLogin"
                        placeholder="Digite seu e-mail" autofocus
                        required
                        minlength="1" />

                <p>Nome completo:</p>
                <input
                        type="text"
                        name="nameLogin"
                        placeholder="Digite seu nome e sobrenome"
                        required
                        minlength="1" />

                <p>Endereço:</p>
                <input
                        type="text"
                        name="addressLogin"
                        placeholder="Digite seu endereço"
                        required
                        minlength="1" />

                <p>Telefone:</p>
                <input
                        type="text"
                        name="phoneLogin"
                        placeholder="Digite seu telefone (apenas os números)"
                        required
                        minlength="11"
                        maxlength="11" />

                <p>CPF:</p>
                <input
                        type="text"
                        name="cpfLogin"
                        placeholder="Digite seu CPF"
                        required
                        minlength="11"
                        maxlength="11" />

                <p>Senha:</p>
                <input
                        type="password"
                        name="passLogin"
                        placeholder="Digite sua senha"
                        required
                        minlength="1" />
                <input type="submit" value="CADASTRAR-SE"></input>

            </form>
        </div>
    </section>
</main>

<script src="../javascript/script.js"></script>
</body>

</html>