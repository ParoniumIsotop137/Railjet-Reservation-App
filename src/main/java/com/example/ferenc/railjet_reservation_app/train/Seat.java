package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;

public class Seat {

    private RJX162Stations startStation;
    private RJX162Stations endStation;

    private int numberOfPersons;

    private boolean isReserved;



    public Seat(RJX162Stations startStation, RJX162Stations endStation, int numberOfPersons) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.numberOfPersons = numberOfPersons;
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

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setStartStation(RJX162Stations startStation) {
        this.startStation = startStation;
    }

    public void checkIfSeatFree(RJX162Stations startStation, RJX162Stations endStation){

        if(this.endStation.getId() < startStation.getId()) {
            this.setReserved(false);
        } else if (this.startStation.getId() > endStation.getId()) {
            this.setReserved(false);
        } else if (this.startStation.getId() < startStation.getId() && this.endStation.getId() < endStation.getId()) {
            this.setReserved(false);
        } else{
            this.setReserved(true);
        }


    }

}
