public class Watch {
  public void display() {
    try {
      long minutes = 0;
      while (true) {
        minutes++;
        Thread.sleep(1000);
        System.out.println(minutes);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
