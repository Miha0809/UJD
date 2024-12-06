import Task2.Buffer;
import Task2.Consumer;
import Task2.Producer;

public class Main {
  public static void main(String[] args) {
    final int lengthBuffer = 10;
    final int lengthProducer = 50;
    
    Buffer buffer = new Buffer(lengthBuffer);
    Thread producent = new Thread(new Producer(buffer, lengthProducer));
    Thread consumer = new Thread(new Consumer(buffer));

    producent.start();
    consumer.start();
  }
}
