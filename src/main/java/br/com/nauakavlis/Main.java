package br.com.nauakavlis;

import br.com.nauakavlis.database.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        if (testConnection()) {
            System.out.println("Conectado com sucesso!");
        } else {
            System.out.println("Falha na conexão");
        }
    }

    public static boolean testConnection() {
        try (
            Connection connection = Database.getConnection();
        ) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}