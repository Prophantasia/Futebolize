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
        String SQl = "INSERT INTO COSTUMER (NAME, CPF, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQl);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getAdress());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());

            preparedStatement.execute();

            System.out.println("success in insert user");

            connection.close();

        }catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail in database connection");
        }
    }
}
