package practical_5_b;

public class Producer extends Thread {
  private CubbyHole cubbyhole;

  public Producer(CubbyHole c) {
    cubbyhole = c;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      cubbyhole.put(i);
      System.out.println("Producer put: " + i);

      try {
        Thread.sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
      }
    }
  }
}
