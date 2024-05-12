package br.com.futebolize.servlet;

import br.com.futebolize.dao.DatabaseDao;
import br.com.futebolize.dao.FieldDao;
import br.com.futebolize.model.Field;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastrarQuadra")
public class CadastroFieldServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Inicializa as classes Field e FieldDao
        Field field = new Field();
        FieldDao fieldDao = new FieldDao();

        // Insere os valores no objeto field
        field.setName(request.getParameter("fieldName"));
        field.setImage_path(request.getParameter("fieldImagePath"));
        field.setAddress(request.getParameter("fieldAddress"));
        field.setState(request.getParameter("fieldState"));
        field.setMax_players(Integer.parseInt(request.getParameter("maxPlayers")));
        field.setRent_value(Integer.parseInt(request.getParameter("fieldRentValue")));

        // Manda a instância field para a classe Dao
        fieldDao.createField(field);

        // Redireciona para a página de quadras
        response.sendRedirect("/html/indexLogado.jsp");
    }
}
