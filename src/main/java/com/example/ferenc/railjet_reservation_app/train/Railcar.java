package com.example.ferenc.railjet_reservation_app.train;

import java.util.ArrayList;
import java.util.List;

public class Railcar {

    private Integer id;
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

    public Railcar(Integer id, String carNumber, String type, ClassType classType, int maxSeatsNumber, int reservedSeatsNumber) {
        this.id = id;
        this.carNumber = carNumber;
        this.type = type;
        this.classType = classType;
        this.maxSeatsNumber = maxSeatsNumber;
        this.reservedSeatsNumber = reservedSeatsNumber;
        this.seats = new ArrayList<Seat>();
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        if(this.id == null){
            this.id = id;
        }
        else{
            throw new IllegalStateException("Hiba! A kocsi ID csak egyszer kaphat értéket! / Fehler! Die Wagen ID darf nur einmal eingestellt werden");
        }


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

        if(seat.getNumberOfPersons() > this.maxSeatsNumber || this.reservedSeatsNumber >= this.maxSeatsNumber) {
            CheckSeatReservation(seat);
        }else if(this.reservedSeatsNumber <= this.maxSeatsNumber){
            this.reservedSeatsNumber += seat.getNumberOfPersons();
            addNewSeatToList(seat);
        }

    }
    public void CheckSeatReservation(Seat seat) {

        for (Seat item : this.seats) {
            item.checkIfSeatFree(seat.getStartStation(), seat.getEndStation());
        }
        long reservedSeats = this.seats.stream().filter(s -> s.isReserved()).count();

         if(reservedSeats < this.maxSeatsNumber && seat.getNumberOfPersons() <= (this.maxSeatsNumber-reservedSeats)){

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

    public int getFreeSeatsNumber(){
        long reservedSeats = this.seats.stream().filter(s -> s.isReserved()).count();
        int freeSeatsNumber = (int) (this.maxSeatsNumber-reservedSeats);
        return freeSeatsNumber;
    }
}
