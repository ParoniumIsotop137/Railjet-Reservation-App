package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.Rjx162Stations;

public class Seat {

    private Rjx162Stations startStation;
    private Rjx162Stations endStation;

    private boolean isReserved;

    public Seat(Rjx162Stations startStation, Rjx162Stations endStation, boolean isReserved) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.isReserved = isReserved;
    }

    public Rjx162Stations getStartStation() {
        return startStation;
    }

    public Rjx162Stations getEndStation() {
        return endStation;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setEndStation(Rjx162Stations endStation) {
        this.endStation = endStation;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setStartStation(Rjx162Stations startStation) {
        this.startStation = startStation;
    }

    public void checkIfSeatFree(String StationName){

        Rjx162Stations station = Rjx162Stations.getStation(StationName);

        if(station.getId() >= this.endStation.getId()){
            this.isReserved = false;
        }
        else{
            this.isReserved = true;
        }

    }
}
