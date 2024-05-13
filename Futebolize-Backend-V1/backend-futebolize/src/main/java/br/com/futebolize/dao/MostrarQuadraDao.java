package br.com.futebolize.dao;

import br.com.futebolize.model.Field;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarQuadraDao {

    public static List<List<Object>> matrizQuadra = new ArrayList<>();
    public static void quadrasField(){
        String SQL = "SELECT * FROM FIELDS";
        ResultSet quadras;
        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            System.out.println("success in database connection");
            quadras = preparedStatement.executeQuery();
            int columnCount = quadras.getMetaData().getColumnCount();

            while (quadras.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(quadras.getObject(i));
                }
                matrizQuadra.add(row);
            }


        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados");
            System.out.println(e.getMessage());

        }
    }


}
