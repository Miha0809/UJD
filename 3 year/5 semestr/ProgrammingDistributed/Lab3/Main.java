// import Task1.*;
// import Task2.*;
// import Task3.*;
import Task4.*;

public class Main {
  public static void main(String[] args) {
    // Task 1
    // final int lengthBuffer = 10;
    // final int lengthProducer = 50;
    
    // Buffer buffer = new Buffer(lengthBuffer);
    // Thread producent = new Thread(new Producer(buffer, lengthProducer));
    // Thread consumer = new Thread(new Consumer(buffer));
    // Thread consumer2 = new Thread(new Consumer(buffer));

    // producent.start();
    // consumer.start();
    // consumer2.start();

    // Task 2
    // final int lengthBuffer = 10;
    // final int lengthProducer = 50;
    
    // Buffer buffer = new Buffer(lengthBuffer);
    // Thread producent = new Thread(new Producer(buffer, lengthProducer));
    // Thread consumer = new Thread(new Consumer(buffer));

    // producent.start();
    // consumer.start();

    // Task 3
    // int maxReads = 10;
    // Buffer buffer = new Buffer();

    // Thread sensorA = new Thread(new Sensor(buffer, true, maxReads));
    // Thread sensorB = new Thread(new Sensor(buffer, false, maxReads));
    // Thread calculator = new Thread(new Calculator(buffer, maxReads));

    // sensorA.start();
    // sensorB.start();
    // calculator.start();

    // Task4
    Buffer buffer = new Buffer();

    Thread diceRollerThread = new Thread(new DiceRoller(buffer));
    Thread pawnMoverThread = new Thread(new PawnMover(buffer));

    diceRollerThread.start();
    pawnMoverThread.start();
  }
}