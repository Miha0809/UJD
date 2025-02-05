package Task1;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = buffer.consume();

                if (isPrime(number)) {
                    System.out.println("Liczba pierwsza: " + number);
                } else {
                    System.out.println("Liczba nie jest pierwsza: " + number);
                }

                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
