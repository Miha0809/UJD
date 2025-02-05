package Task1;

public class Producer implements Runnable {
    private Buffer buffer;
    private int end;

    public Producer(Buffer buffer, int end) {
        this.buffer = buffer;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            for (int i = 2; i <= end; i++) {
                buffer.produce(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
