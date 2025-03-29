package Task1;

public class FerryRunnable implements Runnable {
    private final Ferry ferry;

    public FerryRunnable(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ferry.startLoading();
                Thread.sleep(ferry.getWaitingTime());
                ferry.stopLoading();
                ferry.crossRiver();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}