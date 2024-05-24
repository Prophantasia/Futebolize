<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="br.com.futebolize.dao.SearchFieldDao"%>
<%@ page import="br.com.futebolize.model.Field" %>
<%@ page import="java.util.ArrayList" %>

<%// @Desenvolvido por: Matheus Campos e Gabriel Henrique %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null){
        response.sendRedirect("quadras.jsp");
    }
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

<div id="divContainer"></div>

<script>
    window.onload = function() {
        var divContainer = document.getElementById("divContainer");

        function createDiv(qtdQuadrasJava) {
            for (let i = 0; i < qtdQuadrasJava; i++) {
                var div = document.createElement("div");
                div.className = "quadra";

                var img = document.createElement("img");
                img.src = "../img/" + quadrasData[i].imagePath;
                img.alt = "Imagem";
                div.appendChild(img);

                var p1 = document.createElement("p");
                p1.textContent = quadrasData[i].name;
                div.appendChild(p1);

                var p2 = document.createElement("p");
                p2.textContent = quadrasData[i].address;
                div.appendChild(p2);

                // Criar uma função de encerramento para cada botão
                (function(i) {
                    var botao = document.createElement("button");
                    botao.textContent = "Se inscrever";
                    botao.classList.add("user-button");

                    var iconeUsuario = document.createElement("i");
                    iconeUsuario.classList.add("fas", "fa-check");
                    botao.appendChild(iconeUsuario);

                    botao.onclick = function() {
                        if (botao.textContent === "Se inscrever") {
                            Swal.fire({
                                title: "Presença Garantida!",
                                text: "Você se inscreveu para utilizar esta quadra.",
                                imageUrl: "https://imagem.natelinha.uol.com.br/original/Neymar_366ecd1b4137dea7853213d6facff5306cbdc23e.jpeg",
                                imageWidth: 400,
                                imageHeight: 200,
                                imageAlt: "Custom image"
                            });
                            botao.style.backgroundColor = "#dc3545";
                            botao.textContent = "Remover presença";
                        } else {
                            Swal.fire({
                                title: "Presença Removida!",
                                text: "Você removeu sua inscrição desta quadra.",
                                imageUrl: "https://th.bing.com/th/id/OIP.If2-jLDiNwglFgS5nyNH_QHaFj?rs=1&pid=ImgDetMain",
                                imageWidth: 400,
                                imageHeight: 200,
                                imageAlt: "Custom image"
                            });
                            botao.style.backgroundColor = "";
                            botao.textContent = "Se inscrever";
                            botao.appendChild(iconeUsuario);

                        }
                    }
                    div.appendChild(botao);
                })(i); // Passa o índice atual para a função de encerramento

                divContainer.appendChild(div);
            }
        }

        // Dados do banco de dados
        var quadrasData = [];
        <%
            SearchFieldDao fieldDao = new SearchFieldDao();
            ArrayList<Field> fields = fieldDao.listarFields();
            for (Field field : fields) {
        %>
        quadrasData.push({
            name: "<%= field.getName() %>",
            address: "<%= field.getAddress() %>",
            imagePath: "<%= field.getImage_path() %>"
        });
        <% } %>

        createDiv(quadrasData.length);
    };
</script>

<footer>
    <p>&copy; 2024 - Todos os direitos reservados</p>
    <p>Entre em contato pelo e-mail: futebolize@contato.com</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js"></script>
</body>
</html>
