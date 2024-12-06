public class Main {
  public static void main(String[] args) {
    int start = 2;
    int end = 50;

    Buffer buffer = new Buffer();
    Thread producent = new Thread(new Producer(buffer, start, end));
    Thread consumer = new Thread(new Consumer(buffer));

    producent.start();
    consumer.start();
  }
}
