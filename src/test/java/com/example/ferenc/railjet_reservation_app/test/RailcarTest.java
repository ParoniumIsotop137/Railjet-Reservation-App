package com.example.ferenc.railjet_reservation_app.test;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;
import com.example.ferenc.railjet_reservation_app.train.ClassType;
import com.example.ferenc.railjet_reservation_app.train.Railcar;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RailcarTest {


    void setFreeSeatNumberAndSeatTest(){

        Railcar testCar = new Railcar("Afpmz First Class", ClassType.PREMIUM, 16, 16);

        Seat testSeat = new Seat(RJX162Stations.GYOR, RJX162Stations.HEGYESHALOM);

        

    }

}