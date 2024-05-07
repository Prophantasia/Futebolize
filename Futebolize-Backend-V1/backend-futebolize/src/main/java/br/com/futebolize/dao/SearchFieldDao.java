package br.com.futebolize.dao;

import java.sql.*;

public class SearchFieldDao {

    public String showFields() {
        String SQL = "SELECT IMAGE_PATH FROM FIELDS WHERE ID = 1";
        String imagePath = null;

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso na conexão com o banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Move o cursor para a primeira linha do resultado
            if (resultSet.next()) {
                // Obtém o valor da coluna IMAGE_PATH
                imagePath = resultSet.getString("IMAGE_PATH");
                System.out.println("O caminho da imagem é: " + imagePath);
            } else {
                System.out.println("Nenhuma linha encontrada para o ID fornecido");
            }

        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados");
            System.out.println(e.getMessage());
        }

        return imagePath;
    }


}