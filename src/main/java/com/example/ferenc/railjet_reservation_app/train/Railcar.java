package com.example.ferenc.railjet_reservation_app.train;

import java.util.ArrayList;
import java.util.List;

public class Railcar {

    private String type;
    private ClassType classType;
    private int maxSeatNumber;
    private int freeSeatNumber;
    private int reservedSeatNumber;

    private List<Seat> seats;

    public Railcar(String type, ClassType classType, int maxSeatNumber, int freeSeatNumber, int reservedSeatNumber) {
        this.type = type;
        this.classType = classType;
        this.maxSeatNumber = maxSeatNumber;
        this.freeSeatNumber = freeSeatNumber;
        this.reservedSeatNumber = reservedSeatNumber;
        this.seats = new ArrayList<Seat>();
    }

    public String getType() {
        return type;
    }

    public ClassType getClassType() {
        return classType;
    }

    public int getMaxSeatNumber() {
        return maxSeatNumber;
    }

    public int getFreeSeatNumber() {
        return freeSeatNumber;
    }

    public int getReservedSeatNumber() {
        return reservedSeatNumber;
    }

    public void setFreeSeatNumberAndSeat(Seat seat) {

        if(this.freeSeatNumber <= maxSeatNumber){
            this.freeSeatNumber = (maxSeatNumber-reservedSeatNumber);
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

    private boolean CheckSeatReservation(Stations startStation) {

        for (Seat seat : seats) {
            seat.checkIfSeatFree(startStation.getName());
        }
        int newFreeSeatNumber = (int) seats.stream().filter(s -> s.isReserved() == true).count();

        if(newFreeSeatNumber > this.freeSeatNumber){
            this.freeSeatNumber = newFreeSeatNumber;
            return true;
        }
        else{
            return false;
        }

    }

    private void addNewSeatToList(Seat seat) {

        seats.add(seat);

    }

    public void setReservedSeatNumber(int reservedSeatNumber) {
        this.reservedSeatNumber = reservedSeatNumber;
    }
}
