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


// @Desenvolvido por: Matheus Campos
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria o banco de dados caso não exista
        DatabaseDao databaseDao = new DatabaseDao();
        databaseDao.createDatabase();

        // Inicializa as classes UserDao e User
        User user = new User();
        UserDao userDao = new UserDao();

        // Realiza o delete no banco
        userDao.deleteUser(request.getSession().getAttribute("email").toString(), request.getSession().getAttribute("pass").toString());
        request.getSession().invalidate();
        response.sendRedirect("/html/login.html");
    }
}