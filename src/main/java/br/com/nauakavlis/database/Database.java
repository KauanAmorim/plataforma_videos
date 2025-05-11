package br.com.nauakavlis.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Database {
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("application");
        URL = rb.getString("database.url");
        USER = rb.getString("database.user");
        PASSWORD = rb.getString("database.pass");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
