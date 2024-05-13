<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="br.com.futebolize.dao.SearchFieldDao"%>

<%// @Desenvolvido por: Matheus Campos %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null)
        response.sendRedirect("quadras.jsp");
%>

<html>
<head>
    <title>Title</title>
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
        <li><a href="quadras.jsp">QUADRAS</a></li>
        <li><a href="sobre.jsp">SOBRE</a></li>
        <li><a href="login.html">LOGIN</a></li>
        <li><a href="cadastrarQuadras.jsp">CADASTRAR QUADRA</a></li>
    </ul>
</nav>

    <div id="divContainer">

    </div>


    <script>
    <%
        int qtdQuadrasJava = SearchFieldDao.showFields();
    %>
        window.onload = function() {
            var qtdQuadras = <%= qtdQuadrasJava %>

            function createDiv(qtdQuadras) {
                var divContainer = document.getElementById("divContainer");

                for (var i = 0; i < qtdQuadras; i++) {
                    var div = document.createElement("div");
                    div.className = "quadra";

                    var img = document.createElement("img");
                    img.src = "../img/1715560184389-quadraportorico.jpg";
                    img.alt = "Imagem";
                    div.appendChild(img);

                    var p1 = document.createElement("p");
                    p1.textContent = "Texto do parágrafo 1";
                    div.appendChild(p1);

                    var p2 = document.createElement("p");
                    p2.textContent = "Texto do parágrafo 2";
                    div.appendChild(p2);

                    divContainer.appendChild(div);
                }
            }

            createDiv(qtdQuadras);
        };
    </script>

    Quadras Logado.



</body>
</html>
