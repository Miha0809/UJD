package Task3;

public class Calculator implements Runnable {
    private Buffer buffer;
    private int maxReads;

    public Calculator(Buffer buffer, int maxReads) {
        this.buffer = buffer;
        this.maxReads = maxReads;
    }

    @Override
    public void run() {
        try {
            double sumA = 0;
            double productB = 1;
            int count = 0;

            while (count < maxReads) {
                double[] values = buffer.getValues();
                double a = values[0];
                double b = values[1];

                sumA += a;
                productB *= (b == 0 ? 1 : b);
                count++;

                if (Math.abs(productB) < 1e-8 || count == maxReads) {
                    break;
                }

                double result = sumA / productB;
                System.out.println("Current value: " + result);

                Thread.sleep(1000);
            }

            double finalResult = sumA / productB;
            System.out.println("Final value: " + finalResult);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
