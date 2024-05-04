package br.com.futebolize.servlet;

import br.com.futebolize.dao.AutenticarDao;
import br.com.futebolize.dao.DatabaseDao;
import br.com.futebolize.model.User;

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

        // Realiza a autenticação e vai para a página sobre se logado
        if(auth.autenticarUser(user)){
            request.getSession().setAttribute("usuarioEmail", user.getEmail());
            response.sendRedirect("/html/quadras.jsp");
        }
        else
            response.sendRedirect("/html/login.html");
    }
}