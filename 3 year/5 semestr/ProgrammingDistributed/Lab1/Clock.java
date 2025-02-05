public class Clock {
  private int hours = 0;
  private int minutes = 0;
  private int seconds = 0;
  private String period;
  private boolean isFormat24h = true;

  public Clock() {}

  public void setTime(int hours, int minutes, int seconds) {
    this.hours = hours % 24;
    this.minutes = minutes % 60;
    this.seconds = seconds % 60;
  }

  public void display() {
    if (isFormat24h) {
      System.out.println(hours + ":" + minutes + ":" + seconds);
    } else if (!isFormat24h) {
      period = hours < 12 ? "AM" : "PM";
      System.out.println((hours % 12) + ":" + minutes + ":" + seconds + " " + period);
    }
  }

  public void format(boolean isFormat24h) {
    this.isFormat24h = isFormat24h;
  }

  public void tick() {
    seconds++;

    if (seconds >= 60) {
      seconds -= 60;
      minutes++;

      if (minutes >= 60) {
        minutes -= 60;
        hours++;
      }
    }
  }

  public void start5sec() {
    try {
      long count = 0;
      while (count != 5) {
        count++;
        tick();
        Thread.sleep(1000);
        display();
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
