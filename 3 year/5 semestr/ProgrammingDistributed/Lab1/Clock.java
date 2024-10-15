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

  public String display() {
    String result = "";

    if (isFormat24h) {
      result = hours + ":" + minutes + ":" + seconds;
    } else if (!isFormat24h) {
      period = hours < 12 ? "AM" : "PM";
      result = (hours % 12) + ":" + minutes + ":" + seconds + " " + period;
    }

    return result;
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
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
