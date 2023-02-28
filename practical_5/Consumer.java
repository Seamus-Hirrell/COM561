package practical_5;

import java.util.concurrent.Semaphore;

class Consumer extends Thread {
  private Semaphore pempty;
  private Semaphore pfull;
  private ThePillarBox pillarBox;

  public Consumer(Semaphore empty, Semaphore full, ThePillarBox pbox) {
    pempty = empty;
    pfull = full;
    pillarBox = pbox;
  }

  public void run() {
    int round;
    int x;
    for (round = 0; round < 10; round++) {
      System.out.println("Consumer trying to get, round:" + round);

      try {
        pfull.acquire();
      } catch (InterruptedException ie) {
        System.out.println("Consumer Interrupted");
      }

      x = pillarBox.getValue();
      CDS.idleQuietly(200);

      pempty.release();

      System.out.println("Consumer got, round:" + round + ", " + x);
      CDS.idleQuietly(200);
    }
    System.out.println("Consumer finished");
  }
}
