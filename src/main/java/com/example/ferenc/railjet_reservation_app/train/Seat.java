package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;

public class Seat {

    private RJX162Stations startStation;
    private RJX162Stations endStation;

    private boolean isReserved;

    public Seat(RJX162Stations startStation, RJX162Stations endStation, boolean isReserved) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.isReserved = isReserved;
    }

    public RJX162Stations getStartStation() {
        return startStation;
    }

    public RJX162Stations getEndStation() {
        return endStation;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setEndStation(RJX162Stations endStation) {
        this.endStation = endStation;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setStartStation(RJX162Stations startStation) {
        this.startStation = startStation;
    }

    public void checkIfSeatFree(String StationName){

        RJX162Stations station = RJX162Stations.getStation(StationName);

        if(station.getId() >= this.endStation.getId()){
            this.isReserved = false;
        }
        else{
            this.isReserved = true;
        }

    }
}
