package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;

public class Seat {

    private RJX162Stations startStation;
    private RJX162Stations endStation;

    private int numberOfPersons;

    private boolean isReserved;

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public Seat(RJX162Stations startStation, RJX162Stations endStation, int numberOfPersons) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.numberOfPersons = 0;
        this.isReserved = true;
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

    public void checkIfSeatFree(RJX162Stations startStation, RJX162Stations endStation){


        if(startStation.getId() < this.startStation.getId() && endStation.getId() < this.endStation.getId()) {
            setReserved(true);
        } else if (startStation.getId() > this.startStation.getId() && endStation.getId() < this.endStation.getId()) {
            setReserved(true);
        } else if (startStation.getId() > this.startStation.getId() && endStation.getId() > this.endStation.getId()) {
            setReserved(false);
        } else if (startStation.getId() < this.endStation.getId()) {
            setReserved(true);
        } else{
            setReserved(false);
        }

    }

}
