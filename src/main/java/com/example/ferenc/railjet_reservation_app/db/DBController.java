package com.example.ferenc.railjet_reservation_app.db;


import com.example.ferenc.railjet_reservation_app.routes.Station;
import com.example.ferenc.railjet_reservation_app.train.ClassType;
import com.example.ferenc.railjet_reservation_app.train.Railcar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            throw new SQLException("Sikertelen adatmentés! / Datenspeicherung fehlgeschlagen!"+e.getMessage());
        }

    }

    public void StartSaving() throws SQLException {

        try {
            stm = conn.prepareStatement("start transaction");
            stm.execute();
            stm.clearParameters();
        } catch (Exception e) {
            throw new SQLException("Visszaállítási pont létrehozása sikertelen! / Erstellen des Rücksetzungspunktes fehlgeschlagen!");
        }

    }

    public void ResetTrainData() throws SQLException {

        try {
            stm = conn.prepareStatement("rollback");
            stm.execute();
            stm.clearParameters();
        } catch (Exception e) {
            throw new SQLException("Ülőhely adatbázis sikeresen visszaállt az alapállapotba! / Datenbankrücksetzung erfolgreich!");
        }
    }

    public List<Railcar> GetTrainData() throws SQLException {

        List<Railcar> train = new ArrayList<>();

        try {

            stm = conn.prepareStatement("select * from railcardata_rjx162");

            ResultSet rs = stm.executeQuery();

            while (rs.next()){

                train.add(new Railcar(rs.getInt("id"), rs.getString("wagennummer"), rs.getString("wagenklasse"), ClassType.GetClassType(rs.getString("wagentyp")), rs.getInt("sitzplatzanzahl"), 0));

            }
            rs.close();
            stm.clearParameters();

        } catch (Exception e) {
            throw new SQLException("Sikertelen adatbetöltés! / Beim laden der Dateien ist ein Fehler aufgetreten! "+e.getMessage());
        }

        return train;
    }

    public void setReservations(Railcar car) throws SQLException {

        try {

            stm = conn.prepareStatement("update railcardata set reservierungen=? where id=? and wagennummer=?");
            stm.setInt(1, car.getReservedSeatsNumber());
            stm.setInt(2, car.getId());
            stm.setString(3, car.getCarNumber());

            stm.executeUpdate();

            stm.clearParameters();

        } catch (Exception e) {
            throw new SQLException("Az ülőhelyfoglaltság frissítése sikertelen volt! / Die aktualisierung der Sitzplatzreservierungen war fehlgeschlagen!");
        }


    }

    public List<Station> getTimeTable(String timeTableName) throws SQLException {

        List<Station> stations = new ArrayList<Station>();

        try {
            stm = conn.prepareStatement("select * from "+timeTableName);

            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                stations.add(new Station(rs.getString("bahnhof"), rs.getInt("bahnhofnummer"), rs.getString("abfahrtszeit")));
            }

            rs.close();
            stm.clearParameters();

        } catch (Exception e) {
            throw new SQLException("A menetrend betöltése sikertelen volt! / Der Fahrplan konnte nicht geladen werden!");
        }

        return stations;
    }

}
