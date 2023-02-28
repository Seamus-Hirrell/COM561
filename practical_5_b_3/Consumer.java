package practical_5_b_3;

public class Consumer extends Thread {
  private BoundedBuffer bBuffer;

  public Consumer(BoundedBuffer bb) {
    bBuffer = bb;
  }

  public void run() {
    int value = 0;
    for (int i = 0; i < 20; i++) {
      try {
        sleep((int) (Math.random() * 1000));
      } catch (InterruptedException e) {
      }

      try {
        value = bBuffer.get();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("Consumer got: " + value);
    }
  }
}
