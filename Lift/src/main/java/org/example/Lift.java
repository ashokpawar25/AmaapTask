package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lift {

    private int currentFloor;
    private String direction;
    private List<Integer> waitingList = new ArrayList<>();
    private List<Integer> requestList = new ArrayList<>();

    public Lift(int currentFloor, String direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;

    }

    public List<Integer> getWaitingList() {
        return waitingList;
    }

    public List<Integer> getRequestList() {
        return requestList;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Integer> makeRequestToLift(int waitingFloor) {

        waitingList.add(waitingFloor);

        return waitingList;
    }


    public List<Integer> enterToLift(Integer call) {
        System.out.println("DING!!");
        System.out.println("Lift Opened at " + currentFloor + " floor");
        requestList.add(call);
        waitingList.remove(Integer.valueOf(currentFloor));
        System.out.println("person at" + currentFloor + " is entered in lift");
        System.out.println("lift is closed");
        return requestList;
    }

    public void dropPeoples() {
        System.out.println("DING!!");
        System.out.println("Lift opened at " + currentFloor + " and dropped a person");
        requestList.remove(Integer.valueOf(currentFloor));
        System.out.println("Lift closed");
    }

    void moveLift() throws InterruptedException {
        System.out.println("Lift is moving");
        do {
            if (direction.equalsIgnoreCase("Up")) {
                while (currentFloor != 10) {
                    System.out.println("Lift is at " + currentFloor + " floor");
                    currentFloor += 1;

                    if (waitingList.contains(currentFloor)) {
                        Thread.sleep(5000);
                        enterToLift(5);
                    }
                    if (requestList.contains(currentFloor)) {
                        Thread.sleep(5000);
                        dropPeoples();
                    }
                    if (waitingList.isEmpty() && requestList.isEmpty()) {
                        break;
                    }
                }
                direction = "Down";

            }
            if (direction.equalsIgnoreCase("Down")) {
                while (currentFloor != 0) {
                    System.out.println("Lift is at " + currentFloor + " floor");
                    currentFloor -= 1;
                    if (waitingList.contains(currentFloor)) {

                        enterToLift(5);
                    }
                    if (requestList.contains(currentFloor)) {
                        dropPeoples();
                    }
                    if (waitingList.isEmpty() && requestList.isEmpty()) {
                        break;
                    }
                }
                direction = "up";
            }
        } while (!waitingList.isEmpty() && !requestList.isEmpty());
    }
}