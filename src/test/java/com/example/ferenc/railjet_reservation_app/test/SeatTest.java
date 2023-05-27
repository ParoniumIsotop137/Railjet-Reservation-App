package com.example.ferenc.railjet_reservation_app.test;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeatTest {
    @Test
    void checkIfSeatFreeTest(){

        Seat testSeat = new Seat(RJX162Stations.GYOR, RJX162Stations.HEGYESHALOM, 1);
        Seat testSeat2 = new Seat(RJX162Stations.MOSONMAGYAROVAR, RJX162Stations.SALZBURG, 1);

        testSeat.checkIfSeatFree(testSeat2.getStartStation(), testSeat2.getEndStation());

        assertFalse(testSeat.isReserved());

    }

    @Test
    void checkIfSeatFreeTest2(){
        Seat testSeat = new Seat(RJX162Stations.GYOR, RJX162Stations.HEGYESHALOM, 1);
        Seat testSeat2 = new Seat(RJX162Stations.WIENHBF, RJX162Stations.SALZBURG, 1);

        testSeat.checkIfSeatFree(testSeat2.getStartStation(), testSeat2.getEndStation());

        assertFalse(testSeat.isReserved());
    }
    @Test
    void checkIfSeatFreeTest3(){

        Seat testSeat = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.GYOR, 1);
        Seat testSeat2 = new Seat(RJX162Stations.WIENHBF, RJX162Stations.SALZBURG, 1);

        testSeat.checkIfSeatFree(testSeat2.getStartStation(), testSeat2.getEndStation());
        assertFalse(testSeat.isReserved());

    }
    @Test
    void checkIfSeatFreeTest4(){

        Seat testSeat = new Seat(RJX162Stations.WIENHBF, RJX162Stations.SALZBURG, 1);
        Seat testSeat2 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.GYOR, 1);

        testSeat.checkIfSeatFree(testSeat2.getStartStation(), testSeat2.getEndStation());
        assertFalse(testSeat.isReserved());
    }

}