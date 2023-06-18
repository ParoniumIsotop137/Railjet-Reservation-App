package com.example.ferenc.railjet_reservation_app.routes;

public class Station {

    private String stationName;
    private int stationNumber;
    private String timeTableTime;


    public Station(String stationName, int stationNumber, String timeTableTime) {
        this.stationName = stationName;
        this.stationNumber = stationNumber;
        this.timeTableTime = timeTableTime;
    }

    public String getStationName() {
        return stationName;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public String getTimeTableTime() {
        return timeTableTime;
    }
}
