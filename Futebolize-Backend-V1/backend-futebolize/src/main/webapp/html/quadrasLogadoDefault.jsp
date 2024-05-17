
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

<div id="divContainer">

</div>

<!--Funcionalidade de checkbox para implementar-->
<!--<input type="checkbox" id="coracao" />
<label for="coracao">
    <svg xmlns="http://www.w3.org/2000/svg" width="44" height="44" viewBox="0 0 24 24" fill="none" stroke="#19b425">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4.318 6.318a4.5 4.5 0 000 6.364L12 20.364l7.682-7.682a4.5 4.5 0 00-6.364-6.364L12 7.636l-1.318-1.318a4.5 4.5 0 00-6.364 0z" />
    </svg>
</label>-->
<script>
    window.onload = function() {
        var divContainer = document.getElementById("divContainer");

        function createDiv(qtdQuadrasJava) {
            for (let i = 0; i < qtdQuadrasJava; i++) {
                var div = document.createElement("div");
                div.className = "quadra";

                var img = document.createElement("img");
                img.src = "../img/"+quadrasData[i].imagePath;
                img.alt = "Imagem";
                div.appendChild(img);

                var p1 = document.createElement("p");
                p1.textContent = quadrasData[i].name;
                div.appendChild(p1);

                var p2 = document.createElement("p");
                p2.textContent = quadrasData[i].address;
                div.appendChild(p2);


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
</body>
</html>

