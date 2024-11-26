public class Blinking {
  private String color;
  private long timeout;
  private boolean isPause;
  private boolean isRunning;

  private Thread blinkingThread;

  public Blinking(String color, long timeout) {
    this.color = color;
    this.timeout = timeout;
    this.isPause = false;
    this.isRunning = false;
  }

  public void start() throws InterruptedException {
    if (isRunning) {
      System.out.println("Bliking is running");
      return;
    }

    isRunning = true;

    blinkingThread =
        new Thread(
            () -> {
              try {
                while (isRunning) {
                  if (!isPause) {
                    System.out.println("Bliking color: " + color);
                    Thread.sleep(timeout);
                    System.out.println("Bliking is hide");
                    Thread.sleep(timeout);
                  } else {
                    Thread.sleep(100);
                  }
                }
              } catch (Exception e) {
                Thread.currentThread().interrupt();
              }
            });

    blinkingThread.start();
  }

  public synchronized void pause() {
    if (isRunning && !isPause) {
      isPause = true;
    }
  }

  public void stop() throws InterruptedException {
    isRunning = false;
    if (blinkingThread != null) {
      blinkingThread.interrupt();
      System.out.println("bliking is stop");
    }
  }

  public synchronized void resume() {
    if (isRunning && isPause) {
      isPause = false;
    }
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }
}
