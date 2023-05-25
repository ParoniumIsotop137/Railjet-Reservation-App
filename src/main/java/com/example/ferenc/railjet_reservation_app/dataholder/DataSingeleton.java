package com.example.ferenc.railjet_reservation_app.dataholder;

import com.example.ferenc.railjet_reservation_app.train.Seat;

public class DataSingeleton {

    private static final DataSingeleton instance = new DataSingeleton();
    private Seat seat;

    private DataSingeleton(){

    }

    public static DataSingeleton getInstance(){
        return instance;
    }

    public Seat getSeat(){
        return seat;
    }

    public void setSeat(Seat newSeat){
        this.seat = newSeat;
    }

}
