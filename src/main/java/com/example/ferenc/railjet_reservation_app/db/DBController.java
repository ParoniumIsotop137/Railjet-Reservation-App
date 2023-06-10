package com.example.ferenc.railjet_reservation_app.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBController {

    private static Connection conn;
    private static PreparedStatement stm;

    public DBController(String db_url, String userName, String password) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(db_url, userName, password);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new SQLException("Adatbázis csatlakozási hiba! / Fehler bei der Verbinung der Datenbank!"+e.getMessage());
        }
    }

}
