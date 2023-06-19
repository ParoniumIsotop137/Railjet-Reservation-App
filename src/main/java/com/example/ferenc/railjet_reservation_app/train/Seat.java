package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;

public class Seat {

    private int startStationId;
    private int endStationId;

    private int numberOfPersons;

    private boolean isReserved;



    public Seat(int startStationId, int endStationId, int numberOfPersons) {
        this.startStationId = startStationId;
        this.endStationId = endStationId;
        this.numberOfPersons = numberOfPersons;
        this.isReserved = true;
    }

    public int getStartStationId() {
        return startStationId;
    }

    public int getEndStationId() {
        return endStationId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setEndStationId(int endStationId) {
        this.endStationId = endStationId;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setStartStationId(int startStationId) {
        this.startStationId = startStationId;
    }

    public void checkIfSeatFree(int startStationId, int endStationId){

        if(this.endStationId < startStationId) {
            this.setReserved(false);
        } else if (this.startStationId > endStationId) {
            this.setReserved(false);
        } else if (this.startStationId < startStationId && this.endStationId < endStationId) {
            this.setReserved(false);
        } else{
            this.setReserved(true);
        }


    }
    /*
    @Override
    public String toString() {
        return "Ülőhely / Stitzplatz von: "+ startStation.getName() +
                "\nállomástól / bis: " + endStation.getName() +
                "\nutasok száma / Personen: " + String.valueOf(numberOfPersons)+" fő\n";
    */
}
