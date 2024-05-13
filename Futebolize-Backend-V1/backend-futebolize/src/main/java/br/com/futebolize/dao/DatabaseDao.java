package br.com.futebolize.dao;

import org.apache.commons.codec.digest.DigestUtils;

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
                "PASSWORD VARCHAR(64)," +
                "NIVEL VARCHAR(30)," +
                "PRIMARY KEY (ID));" +

                "CREATE TABLE IF NOT EXISTS FIELDS (" +
                "id INT AUTO_INCREMENT NOT NULL," +
                "name VARCHAR(300) NOT NULL," +
                "image_path VARCHAR(MAX)," +
                "score INT DEFAULT NULL," +
                "address VARCHAR(300) NOT NULL," +
                "state VARCHAR(100) NOT NULL," +
                "max_players INT," +
                "rent_value VARCHAR(15));"+

                "CREATE TABLE IF NOT EXISTS OWNER ("+
                "	id INT AUTO_INCREMENT NOT NULL,"+
                "	name VARCHAR(100) NOT NULL,"+
                "	cnpj INT NOT NULL,"+
                "	phone_number INT NOT NULL,"+
                "	address VARCHAR(300) NOT NULL,"+
                "	email VARCHAR(100),"+
                "	password VARCHAR(100))";



        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Tabela CUSTOMER criada!");
            System.out.println("Tabela FIELDS criada!");
            System.out.println("Tabela OWNER criada!");
            ps.setQueryTimeout(100);
            ps.close();
        } catch (SQLException err) {
            System.out.println("Erro ao criar as tabelas. ERRO: "+err.getMessage());
        }

        try {
            // realiza a criptografia da senha
            String senhaCript = DigestUtils.sha256Hex("123@mudar");

            // Cria o usuário Admin ao inicializar o banco
            sql = "INSERT INTO CUSTOMER (NAME, CPF, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD, NIVEL)" +
                    "SELECT 'Admin', ' ', ' ', ' ', 'admin', "+"'"+senhaCript+"'"+", 'admin'" +
                    "WHERE NOT EXISTS(" +
                    "SELECT 1 FROM CUSTOMER WHERE EMAIL = 'admin');";

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
