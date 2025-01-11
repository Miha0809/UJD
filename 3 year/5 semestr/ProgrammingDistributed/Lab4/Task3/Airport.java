package Task3;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Airport {
    private final int runways;
    private int occupiedRunways = 0;
    private final PriorityBlockingQueue<PlaneRequest> runwayQueue = new PriorityBlockingQueue<>(10, Comparator.comparingInt(PlaneRequest::getPriority));

    public Airport(int runways) {
        this.runways = runways;
    }

    public synchronized boolean requestRunway(PlaneRequest request) throws InterruptedException {
        runwayQueue.put(request);
        while (!runwayQueue.peek().equals(request) || occupiedRunways >= runways) {
            wait();
        }
        runwayQueue.poll();
        occupiedRunways++;
        return true;
    }

    public synchronized void releaseRunway() {
        occupiedRunways--;
        notifyAll();
    }
}
