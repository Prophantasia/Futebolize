<%--
  Created by IntelliJ IDEA.
  User: rafae
  Date: 17/05/2024
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="br.com.futebolize.model.User" %>
<%@ page import="br.com.futebolize.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null)
        response.sendRedirect("../index.jsp");
    UserDao userDao = new UserDao();
    User user = new User();

    // Setando o objeto user de acordo com os atributos da sessão
    user.setEmail(request.getSession().getAttribute("email").toString());
    user.setPassword(request.getSession().getAttribute("pass").toString());

    // Metódo para buscar o registro do usuário via email e senha
    User resp = userDao.buscarUser(user);


%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- @Desenvolvido por: Matheus Campos & Rafael Abrantes -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <title>Futebolize</title>
    <link rel="icon" href="../assets/images/ball.ico">
    <link href="../css/perfilLogado.css" rel="stylesheet" type="text/css" />
    <link href="../css/ui.css" rel="stylesheet">
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
            <form action="/atualizar" method="post" class="update" onsubmit="return atualizar(this);">

                <!-- Elementos do form-->
                <p>E-mail:</p>
                <input
                        type="text"
                        value="<%= resp.getEmail()%>"
                        name="emailPerfil"
                        placeholder="Digite seu e-mail" autofocus
                        required
                        minlength="1" />

                <p>Nome completo:</p>
                <input
                        type="text"
                        value="<%= resp.getName()%>"
                        name="namePerfil"
                        placeholder="Digite seu nome e sobrenome"
                        required
                        minlength="1" />

                <p>Endereço:</p>
                <input
                        type="text"
                        value="<%= resp.getAdress()%>"
                        name="addressPerfil"
                        placeholder="Digite seu endereço"
                        required
                        minlength="1" />

                <p>Telefone:</p>
                <input
                        type="text"
                        value="<%= resp.getPhone()%>"
                        name="phonePerfil"
                        placeholder="Digite seu telefone (apenas os números)"
                        required
                        minlength="11"
                        maxlength="11" />

                <p>CPF:</p>
                <input
                        type="text"
                        value="<%= resp.getCpf()%>"
                        name="cpfPerfil"
                        placeholder="Digite seu CPF"
                        required
                        minlength="11"
                        maxlength="11" />

                <p>Senha:</p>
                <input
                        type="password"
                        value=""
                        name="passPerfil"
                        placeholder="Digite sua nova senha"
                        required
                        minlength="1" />

                <input type="submit" class="btn_atualizar" value="ATUALIZAR">

            </form>

            <form action="/delete" method="post" class="delete" onsubmit="return deletar(this);">
                <input type="submit" value="EXCLUIR CONTA" id="btn-deletar">
            </form>

        </div>
    </section>
</main>

<script src="../javascript/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.all.min.js"></script>

<script>
    function atualizar(form){
        Swal.fire({
            title: "Você tem certeza?",
            text: "Você será redirecionado para a página de login!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#19882f",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sim, vou atualizar!",
            cancelButtonText: "Cancelar"
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire({
                    title: "Deleted!",
                    text: "Your file has been deleted.",
                    icon: "success"
                });
                form.submit();
            }
        });
        return false;
    }

    function deletar(form){
        Swal.fire({
            title: "Você tem certeza?",
            text: "Não será possível voltar atrás!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#d33",
            cancelButtonColor: "#3382dd",
            confirmButtonText: "Sim, vou deletar!",
            cancelButtonText: "Cancelar"
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire({
                    title: "Deleted!",
                    text: "Your file has been deleted.",
                    icon: "success"
                });
                form.submit();
            }
        });
        return false;
    }
</script>
</body>

</html>