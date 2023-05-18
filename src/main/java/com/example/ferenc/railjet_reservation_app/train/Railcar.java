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


    public Railcar(String type, ClassType classType, int maxSeatNumber) {
        this.type = type;
        this.classType = classType;
        this.maxSeatsNumber = maxSeatNumber;
        this.reservedSeatsNumber = 0;
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

        if(this.reservedSeatsNumber < this.maxSeatsNumber){

            addNewSeatToList(seat);
        }
        else{
            CheckSeatReservation(seat);

        }

    }
    public void CheckSeatReservation(Seat seat) {

        for (Seat item : this.seats) {
            item.checkIfSeatFree(seat.getStartStation(), seat.getEndStation());
        }
        long reservedSeats = this.seats.stream().filter(s -> s.isReserved() == true).count();

         if(reservedSeats < this.reservedSeatsNumber){
            this.reservedSeatsNumber = (int) reservedSeats;
            addNewSeatToList(seat);
            }
         else{
             throw new IllegalArgumentException("A kiválasztott kocsiban már nincsen szabad hely!");
         }

    }

    public void addNewSeatToList(Seat seat) {

        this.seats.add(seat);

    }

    public void setReservedSeatsNumber(int reservedSeatsNumber) {
        this.reservedSeatsNumber = reservedSeatsNumber;
    }
}
