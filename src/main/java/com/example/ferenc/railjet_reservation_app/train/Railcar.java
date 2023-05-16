package com.example.ferenc.railjet_reservation_app.train;

public class Railcar {

    private String type;
    private ClassType classType;
    private int maxSeatNumber;
    private int freeSeatNumber;
    private int reservedSeatNumber;

    public Railcar(String type, ClassType classType, int maxSeatNumber, int freeSeatNumber, int reservedSeatNumber) {
        this.type = type;
        this.classType = classType;
        this.maxSeatNumber = maxSeatNumber;
        this.freeSeatNumber = freeSeatNumber;
        this.reservedSeatNumber = reservedSeatNumber;
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

    public void setFreeSeatNumber(int freeSeatNumber) {
        this.freeSeatNumber = freeSeatNumber;
    }

    public void setReservedSeatNumber(int reservedSeatNumber) {
        this.reservedSeatNumber = reservedSeatNumber;
    }
}
