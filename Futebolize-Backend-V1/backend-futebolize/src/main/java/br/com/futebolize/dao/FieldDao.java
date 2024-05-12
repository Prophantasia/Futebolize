package br.com.futebolize.dao;

import br.com.futebolize.model.Field;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FieldDao {

    public void createField (Field field) {
        String SQl = "INSERT INTO FIELDS (NAME, IMAGE_PATH, ADDRESS, STATE,  MAX_PLAYERS, RENT_VALUE) VALUES ( ?, ?, ?, ?, ?, ?)";

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);
            System.out.println("success in database connection");

            // Insere na query os valores
            preparedStatement.setString(1, field.getName());
            preparedStatement.setString(2, field.getImage_path());
            preparedStatement.setString(3, field.getAddress());
            preparedStatement.setString(4, field.getState());
            preparedStatement.setInt(5, field.getMax_players());
            preparedStatement.setDouble(6, field.getRent_value());

            // Executa a query
            preparedStatement.execute();


            System.out.println("success in insert field");
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail in database connection");
    }
}
}
