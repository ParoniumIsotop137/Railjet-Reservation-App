package com.example.ferenc.railjet_reservation_app.test;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;
import com.example.ferenc.railjet_reservation_app.train.ClassType;
import com.example.ferenc.railjet_reservation_app.train.Railcar;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RailcarTest {

    @Test
    void setFreeSeatNumberAndSeatTest(){

        Railcar testCar = new Railcar("","Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(3, 5, "Győr", "Hegyeshalom", 1);

        Seat testSeat2 = new Seat(4, 10,"Mosonmagyaróvár", "Salzburg", 1);

        Seat testSeat3 = new Seat(3, 10, "Győr","Salzburg", 1);

        Seat testSeat4 = new Seat(10, 15, "Salzburg", "Landeck-Zams", 1);

        testCar.setReservedSeatNumberAndSeat(testSeat);
        testCar.setReservedSeatNumberAndSeat(testSeat2);
        testCar.setReservedSeatNumberAndSeat(testSeat3);



        assertDoesNotThrow(() -> testCar.setReservedSeatNumberAndSeat(testSeat4));

    }
    @Test
    void setFreeSeatNumberAndSeatTest2(){

        Railcar testCar = new Railcar("","Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(0, 5, "Budapest-Keleti", "Hegyeshalom",1);

        Seat testSeat2 = new Seat(4, 10, "Mosonmagyaróvár", "Salzburg",1);

        Seat testSeat3 = new Seat(0, 3, "Budapest-Keleti","Győr",1);

        Seat testSeat4 = new Seat(0, 21, "Budapest-Keleti","Zürich",1);

        testCar.setReservedSeatNumberAndSeat(testSeat);
        testCar.setReservedSeatNumberAndSeat(testSeat2);
        testCar.setReservedSeatNumberAndSeat(testSeat3);

        assertThrows(IllegalArgumentException.class, () -> testCar.setReservedSeatNumberAndSeat(testSeat4));



    }
    @Test
    void setFreeSeatNumberAndSeatTest3(){

        Railcar testCar = new Railcar("","Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(0, 5, "Budapest-Keleti", "Hegyeshalom",1);

        Seat testSeat2 = new Seat(0, 10, "Budapest-Keleti","Salzburg",1);

        Seat testSeat3 = new Seat(0, 3, "Budapest-Keleti","Győr",1);

        Seat testSeat4 = new Seat(2, 3, "Tatabánya","Győr",1);

        testCar.setReservedSeatNumberAndSeat(testSeat);
        testCar.setReservedSeatNumberAndSeat(testSeat2);
        testCar.setReservedSeatNumberAndSeat(testSeat3);

        assertThrows(IllegalArgumentException.class, () -> testCar.setReservedSeatNumberAndSeat(testSeat4));


    }
    @Test
    void setFreeSeatNumberAndSeatTest4(){

        Railcar testCar = new Railcar("","Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(0, 5, "Budapest-Keleti","Hegyeshalom",1);

        Seat testSeat2 = new Seat(0, 10, "Budapest-Keleti","Salzburg",1);

        Seat testSeat3 = new Seat(0, 10, "Budapest-Keleti","Salzburg",1);

        Seat testSeat4 = new Seat(6, 21, "Wien", "Zurich",1);

        testCar.setReservedSeatNumberAndSeat(testSeat);
        testCar.setReservedSeatNumberAndSeat(testSeat2);
        testCar.setReservedSeatNumberAndSeat(testSeat3);

        assertDoesNotThrow(() -> testCar.setReservedSeatNumberAndSeat(testSeat4));
    }

}