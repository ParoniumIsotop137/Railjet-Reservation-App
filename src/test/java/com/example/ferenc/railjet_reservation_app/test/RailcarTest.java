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

        Railcar testCar = new Railcar("Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(RJX162Stations.GYOR, RJX162Stations.HEGYESHALOM);

        Seat testSeat2 = new Seat(RJX162Stations.MOSONMAGYAROVAR, RJX162Stations.SALZBURG);

        Seat testSeat3 = new Seat(RJX162Stations.GYOR, RJX162Stations.SALZBURG);

        Seat testSeat4 = new Seat(RJX162Stations.SALZBURG, RJX162Stations.LANDECK);

        testCar.setFreeSeatNumberAndSeat(testSeat);
        testCar.setFreeSeatNumberAndSeat(testSeat2);
        testCar.setFreeSeatNumberAndSeat(testSeat3);



        assertDoesNotThrow(() -> testCar.setFreeSeatNumberAndSeat(testSeat4));

    }
    @Test
    void setFreeSeatNumberAndSeatTest2(){

        Railcar testCar = new Railcar("Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.HEGYESHALOM);

        Seat testSeat2 = new Seat(RJX162Stations.MOSONMAGYAROVAR, RJX162Stations.SALZBURG);

        Seat testSeat3 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.GYOR);

        Seat testSeat4 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.ZURICH);

        testCar.setFreeSeatNumberAndSeat(testSeat);
        testCar.setFreeSeatNumberAndSeat(testSeat2);
        testCar.setFreeSeatNumberAndSeat(testSeat3);

        assertThrows(IllegalArgumentException.class, () -> testCar.setFreeSeatNumberAndSeat(testSeat4));



    }
    @Test
    void setFreeSeatNumberAndSeatTest3(){

        Railcar testCar = new Railcar("Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.HEGYESHALOM);

        Seat testSeat2 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.SALZBURG);

        Seat testSeat3 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.GYOR);

        Seat testSeat4 = new Seat(RJX162Stations.TATABANYA, RJX162Stations.GYOR);

        testCar.setFreeSeatNumberAndSeat(testSeat);
        testCar.setFreeSeatNumberAndSeat(testSeat2);
        testCar.setFreeSeatNumberAndSeat(testSeat3);

        assertThrows(IllegalArgumentException.class, () -> testCar.setFreeSeatNumberAndSeat(testSeat4));


    }
    @Test
    void setFreeSeatNumberAndSeatTest4(){

        Railcar testCar = new Railcar("Afpmz First Class", ClassType.PREMIUM, 3);

        Seat testSeat = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.HEGYESHALOM);

        Seat testSeat2 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.SALZBURG);

        Seat testSeat3 = new Seat(RJX162Stations.BUDAPESTKELETI, RJX162Stations.SALZBURG);

        Seat testSeat4 = new Seat(RJX162Stations.WIENHBF, RJX162Stations.ZURICH);

        testCar.setFreeSeatNumberAndSeat(testSeat);
        testCar.setFreeSeatNumberAndSeat(testSeat2);
        testCar.setFreeSeatNumberAndSeat(testSeat3);

        assertDoesNotThrow(() -> testCar.setFreeSeatNumberAndSeat(testSeat4));
    }

}