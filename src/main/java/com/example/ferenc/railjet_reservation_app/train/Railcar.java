package com.example.ferenc.railjet_reservation_app.train;

import java.util.ArrayList;
import java.util.List;

public class Railcar {

    private String carNumber;
    private String type;
    private ClassType classType;
    private int maxSeatsNumber;

    private int reservedSeatsNumber;

    private List<Seat> seats;


    public Railcar(String carNumber,String type, ClassType classType, int maxSeatNumber) {
        this.type = type;
        this.classType = classType;
        this.maxSeatsNumber = maxSeatNumber;
        this.reservedSeatsNumber = 0;
        this.seats = new ArrayList<Seat>();
        this.carNumber = carNumber;
    }

    public String getType() {
        return type;
    }

    public String getCarNumber() {
        return carNumber;
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

    public void setReservedSeatNumberAndSeat(Seat seat) {

        if(seat.getNumberOfPersons() > this.maxSeatsNumber){
            throw new IllegalArgumentException("A kiválasztott kocsiban nincsen elegendő szabad hely! / In diesem Wagen sind nicht genug Plätze verfügbar für so viele Personen!");
        }
        else{
            this.reservedSeatsNumber += seat.getNumberOfPersons();
        }

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
             throw new IllegalArgumentException("A kiválasztott kocsiban már nincsen szabad hely! / Es sind keine freie Plätze mehr in dem ausgewählten Wagen!");
         }

    }

    public void addNewSeatToList(Seat seat) {

        this.seats.add(seat);

    }

    public void setReservedSeatsNumber(int reservedSeatsNumber) {
        this.reservedSeatsNumber = reservedSeatsNumber;
    }
}
