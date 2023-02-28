package practical_5_b;

public class ProducerForBB extends Thread {
  private BoundedBuffer bBuffer;

  public ProducerForBB(BoundedBuffer bb) {
    bBuffer = bb;
  }

  public void run() {
    for (int i = 0; i < 20; i++) {
      bBuffer.put(i);
      System.out.println("Producer put: " + i);

      try {
        sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
      }
    }
  }
}
