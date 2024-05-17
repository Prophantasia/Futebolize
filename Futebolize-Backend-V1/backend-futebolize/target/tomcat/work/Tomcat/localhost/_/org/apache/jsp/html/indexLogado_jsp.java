/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-05-17 04:11:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.futebolize.servlet.AutenticationServlet;
import java.util.Objects;
import br.com.futebolize.dao.UserDao;
import br.com.futebolize.model.User;

public final class indexLogado_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    // Verifica se o atributo na sessão é null


    UserDao userDao = new UserDao();
    User userServer = new User();
    userServer.setEmail(request.getSession().getAttribute("email").toString());
    userServer.setPassword(request.getSession().getAttribute("pass").toString());
    User user = userDao.buscarUser(userServer);

    if(request.getSession().getAttribute("usuarioLogado") == null){
        response.sendRedirect("../index.jsp");
    } else {
        if(user.getRole().equals("default")){
            response.sendRedirect("indexLogadoDefault.jsp");
        }
    }


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    function confirm(){\r\n");
      out.write("\r\n");
      out.write("        setTimeout(() => {\r\n");
      out.write("            Swal.fire({\r\n");
      out.write("                position: \"top-end\",\r\n");
      out.write("                icon: \"success\",\r\n");
      out.write("                title: \"Usuário autenticado!\",\r\n");
      out.write("                toast: true,\r\n");
      out.write("                showConfirmButton: false,\r\n");
      out.write("                timer: 3500,\r\n");
      out.write("                timerProgressBar: true,\r\n");
      out.write("                didOpen: (toast) => {\r\n");
      out.write("                    toast.onmouseenter = Swal.stopTimer;\r\n");
      out.write("                    toast.onmouseleave = Swal.resumeTimer;\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }, 1000);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    ");

    if(request.getSession().getAttribute("usuarioLogado") != null){
       if(request.getSession().getAttribute("logadoFlag") == null){
           request.getSession().setAttribute("logadoFlag", true);
           String cmd = "confirm();";
           out.print(cmd);
       }
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- @Desenvolvido por: Matheus Campos & Rafael Abrantes -->\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1\">\r\n");
      out.write("    <title>Futebolize</title>\r\n");
      out.write("    <link rel=\"icon\" href=\"../assets/images/ball.ico\">\r\n");
      out.write("    <link href=\"../css/styleLogado.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"../css/ui.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <nav>\r\n");
      out.write("        <a href=\"../index.jsp\">\r\n");
      out.write("            <img class=\"logo\" src=\"/assets/images/logo.png\"> </a>\r\n");
      out.write("        <div class=\"mobile-menu\">\r\n");
      out.write("            <div class=\"line1\"></div>\r\n");
      out.write("            <div class=\"line2\"></div>\r\n");
      out.write("            <div class=\"line3\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"nav-list\">\r\n");
      out.write("            <li><a href=\"quadras.jsp\">QUADRAS</a></li>\r\n");
      out.write("            <li><a href=\"cadastrarQuadras.jsp\">CADASTRAR QUADRA</a></li>\r\n");
      out.write("            <li><a href=\"perfil.jsp\">MEU PERFIL</a></li>\r\n");
      out.write("            <li><a href=\"sair.jsp\">SAIR</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("    <h1>\r\n");
      out.write("        <BR><BR><BR>\r\n");
      out.write("        Ola! Bem vindo a área do dono Futebolize!\r\n");
      out.write("    </h1>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"text_log\">\r\n");
      out.write("        <p>Por aqui você pode acessar todos os nossos conteúdos disponibilizados, como por exemplo: </p>\r\n");
      out.write("            <li>Quadras cadastradas no sistema;</li>\r\n");
      out.write("            <li>Cadastro de quadras novas;</li>\r\n");
      out.write("            <li>Atualização do seu perfil;</li>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"text_log2\">\r\n");
      out.write("        <p>Explore o mundo do futebol e organize partidas com seus amigos da forma que mais gostarem!</p><br>\r\n");
      out.write("        <p>Deseja cadastrar uma quadra?<a href=\"cadastrarQuadras.jsp\">Clique aqui!</a></p>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <p>&copy; 2024 - Todos os direitos reservados</p>\r\n");
      out.write("    <p>Entre em contato pelo e-mail: futebolize@contato.com</p>\r\n");
      out.write("</footer>\r\n");
      out.write("<script src=\"../javascript/script.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11.11.0/dist/sweetalert2.all.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
