package org.example;

public class Bus {

    private int totalTicketAmount;
    private final int seatCapacity;
    private int numberOfEmptySeats;

    public int getNumberOfEmptySeats() {
        return numberOfEmptySeats;
    }

    public int getTotalTicketAmount() {
        return totalTicketAmount;
    }

    public Bus(int seatCapacity) {
        this.seatCapacity = seatCapacity;
        numberOfEmptySeats = seatCapacity;
        totalTicketAmount = 0;
    }

    public Passenger boardPassenger(Passenger passenger) throws Exception {
        if (numberOfEmptySeats == 0) {
            throw new BusFullException("No seat available");
        }
        numberOfEmptySeats -= 1;
        totalTicketAmount += passenger.getPassengerTicketAmount();
        return passenger;
    }
}