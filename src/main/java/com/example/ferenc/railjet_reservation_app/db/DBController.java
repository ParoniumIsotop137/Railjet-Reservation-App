package com.example.ferenc.railjet_reservation_app.db;


import com.example.ferenc.railjet_reservation_app.train.Railcar;

import java.sql.*;

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

    public void CreateCar(Railcar car) throws SQLException {

        try {

            stm = conn.prepareStatement("Insert into railcardata (wagennummer, wagenklasse, wagentyp, sitzplatzanzahl, reservierungen) values (?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, car.getCarNumber());
            stm.setString(2, car.getType());
            stm.setString(3, car.getClassType().toString());
            stm.setInt(4, car.getMaxSeatsNumber());
            stm.setInt(5, 0);

            stm.executeUpdate();

            ResultSet rs = stm.getGeneratedKeys();

            if(rs.next()){
                car.setId(rs.getInt(1));
            }

            stm.clearParameters();



        } catch (Exception e) {
            throw new SQLException("Sikertelen adatmentés! Datenspeicherung fehlgeschlagen!"+e.getMessage());
        }

    }

    public void StartSaving() throws SQLException {

        try {
            stm = conn.prepareStatement("start transaction");
            stm.execute();
            stm.clearParameters();
        } catch (Exception e) {
            throw new SQLException("Visszaállítási pont létrehozása sikertelen! Erstellen des Rücksetzungspunktes fehlgeschlagen!");
        }

    }

    public void ResetTrainData() throws SQLException {

        try {
            stm = conn.prepareStatement("rollback");
            stm.execute();
            stm.clearParameters();
        } catch (Exception e) {
            throw new SQLException("Ülőhely adatbázis sikeresen visszaállt az alapállapotba! Datenbankrücksetzung erfolgreich!");
        }
    }

}
