package br.com.futebolize.servlet;

import br.com.futebolize.dao.AutenticarDao;
import br.com.futebolize.dao.UserDao;
import br.com.futebolize.model.User;
import br.com.futebolize.dao.DatabaseDao;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

// @Desenvolvido por: Matheus Campos
@WebServlet("/auntenticar")
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
    }
}
