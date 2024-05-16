package br.com.futebolize.dao;

import br.com.futebolize.model.Field;

import java.util.*;
import java.sql.*;

public class StoreFieldsDao {


    public static ArrayList<Field> storeFields() throws SQLException {
        //query para coletar todos os registros da tabela Fields
        String SQL = "SELECT * FROM FIELDS";
        ArrayList<Field> fields = new ArrayList<>();

        ResultSet resultSet;

        try {
            // Realiza a conexão com o banco
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            System.out.println("Sucesso na conexão com o banco de dados");

            // Executa a consulta e obtém o resultado
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Field field = new Field();
                field.setId(resultSet.getInt("id"));
                field.setName(resultSet.getString("name"));
                field.setImage_path(resultSet.getString("image_path"));
                field.setScore(resultSet.getInt("score"));
                field.setAddress(resultSet.getString("address"));
                field.setState(resultSet.getString("state"));
                field.setMax_players(resultSet.getInt("max_players"));
                field.setRent_value(resultSet.getString("rent_value"));

                fields.add(field);
                return fields;
            }
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados");
            e.getMessage();
            return fields;
        }
        return fields;
    }
}


        /*Field[][] matrizFields = new Field[fields.size()][8];

        for (int i = 0; i < fields.size(); i++) {

            matrizFields[i] = new Field[]{fields.get(i)};

        }


        for (int i = 0; i < matrizFields.length; i++) {
            System.out.println("Row " + (i + 1) + ":");
            for (int j = 0; j < matrizFields[i].length; j++) {
                Field field = matrizFields[i][j];
                if (field != null) {
                    System.out.println("Id: " + field.getId());
                    System.out.println("Name: " + field.getName());
                    System.out.println("Image Path: " + field.getImage_path());
                    System.out.println("Score: " + field.getScore());
                    System.out.println("Address: " + field.getAddress());
                    System.out.println("State: " + field.getState());
                    System.out.println("Max Players: " + field.getMax_players());
                    System.out.println("Rent Value: " + field.getRent_value());
                    System.out.println("--------------------------");
                } else {
                    System.out.println("Empty");
                }
            }
        }
        //return matrizFields;
    }


    }


    /*public static void printFieldMatrix(Field[][] fieldMatrix) {
        // Itera sobre a matriz e imprime cada elemento
        for (int i = 0; i < fieldMatrix.length; i++) {
            System.out.println("Row " + (i + 1) + ":");
            for (int j = 0; j < fieldMatrix[i].length; j++) {
                Field field = fieldMatrix[i][j];
                if (field != null) {
                    System.out.println("Id: " + field.getId());
                    System.out.println("Name: " + field.getName());
                    System.out.println("Image Path: " + field.getImage_path());
                    System.out.println("Score: " + field.getScore());
                    System.out.println("Address: " + field.getAddress());
                    System.out.println("State: " + field.getState());
                    System.out.println("Max Players: " + field.getMax_players());
                    System.out.println("Rent Value: " + field.getRent_value());
                    System.out.println("--------------------------");
                } else {
                    System.out.println("Empty");
                }
            }
        }
    }


}*/

