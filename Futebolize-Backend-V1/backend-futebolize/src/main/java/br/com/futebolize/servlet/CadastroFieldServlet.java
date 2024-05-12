package br.com.futebolize.servlet;

import br.com.futebolize.dao.DatabaseDao;
import br.com.futebolize.dao.FieldDao;
import br.com.futebolize.model.Field;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

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

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {

        HashMap<String, String> parameters = new HashMap<>();

        if(isMultipartContent(httpServletRequest)) {

            try {

                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                for (FileItem item : fileItems) {

                    checkFieldType(item, parameters);

                }
            }   catch (Exception e) {

                parameters.put("image", "img/default-quadra");

            }
        }
        return parameters;

    }

    private void checkFieldType(FileItem fileItem, Map requestParameters) throws Exception {

        if (fileItem.isFormField()) {

            requestParameters.put(fileItem.getFieldname(), fileItem.getString());

        } else {

            String fileName = processUploadedFile(fileItem);

            requestParameters.put("image", fileName);
        }

    }

    private String processUploadedFile(FileItem fileItem) throws Exception {

        Long currentTime = new Date().getTime();

        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);

        fileItem.write(new File(filePath));

        return fileName;
    }
}
