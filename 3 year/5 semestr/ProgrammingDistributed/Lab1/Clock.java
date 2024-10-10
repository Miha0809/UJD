import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Locale;

public class Clock {
  private LocalTime localTime;
  private boolean isFormat24h;

  public Clock() {
    localTime = LocalTime.of(0, 0);
    isFormat24h = true;
  }

  public Clock(LocalTime localTime, boolean isFormat24h) {
    this.localTime = localTime;
    this.isFormat24h = isFormat24h;
  }

  public void setTime(int hours, int minutes, int seconds) {
    localTime = LocalTime.of(hours, minutes, seconds);
  }

  public void display() {
    if (isFormat24h) {
      SimpleDateFormat simpleDateFormatArrivals = new SimpleDateFormat("HH:mm", Locale.UK);
      System.out.println(simpleDateFormatArrivals.toString());
    } else {
      SimpleDateFormat simpleDateFormatArrivals = new SimpleDateFormat("hh:mm", Locale.UK);
      System.out.println(simpleDateFormatArrivals.toString());
    }
  }
}
