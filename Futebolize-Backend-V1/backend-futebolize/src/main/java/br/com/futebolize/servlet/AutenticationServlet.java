package br.com.futebolize.servlet;

import br.com.futebolize.dao.AutenticarDao;
import br.com.futebolize.dao.UserDao;
import br.com.futebolize.model.User;
import br.com.futebolize.dao.DatabaseDao;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

// @Desenvolvido por: Matheus Campos
@WebServlet("/autenticar")
public class AutenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria o banco de dados caso não exista
        DatabaseDao databaseDao = new DatabaseDao();
        databaseDao.createDatabase();

        // Inicializa as classe User
        User user = new User();
        AutenticarDao auth = new AutenticarDao();

        // Insere os valores no objeto user
        user.setEmail(request.getParameter("emailLogin"));
        user.setPassword(request.getParameter("passLogin"));

        // Realiza a criptografia da senha
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        // Realiza a autenticação e vai para a página sobre se logado
        if(auth.autenticarUser(user)){

            // Limpar atributos da sessão antiga
            request.getSession().removeAttribute("email");
            request.getSession().removeAttribute("pass");
            request.getSession().removeAttribute("usuarioLogado");

            // Adicionar atributos para a sessão
            request.getSession().setAttribute("email", user.getEmail());
            request.getSession().setAttribute("pass", user.getPassword());
            request.getSession().setAttribute("usuarioLogado", true);
            response.sendRedirect("/index.jsp");
        }
        else
            response.sendRedirect("/html/login.html");


       /*if(user.getEmail() != request.getSession().getAttribute("admin")){
           response.sendRedirect("/html/indexLogadoDefault.jsp");
       }*/
    }

    /*public enum NivelAcesso{
        ADMIN, DEFAULT;
    }
    @WebFilter("/paginaDono.jsp")
    public abstract static class ControleAcessoFilter implements Filter {
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            User user = (User) req.getSession().getAttribute("usuarioLogado");

            if (user != null && user.getRole() == NivelAcesso.ADMIN) {
                chain.doFilter(request, response); // Usuário autorizado
            } else {
                res.sendRedirect(req.getContextPath() + "/indexLogadoDefault.jsp"); // Redireciona para a página de login
            }
        }
    }*/
}



