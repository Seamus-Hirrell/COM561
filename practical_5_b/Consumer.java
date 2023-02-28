package practical_5_b;

public class Consumer extends Thread {
  private CubbyHole cubbyhole;

  public Consumer(CubbyHole c) {
    cubbyhole = c;
  }

  public void run() {
    int value = 0;
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
      }

      value = cubbyhole.get();
      System.out.println("Consumer got: " + value);
    }
  }
}
