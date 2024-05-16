package br.com.futebolize.dao;

import br.com.futebolize.model.Field;

import java.sql.*;
import java.util.ArrayList;

public class SearchFieldDao {

    public static int showFields() {
        //query para descobrir quantos registros existem na tabela
        String SQL = "SELECT COUNT(ID) FROM FIELDS";
        ResultSet qtdQuadras;

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            System.out.println("success in database connection");

            qtdQuadras = preparedStatement.executeQuery();

            if (qtdQuadras.next()) {
                int count = qtdQuadras.getInt(1);
                System.out.println(count);
                return count;
            } else {

                System.out.println("Nenhum resultado retornado.");
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados");
            System.out.println(e.getMessage());

            return 0;
        }
    }

    public ArrayList<Field> listarFields() {
        String SQL = "SELECT * FROM FIELDS";
        ArrayList<Field> fields = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            System.out.println("success in database connection");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Field field = new Field();
                field.setName(rs.getString("NAME"));
                field.setImage_path(rs.getString("IMAGE_PATH"));
                field.setAddress(rs.getString("ADDRESS"));
                fields.add(field);
            }

            for (Field field : fields) {
                System.out.println(field.getName());
            }
            return fields;

        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados");
            System.out.println(e.getMessage());
            return fields;
        }
    }

}