package com.example.ferenc.railjet_reservation_app.train;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;

import java.util.ArrayList;
import java.util.List;

public class Railcar {

    private String type;
    private ClassType classType;
    private int maxSeatsNumber;

    private int reservedSeatsNumber;

    private List<Seat> seats;


    public Railcar(String type, ClassType classType, int maxSeatNumber, int reservedSeatNumber) {
        this.type = type;
        this.classType = classType;
        this.maxSeatsNumber = maxSeatNumber;
        this.reservedSeatsNumber = reservedSeatNumber;
        this.seats = new ArrayList<Seat>();
    }

    public String getType() {
        return type;
    }

    public ClassType getClassType() {
        return classType;
    }

    public int getMaxSeatsNumber() {
        return maxSeatsNumber;
    }


    public int getReservedSeatsNumber() {
        return reservedSeatsNumber;
    }

    public void setFreeSeatNumberAndSeat(Seat seat) {

        this.reservedSeatsNumber++;

        if(this.reservedSeatsNumber <= this.maxSeatsNumber){

            addNewSeatToList(seat);
        }
        else{
            if(CheckSeatReservation(seat.getStartStation())){
                setFreeSeatNumberAndSeat(seat);
            }
            else{
                throw new IllegalArgumentException("A kiválasztott kocsiban már nincsen több szabad hely!");
            }
        }

    }

    private boolean CheckSeatReservation(RJX162Stations startStation) {

        for (Seat seat : seats) {
            seat.checkIfSeatFree(startStation.getName());
        }
        this.reservedSeatsNumber = (int) seats.stream().filter(s -> s.isReserved() == true).count();

        if(this.reservedSeatsNumber < this.maxSeatsNumber){
            return true;
        }
        else{
            return false;
        }

    }

    private void addNewSeatToList(Seat seat) {

        seats.add(seat);

    }

    public void setReservedSeatsNumber(int reservedSeatsNumber) {
        this.reservedSeatsNumber = reservedSeatsNumber;
    }
}
