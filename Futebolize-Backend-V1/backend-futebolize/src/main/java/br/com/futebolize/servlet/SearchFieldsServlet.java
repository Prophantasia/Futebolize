package br.com.futebolize.servlet;

import br.com.futebolize.dao.AutenticarDao;
import br.com.futebolize.model.User;
import br.com.futebolize.dao.DatabaseDao;
import br.com.futebolize.dao.SearchFieldDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet("/imagemQuadra")
public class SearchFieldsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SearchFieldDao searchFieldDao = new SearchFieldDao();

        String imagePath = searchFieldDao.showFields(); // armazena o resultado de showFields() na variavel imagePath
        request.setAttribute("imagePath", imagePath); // Define o caminho da imagem como atributo de solicitação
        request.getRequestDispatcher("quadras.html").forward(request, response); // Redireciona para a página quadras.html
    }
}
