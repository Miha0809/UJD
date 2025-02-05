package Task1;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Integer> list = new ArrayList();
    private final int LENGTH;

    public Buffer(int length) {
        this.LENGTH = length;
    }

    public synchronized void produce(Integer number) throws InterruptedException {
        while (list.size() >= LENGTH) {
            System.out.println("Bufor jet pełny, producent czeka ...");
            wait();
        }

        list.add(number);
        System.out.println("Dodano: " + number);
        notifyAll();
    }

    public synchronized Integer consume() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("Bufor jest pusty, koncument czeka ...");
            wait();
        }

        Integer number = list.remove(0);
        notifyAll();
        return number;
    }
}
