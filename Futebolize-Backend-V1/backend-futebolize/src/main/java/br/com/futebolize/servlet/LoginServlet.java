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
@WebServlet("/cadastrar")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("nameLogin"); // Corrigido para "nameLogin"
        String password = request.getParameter("passLogin"); // Corrigido para "passLogin"
        String email = request.getParameter("emailLogin"); // Corrigido para "emailLogin"
        String address = request.getParameter("addressLogin"); // Corrigido para "adressLogin"
        String cpf = request.getParameter("cpfLogin"); // Corrigido para "cpfLogin"
        String phone = request.getParameter("phoneLogin"); // Corrigido para "phoneLogin"

        UserDao userDao = new UserDao();

        User user = new User(userName, password, email, address, cpf, phone);

        userDao.createUser(user);
    }
}

