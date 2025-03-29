package Task2;
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            try {
                String suma = "";

                while (true) {
                    Thread.sleep(3000);
                    Integer number = buffer.consume();
                    suma += number;

                    if (number == 0) {
                        System.out.println("Suma: " + suma);
                        suma = "";
                        continue;
                    }
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
