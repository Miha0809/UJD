public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    private boolean isPrime(Integer number) {
        if (number < 2) {
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

                if (isPrime(number))
                {
                    System.out.println("Liczbs jest pierwszą: " + number);
                } else {
                    System.out.println("Liczba nie jest pierwszą: " + number);
                }

                Thread.sleep(3000);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
