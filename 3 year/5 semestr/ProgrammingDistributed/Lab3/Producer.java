public class Producer implements Runnable{
    private Buffer buffer;
    private int start, end;

    public Producer(Buffer buffer, int start, int end) {
        this.buffer = buffer;
        this.start = start;
        this.end = end;
    }

    public void run() {
        try {
            for (int i = start; i < end; i++) {
                buffer.produce(i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
