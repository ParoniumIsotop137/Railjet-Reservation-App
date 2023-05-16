package com.example.ferenc.railjet_reservation_app.train;

public class Seat {

    private Stations startStation;
    private Stations endStation;

    private boolean isReserved;

    public Seat(Stations startStation, Stations endStation, boolean isReserved) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.isReserved = isReserved;
    }

    public Stations getStartStation() {
        return startStation;
    }

    public Stations getEndStation() {
        return endStation;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setEndStation(Stations endStation) {
        this.endStation = endStation;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setStartStation(Stations startStation) {
        this.startStation = startStation;
    }

    public void checkIfSeatFree(String StationName){

        Stations station = Stations.getStation(StationName);

        if(station.getId() >= this.endStation.getId()){
            this.isReserved = false;
        }
        else{
            this.isReserved = true;
        }

    }
}
