package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LiftTest {
    Lift lift = new Lift(0, "UP");

    @Test
    void shouldAbleToInitializeLift() {


        Assertions.assertEquals(0, lift.getCurrentFloor());
        Assertions.assertEquals("UP", lift.getDirection());

    }

    @Test
    void shouldAbleToMakeRequestToLift() {
        List<Integer> result = lift.makeRequestToLift(2);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void shouldAbleToEnterToLiftAndMakeACall() {
        List<Integer> result = lift.makeRequestToLift(2);
        Assertions.assertEquals(1, result.size());
        List<Integer> destinationList = lift.enterToLift(6);
        Assertions.assertEquals(1, destinationList.size());
//        assertEquals(0, lift.getWaitingList().size());
    }

    @Test
    void shouldAbleToDropPassengerToHisDestination() throws InterruptedException {
        lift.makeRequestToLift(3);

        lift.enterToLift(5);
        lift.moveLift();
        Assertions.assertEquals(5, lift.getCurrentFloor());
    }

    @Test
    void shouldHandleMultipleLifts() throws InterruptedException {
        Lift lift1 = new Lift(0, "UP");
        Lift lift2 = new Lift(5, "Down");
        lift1.makeRequestToLift(3);
        lift2.makeRequestToLift(2);
        Assertions.assertEquals(1, lift1.getWaitingList().size());
        Assertions.assertEquals(1, lift2.getWaitingList().size());
        lift1.moveLift();
        Assertions.assertEquals(0, lift1.getWaitingList().size());
        Assertions.assertEquals(1, lift2.getWaitingList().size());
    }


}