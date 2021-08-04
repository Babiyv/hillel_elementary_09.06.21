package lesson13.homework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Прописываем базу данных с которой будем взаимодействовать*/
public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/homework11";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "377064910";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}