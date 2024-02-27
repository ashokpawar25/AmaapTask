package org.example;

public class Passenger {
    private String passengerName;
    private String passengerLastName;
    private String passengerSeatNumber;
    private String passengerId;
    private int passengerTicketAmount;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerSeatNumber() {
        return passengerSeatNumber;
    }

    public void setPassengerSeatNumber(String passengerSeatNumber) {
        this.passengerSeatNumber = passengerSeatNumber;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public int getPassengerTicketAmount() {
        return passengerTicketAmount;
    }

    public void setPassengerTicketAmount(int passengerTicketAmount) {
        this.passengerTicketAmount = passengerTicketAmount;
    }

    public Passenger(String passengerName, String passengerLastName, String passengerSeatNumber, String passengerId, int passengerTicketAmount) {
        this.passengerName = passengerName;
        this.passengerLastName = passengerLastName;
        this.passengerSeatNumber = passengerSeatNumber;
        this.passengerId = passengerId;
        this.passengerTicketAmount = passengerTicketAmount;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerName='" + passengerName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerSeatNumber='" + passengerSeatNumber + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", passengerTicketAmount=" + passengerTicketAmount +
                '}';
    }
}
