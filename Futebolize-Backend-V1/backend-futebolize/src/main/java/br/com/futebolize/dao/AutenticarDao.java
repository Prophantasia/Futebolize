package br.com.futebolize.dao;

import br.com.futebolize.model.User;

import java.sql.*;

// @Desenvolvido por: Matheus Campos
public class AutenticarDao {

    //Envio dos usuários para o banco de dados
    public boolean autenticarUser(User user) {
        String SQL = "SELECT * FROM CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?";

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso na conexão com o banco de dados");

            // Insere na query os valores
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            // Executa a query e guarda o valor na variável resultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Caso encontre registro na consulta
            if (resultSet.next()) {
                System.out.println("Usuário: "+resultSet.getString("NAME")+" autenticado com sucesso!");
                connection.close();
                return true;

            } else {
                System.out.println("Usuário não encontrado");
                connection.close();
                return false;
            }


        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados");
            System.out.println(e.getMessage());
            return false;
        }
    }

}
