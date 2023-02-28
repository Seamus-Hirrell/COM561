package practical_5;

import java.util.concurrent.Semaphore;

class Producer extends Thread {
  private Semaphore pempty;
  private Semaphore pfull;
  private ThePillarBox pillarBox;

  public Producer(Semaphore empty, Semaphore full, ThePillarBox pbox) {
    pempty = empty;
    pfull = full;
    pillarBox = pbox;
  }

  public void run() {
    int round;
    for (round = 0; round < 10; round++) {
      System.out.println("Producer trying to send, round:" + round);

      try {
        pempty.acquire();
      } catch (InterruptedException ie) {
        System.out.println("Producer Interrupted");
      }

      pillarBox.putValue(round);
      CDS.idleQuietly(100);

      pfull.release();

      System.out.println("Producer has put, round:" + round);
      CDS.idleQuietly(50);
    }

    System.out.println("Producer finished");
  }
}
