package br.com.futebolize.dao;

import br.com.futebolize.model.User;



import java.sql.*;



// @Desenvolvido por: Matheus Campos, Rafael Abrantes & Gabriel Henrique
public class UserDao {

    //Envio dos usuários para o banco de dados
    public void createUser(User user) {
        String SQl = "INSERT INTO CUSTOMER (NAME, CPF, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD, NIVEL) VALUES (?, ?, ?, ?, ?, ?, 'default')";

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);
            System.out.println("success in database connection");

            // Insere na query os valores
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getAdress());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());

            // Executa a query
            preparedStatement.execute();


            System.out.println("success in insert user");
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail in database connection");
        }
    }

    public void deleteUser(String email, String pass) {
        String SQl = "DELETE FROM CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?";

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);
            System.out.println("success in database connection");

            // Insere na query os valores
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);

            // Executa a query
            preparedStatement.execute();


            System.out.println("success in delete user");
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail in database connection");
        }
    }

    public User buscarUser(User user) {
        String SQl = "SELECT * FROM CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?";

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);

            // Insere na query os valores
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            // Executa a query
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            user.setName(resultSet.getString("NAME"));
            user.setCpf(resultSet.getString("CPF"));
            user.setAdress(resultSet.getString("ADDRESS"));
            user.setPhone(resultSet.getString("PHONE_NUMBER"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setRole(resultSet.getString("NIVEL"));
            System.out.println("success in search user");

            connection.close();
            return user;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail in database connection");
            return null;
        }
    }

    public void updateUser(User user, String email, String password) {
        String SQl = "UPDATE CUSTOMER SET NAME = ?, CPF = ?, ADDRESS = ?, PHONE_NUMBER = ?, EMAIL = ?, PASSWORD = ?, NIVEL = 'default' WHERE EMAIL = ? AND PASSWORD = ?";

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);
            System.out.println("success in database connection");

            // Insere na query os valores
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getAdress());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, password);


            // Executa a query
            preparedStatement.execute();

            System.out.println("success in update user");
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail in database connection");
        }
    }

}
