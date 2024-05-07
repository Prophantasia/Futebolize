package br.com.futebolize.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// @Desenvolvido por: Matheus Campos
public class DatabaseDao {

    public void createDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS CUSTOMER (" +
                "ID INT AUTO_INCREMENT NOT NULL," +
                "NAME VARCHAR(50) NOT NULL," +
                "CPF VARCHAR(11) NOT NULL," +
                "ADDRESS VARCHAR(300) NOT NULL," +
                "PHONE_NUMBER VARCHAR(11) NOT NULL," +
                "EMAIL VARCHAR(50)," +
                "PASSWORD VARCHAR(30)," +
                "NIVEL VARCHAR(30)," +
                "PRIMARY KEY (ID));" +

                "CREATE TABLE IF NOT EXISTS FIELDS (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(300) NOT NULL," +
                "image_path VARCHAR(MAX)," +
                "score INT," +
                "address VARCHAR(300) NOT NULL," +
                "state VARCHAR(100) NOT NULL," +
                "max_players INT," +
                "rent_value DECIMAL(5,2));";



        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Tabela CUSTOMER criada!");
            System.out.println("Tabela FIELDS criada!");
            ps.close();
        } catch (SQLException err) {
            System.out.println("Erro ao criar a tabela CUSTOMER. ERRO: "+err.getMessage());
        }

        // Cria o usuário Admin ao inicializar o banco
        sql = "INSERT INTO CUSTOMER (NAME, CPF, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD, NIVEL)" +
                "SELECT 'Admin', ' ', ' ', ' ', 'admin', '123@mudar', 'admin'" +
                "WHERE NOT EXISTS(" +
                "SELECT 1 FROM CUSTOMER WHERE EMAIL = 'admin');";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Admin inserido com sucesso!");
            ps.close();
        } catch (SQLException err) {
            System.out.println("Erro ao criar o usuário Admin. ERRO: "+err.getMessage());
        }


    }
}
