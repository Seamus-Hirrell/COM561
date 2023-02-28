package practical_5_b;

public class ConsumerForBB extends Thread {

  private BoundedBuffer bBuffer;

  public ConsumerForBB(BoundedBuffer bb) {
    bBuffer = bb;
  }

  public void run() {
    int value = 0;
    for (int i = 0; i < 20; i++) {
      try {
        sleep((int) (Math.random() * 200));
      } catch (InterruptedException e) {
      }

      value = bBuffer.get();
      System.out.println("Consumer got: " + value);
    }
  }
}
