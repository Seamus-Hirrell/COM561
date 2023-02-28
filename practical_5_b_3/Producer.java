package practical_5_b_3;

public class Producer extends Thread {
  private BoundedBuffer bBuffer;

  public Producer(BoundedBuffer bb) {
    bBuffer = bb;
  }

  public void run() {
    for (int i = 0; i < 20; i++) {
      try {
        sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
      }

      try {
        bBuffer.put(i);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }

      System.out.println("Producer put: " + i);
    }
  }
}
