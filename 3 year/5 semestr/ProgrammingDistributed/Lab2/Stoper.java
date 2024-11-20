public class Stoper implements Runnable {
  private long seconds = 0;
  boolean isRuning = false;
  boolean isStop = false;

  public Stoper(long seconds) {
    this.seconds = seconds;
  }

  public synchronized void start() {
    if (!isRuning) {
      isRuning = true;
      new Thread(this).start();
    }
  }

  public synchronized void pause() {
    if (isRuning && !isStop) {
      isStop = true;
    }
  }

  public synchronized void resume() {
    if (isRuning && isStop) {
      isStop = false;
      notify();
    }
  }

  public synchronized void stop() {
    isRuning = false;
    notify();
  }

  @Override
  public void run() {
    while (isRuning && seconds > 0) {
      try {
        synchronized (this) {
          if (isStop) {
            wait();
          }
        }

        Thread.sleep(1000);
        seconds -= 1;
        System.out.println("remaining: " + seconds + " seconds");
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }

    if (seconds <= 0) {
      System.out.println("Timer is stoped");
    }

    isRuning = false;
  }
}
