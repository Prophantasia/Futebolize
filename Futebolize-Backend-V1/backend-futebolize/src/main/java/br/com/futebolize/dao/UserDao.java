package br.com.futebolize.dao;

import br.com.futebolize.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Desenvolvido por: Rafael Soares
public class UserDao {

    //Criação do usuário com os elementos do banco
    public void createUser(User user) {
        String SQl = "INSERT INTO COSTUMER (NAME, CPF, ADRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQl);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAdress());
            preparedStatement.setString(4, user.getCpf());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.execute();

            System.out.println("success in insert user");

            connection.close();

        }catch(Exception e) {
            System.out.println("fail in database connection");
        }
    }
}
