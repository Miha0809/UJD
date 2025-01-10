package Task1;

import java.util.LinkedList;
import java.util.Queue;

public class Ferry {
    private final int capacity = 3;
    private final int waitingTime = 5000;
    private int loadedCars = 0;
    private boolean loading = false;
    private boolean atLeftBank = true;
    private Queue<Car> carsOnFerry = new LinkedList<>();

    public synchronized void load(Car car) throws InterruptedException {
        while (!loading || loadedCars >= capacity || car.isOnBoard() || car.isAtLeftBank() != atLeftBank) {
            wait();
        }

        carsOnFerry.add(car);
        loadedCars++;
        car.setOnBoard(true);
        System.out.println("Car: " + car.getName() + " has boarded the ferry.");
        notifyAll();
    }

    public synchronized void unload() throws InterruptedException {
        while (loadedCars == 0) {
            wait();
        }

        while (!carsOnFerry.isEmpty()) {
            Car car = carsOnFerry.poll();
            loadedCars--;
            car.setOnBoard(false);
            car.toggleBank();
            System.out.println("Car: " + car.getName() + " has left the ferry.");
        }

        notifyAll();
    }

    public synchronized void startLoading() {
        loading = true;
        System.out.println("Ferry at the " + (atLeftBank ? "left" : "right") + " bank starts loading.");
        notifyAll();
    }

    public synchronized void stopLoading() {
        loading = false;
        System.out.println("Ferry has stopped loading.");
    }

    public synchronized void crossRiver() throws InterruptedException {
        System.out.println("Ferry is crossing the river...");
        Thread.sleep(3000);
        atLeftBank = !atLeftBank;
        System.out.println("Ferry has arrived at the " + (atLeftBank ? "left" : "right") + " bank.");
        notifyAll();
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public boolean isAtLeftBank() {
        return atLeftBank;
    }
}