<%@ page import="br.com.futebolize.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="br.com.futebolize.dao.SearchFieldDao"%>
<%@ page import="br.com.futebolize.model.Field" %>
<%@ page import="br.com.futebolize.dao.StoreFieldsDao" %>
<%@ page import="java.util.ArrayList" %>

<%// @Desenvolvido por: Matheus Campos %>

<%
    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null)
        response.sendRedirect("quadras.jsp");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/quadrasLogado.css">
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
        <li><a href="cadastrarQuadras.jsp">CADASTRAR QUADRA</a></li>
        <li><a href="perfil.jsp">MEU PERFIL</a></li>
        <li><a href="sair.jsp">SAIR</a></li>
    </ul>
</nav>

    <div id="divContainer">

    </div>


    <script>
    <%
        int qtdQuadrasJava = SearchFieldDao.showFields();

    %>

            <%
                    //Field[][] fieldList = StoreFieldsDao.storeFields();

                    //Field field = new Field();
                    ArrayList<Field> fields = StoreFieldsDao.storeFields();
            %>
        window.onload = function() {


            var qtdQuadras = <%= qtdQuadrasJava %> //era qtdQuadrasJava
            var fields = <%= new org.json.JSONArray(fields) %>;
            function createDiv(qtdQuadras) {
                var divContainer = document.getElementById("divContainer");

                for (var i = 0; i < qtdQuadras; i++) {
                    var field = fields[i];

                    var div = document.createElement("div");
                    div.className = "quadra";

                    var img = document.createElement("img");
                    img.src = "../img/";
                    img.alt = "Imagem";
                    div.appendChild(img);

                    var p1 = document.createElement("p");
                    p1.textContent = field.Name;
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
    <script src="../javascript/script.js"></script>

<img src="<%= fields.get(0).getImage_path()%>">


</body>
</html>
