package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BusTest {

    @Test
    void shouldCreateBusWithAllEmptySeats() {
        Bus myBus = new Bus(24);
        assertEquals(24, myBus.getNumberOfEmptySeats());
        assertEquals(0, myBus.getTotalTicketAmount());
    }

    @Test
    void shouldBoardPersonWithNameAndIdAndTicketAmountAndSeatNumber() throws Exception {
        Passenger passenger1 = new Passenger("Sachin", "Tendulkar", "01", "ST01", 100);
        Bus myBus = new Bus(24);
        myBus.boardPassenger(passenger1);
        assertEquals(23, myBus.getNumberOfEmptySeats());
        assertEquals(100, myBus.getTotalTicketAmount());
    }

    @Test
    void shouldReturnTotalTicketAmount() throws Exception {
        Passenger passenger1 = new Passenger("Sachin", "Tendulkar", "01", "ST01", 100);
        Passenger passenger2 = new Passenger("Virat", "Kohli", "02", "VK02", 70);
        Passenger passenger3 = new Passenger("Rohit", "Sharma", "03", "RS03", 130);
        Bus myBus = new Bus(24);
        myBus.boardPassenger(passenger1);
        myBus.boardPassenger(passenger2);
        myBus.boardPassenger(passenger3);
        assertEquals(21, myBus.getNumberOfEmptySeats());
        assertEquals(300, myBus.getTotalTicketAmount());
    }

    @Test
    void shouldThrowExceptionWhenNumberOfPassengerMoreThanCapacity() throws Exception {
        Passenger passenger1 = new Passenger("Sachin", "Tendulkar", "01", "ST01", 100);
        Passenger passenger2 = new Passenger("Virat", "Kohli", "02", "VK02", 70);
        Passenger passenger3 = new Passenger("Rohit", "Sharma", "03", "RS03", 130);
        Bus myBus = new Bus(2);
        myBus.boardPassenger(passenger1);
        myBus.boardPassenger(passenger2);

        assertEquals(0, myBus.getNumberOfEmptySeats());
        assertEquals(170, myBus.getTotalTicketAmount());
        Exception exception = assertThrows(BusFullException.class, () -> myBus.boardPassenger(passenger3));
        assertEquals("No seat available", exception.getMessage());
    }

    @Test
    void shouldReturnPassengerInfoInOrderTheyWereAdded() throws Exception {
        Passenger passenger1 = new Passenger("Sachin", "Tendulkar", "01", "ST01", 100);
        Passenger passenger2 = new Passenger("Virat", "Kohli", "02", "VK02", 70);
        Passenger passenger3 = new Passenger("Rohit", "Sharma", "03", "RS03", 130);
        Bus myBus = new Bus(24);
        List<Passenger> boardPassangerList = new ArrayList<>();
        Passenger passengerList1 = myBus.boardPassenger(passenger1);
        boardPassangerList.add(passengerList1);
        Passenger passengerList2 = myBus.boardPassenger(passenger2);
        boardPassangerList.add(passengerList2);
        Passenger passengeList3 = myBus.boardPassenger(passenger3);
        boardPassangerList.add(passengeList3);
        Object data[] = boardPassangerList.toArray();
        assertEquals(data[0], passenger1);
        assertEquals(data[1], passenger2);
        assertEquals(data[2], passenger3);
        for (Passenger passenger : boardPassangerList) {
            System.out.println(passenger.getPassengerName() + " " + passenger.getPassengerLastName() + " is seated on " + passenger.getPassengerSeatNumber() + " and his id is " + passenger.getPassengerId() + ".");
        }
    }
}