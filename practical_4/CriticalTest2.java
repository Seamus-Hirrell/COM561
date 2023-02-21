package practical_4;

import java.util.concurrent.Semaphore;

class CriticalTest2 {
  public static void main(String[] args) {
    Semaphore mutex = new Semaphore(1);

    P3 p3 = new P3(mutex);
    P4 p4 = new P4(mutex);

    p3.start();
    p4.start();

    System.out.println("Threads P3 and P4 have been commanded to start");
  }
}

class P3 extends Thread {
  private Semaphore pmutex;

  public P3(Semaphore mutex) {
    pmutex = mutex;
  }

  public void run() {
    int round;
    for (round = 0; round < 3; round++) {
      System.out.println("P3 waiting to enter CS, round:" + round);

      try {
        pmutex.acquire();
      } catch (InterruptedException ie) {
        System.out.println("P3-Interrupted waiting to enter");
      }

      System.out.println("P3 is in CS, round:" + round);

      CDS.idleQuietly(1000);

      pmutex.release();
      System.out.println("P3 is out of CS, round:" + round);

      CDS.idleQuietly(500);
    }

    System.out.println("P3 finished");
  }
}

class P4 extends Thread {
  private Semaphore pmutex;

  public P4(Semaphore mutex) {
    pmutex = mutex;
  }

  public void run() {
    int round;
    for (round = 0; round < 3; round++) {
      System.out.println("P4 waiting to enter CS, round:" + round);

      try {
        pmutex.acquire();
      } catch (InterruptedException ie) {
        System.out.println("P4-Interrupted waiting to enter");
      }

      System.out.println("P4 is in CS, round:" + round);
      CDS.idleQuietly(1000);

      pmutex.release();

      System.out.println("P4 is out of CS, round:" + round);
      CDS.idleQuietly(500);
    }
    System.out.println("P4 finished");
  }
}