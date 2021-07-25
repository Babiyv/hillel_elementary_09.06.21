package lesson12.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Entity(сущность) -

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "377064910";

    public static Connection getConnection() {
//        Connection connection = null; //1.1
        try {
            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //1.1
            return DriverManager.getConnection(URL, USERNAME, PASSWORD); //1.2
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        return connection; //1.1
        return null; //1.2
    }
}
