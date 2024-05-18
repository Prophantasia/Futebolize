/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-05-17 22:59:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.futebolize.model.User;
import br.com.futebolize.dao.SearchFieldDao;
import br.com.futebolize.model.Field;
import java.util.ArrayList;
import br.com.futebolize.dao.UserDao;

public final class quadrasLogado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
// @Desenvolvido por: Matheus Campos e Gabriel Henrique 
      out.write("\r\n");
      out.write("\r\n");

    UserDao userDao = new UserDao();
    User userServer = new User();
    userServer.setEmail(request.getSession().getAttribute("email").toString());
    userServer.setPassword(request.getSession().getAttribute("pass").toString());
    User user = userDao.buscarUser(userServer);

    // Verifica se o atributo na sessão é null
    if(request.getSession().getAttribute("usuarioLogado") == null){
        response.sendRedirect("quadras.jsp");
    }else {
        if (user.getRole().equals("default")) {
            response.sendRedirect("quadrasLogadoDefault.jsp");
        }
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/quadrasLogadoDefault.css\">\r\n");
      out.write("    <link rel=\"icon\" href=\"../assets/images/ball.ico\">\r\n");
      out.write("    <title>Quadras</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("    <a href=\"../index.jsp\">\r\n");
      out.write("        <img class=\"logo\" src=\"/assets/images/logo.png\" alt=\"Logo\">\r\n");
      out.write("    </a>\r\n");
      out.write("    <div class=\"mobile-menu\">\r\n");
      out.write("        <div class=\"line1\"></div>\r\n");
      out.write("        <div class=\"line2\"></div>\r\n");
      out.write("        <div class=\"line3\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"nav-list\">\r\n");
      out.write("        <li><a href=\"cadastrarQuadras.jsp\">CADASTRAR QUADRA</a></li>\r\n");
      out.write("        <li><a href=\"perfil.jsp\">MEU PERFIL</a></li>\r\n");
      out.write("        <li><a href=\"sair.jsp\">SAIR</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div id=\"divContainer\">\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    window.onload = function() {\r\n");
      out.write("        var divContainer = document.getElementById(\"divContainer\");\r\n");
      out.write("\r\n");
      out.write("        function createDiv(qtdQuadrasJava) {\r\n");
      out.write("            for (let i = 0; i < qtdQuadrasJava; i++) {\r\n");
      out.write("                var div = document.createElement(\"div\");\r\n");
      out.write("                div.className = \"quadra\";\r\n");
      out.write("\r\n");
      out.write("                var img = document.createElement(\"img\");\r\n");
      out.write("                img.src = \"../img/\"+quadrasData[i].imagePath;\r\n");
      out.write("                img.alt = \"Imagem\";\r\n");
      out.write("                div.appendChild(img);\r\n");
      out.write("\r\n");
      out.write("                var p1 = document.createElement(\"p\");\r\n");
      out.write("                p1.textContent = quadrasData[i].name;\r\n");
      out.write("                div.appendChild(p1);\r\n");
      out.write("\r\n");
      out.write("                var p2 = document.createElement(\"p\");\r\n");
      out.write("                p2.textContent = quadrasData[i].address;\r\n");
      out.write("                div.appendChild(p2);\r\n");
      out.write("\r\n");
      out.write("                divContainer.appendChild(div);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // Dados do banco de dados\r\n");
      out.write("        var quadrasData = [];\r\n");
      out.write("        ");

            SearchFieldDao fieldDao = new SearchFieldDao();
            ArrayList<Field> fields = fieldDao.listarFields();
            for (Field field : fields) {
        
      out.write("\r\n");
      out.write("        quadrasData.push({\r\n");
      out.write("            name: \"");
      out.print( field.getName() );
      out.write("\",\r\n");
      out.write("            address: \"");
      out.print( field.getAddress() );
      out.write("\",\r\n");
      out.write("            imagePath: \"");
      out.print( field.getImage_path() );
      out.write("\"\r\n");
      out.write("        });\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        createDiv(quadrasData.length);\r\n");
      out.write("    };\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <p>&copy; 2024 - Todos os direitos reservados</p>\r\n");
      out.write("    <p>Entre em contato pelo e-mail: futebolize@contato.com</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
