package com.example.ferenc.railjet_reservation_app.test;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeatTest {
    @Test
    void checkIfSeatFreeTest(){

        Seat testSeat = new Seat(3, 5, "Győr", "Hegyeshalom",1);
        Seat testSeat2 = new Seat(4, 10, "Mosonmagyaróvár","Salzburg",1);

        testSeat.checkIfSeatFree(testSeat2.getStartStationId(), testSeat2.getEndStationId());

        assertFalse(testSeat.isReserved());

    }

    @Test
    void checkIfSeatFreeTest2(){
        Seat testSeat = new Seat(3, 5, "Győr", "Hegyeshalom",1);
        Seat testSeat2 = new Seat(6, 10, "Wien", "Salzburg",1);

        testSeat.checkIfSeatFree(testSeat2.getStartStationId(), testSeat2.getEndStationId());

        assertFalse(testSeat.isReserved());
    }
    @Test
    void checkIfSeatFreeTest3(){

        Seat testSeat = new Seat(0, 3, "Budapest-Keleti","Győr",1);
        Seat testSeat2 = new Seat(6, 10, "Wien","Salzburg",1);

        testSeat.checkIfSeatFree(testSeat2.getStartStationId(), testSeat2.getEndStationId());
        assertFalse(testSeat.isReserved());

    }
    @Test
    void checkIfSeatFreeTest4(){

        Seat testSeat = new Seat(6, 10, "Wien","Salzburg",1);
        Seat testSeat2 = new Seat(0, 3, "Budapest-Keleti","Győr",1);

        testSeat.checkIfSeatFree(testSeat2.getStartStationId(), testSeat2.getEndStationId());
        assertFalse(testSeat.isReserved());
    }

}