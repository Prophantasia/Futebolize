package br.com.futebolize.servlet;

import br.com.futebolize.dao.FieldDao;
import br.com.futebolize.model.Field;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.parameters;
import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet("/cadastrarQuadra")
public class CadastroFieldServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Map<String, String> parameters = uploadImage(request);

        // Inicializa as classes Field e FieldDao
        Field field = new Field();
        FieldDao fieldDao = new FieldDao();
        String image = parameters.get("image");

        // Insere os valores no objeto field
        field.setName(parameters.get("fieldName"));
        field.setImage_path(parameters.get("image"));
        field.setAddress(parameters.get("fieldAddress"));
        field.setState(parameters.get("fieldState"));
        field.setMax_players(Integer.parseInt(parameters.get("maxPlayers")));
        field.setRent_value(parameters.get("fieldRentValue"));

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

            requestParameters.put(fileItem.getFieldName(), fileItem.getString());

        } else {

            String fileName = processUploadedFile(fileItem);

            requestParameters.put("image", fileName);
        }

    }

    private String processUploadedFile(FileItem fileItem) throws Exception {

        long currentTime = new Date().getTime();

        String fileName = Long.toString(currentTime).concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);

        fileItem.write(new File(filePath));

        return fileName;
    }
}
