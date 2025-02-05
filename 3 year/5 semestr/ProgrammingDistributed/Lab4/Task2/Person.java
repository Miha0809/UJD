package Task2;

import java.util.Random;

public class Person implements Runnable {
    private final int personId;
    private final Building building;

    public Person(int personId, Building building) {
        this.personId = personId;
        this.building = building;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(4000) + 1000);
                System.out.println("Person " + personId + " is waiting for an elevator.");
                
                Elevator elevator = building.getAvailableElevator();
                if (elevator != null) {
                    elevator.enterElevator();
                    int targetFloor = building.getRandomFloor();
                    System.out.println("Person " + personId + " is traveling to floor " + targetFloor);
                    Thread.sleep(new Random().nextInt(3000) + 1000);
                    elevator.exitElevator();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
