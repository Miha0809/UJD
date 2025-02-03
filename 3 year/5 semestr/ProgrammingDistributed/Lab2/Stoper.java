public class Stoper implements Runnable {
  private int id;
  private long seconds = 0;
  private boolean isRuning = false;
  private boolean isStop = false;

  public Stoper(int id) {
    this.id = id;
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

  public synchronized void reset() {
    isRuning = false;
    isStop = false;
    seconds = 0;
    notify();
  }

  @Override
  public void run() {
    while (isRuning) {
      synchronized (this) {
        try {
          if (isStop) {
            wait();
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          break;
        }
      }

      try {
        Thread.sleep(1000);
        synchronized (this) {
          seconds += 1;
        }

        System.out.println(id + " remaining: " + seconds + " seconds");
      } catch (Exception e) {
        Thread.currentThread().interrupt();
        break;
      }
    }

    if (seconds <= 0) {
      System.out.println("Timer " + id + " is stoped");
    }

    isRuning = false;
  }

  public synchronized long getTime() {
    return this.seconds;
  }
}
