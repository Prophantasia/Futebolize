package br.com.futebolize.servlet;

import br.com.futebolize.dao.DatabaseDao;
import br.com.futebolize.dao.UserDao;
import br.com.futebolize.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @Desenvolvido por: Matheus Campos & Rafael Abrantes
@WebServlet("/cadastrar")
public class CadastroUsuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria o banco de dados caso não exista
        DatabaseDao databaseDao = new DatabaseDao();
        databaseDao.createDatabase();

        // Inicializa as classes UserDao e User
        User user = new User();
        UserDao userDao = new UserDao();

        // Insere os valores no objeto user
        user.setName(request.getParameter("nameLogin"));
        user.setPassword(request.getParameter("passLogin"));
        user.setEmail(request.getParameter("emailLogin"));
        user.setAdress(request.getParameter("addressLogin"));
        user.setCpf(request.getParameter("cpfLogin"));
        user.setPhone(request.getParameter("phoneLogin"));

        // Manda a instância User para a classe Dao
        userDao.createUser(user);

        // Redireciona para a página de login
        response.sendRedirect("/html/login.html");
    }
}