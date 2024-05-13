package br.com.futebolize.servlet;

import br.com.futebolize.dao.DatabaseDao;
import br.com.futebolize.dao.UserDao;
import br.com.futebolize.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// @Desenvolvido por: Matheus Campos & Rafael Abrantes
@WebServlet("/atualizar")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria o banco de dados caso não exista
        DatabaseDao databaseDao = new DatabaseDao();
        databaseDao.createDatabase();

        // Inicializa as classes UserDao e User
        User user = new User();
        UserDao userDao = new UserDao();

        // Insere os valores no objeto user
        user.setEmail(request.getParameter("emailPerfil"));
        user.setName(request.getParameter("namePerfil"));
        user.setAdress(request.getParameter("addressPerfil"));
        user.setPhone(request.getParameter("phonePerfil"));
        user.setCpf(request.getParameter("cpfPerfil"));
        user.setPassword(request.getParameter("passPerfil"));


        // Realiza a criptografia da senha
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        // Realiza o update no banco
        userDao.updateUser(user, request.getSession().getAttribute("email").toString(), request.getSession().getAttribute("pass").toString());
        request.getSession().invalidate();
        response.sendRedirect("/html/login.html");
    }
}