package br.com.futebolize.servlet;

import br.com.futebolize.dao.UserDao;
import br.com.futebolize.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Desenvolvido por: Rafael Soares
@WebServlet("/cadastrar.html")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String cpf = request.getParameter("cpf");
        String phone = request.getParameter("phone");

        UserDao userDao = new UserDao();

        User user = new User(userName, password, email, adress, cpf, phone);

        userDao.createUser(user);
    }


}
