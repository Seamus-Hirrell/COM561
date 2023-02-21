package practical_4;

/* CriticalTest1.java */
class CriticalTest1 {
  public static void main(String[] args) {
    Lock lock_crit = new Lock();

    P1 p1 = new P1(lock_crit);
    P2 p2 = new P2(lock_crit);

    p1.start();
    p2.start();

    System.out.println("Threads p1 and p2 commanded to start");
  }
}

class Lock {
  private boolean value;

  Lock() {
    value = false;
  }

  public synchronized boolean Tset() {
    boolean setting;
    setting = value;
    value = true;
    return setting;
  }

  public synchronized void free() {
    value = false;
  }
}

class P1 extends Thread {
  private Lock lock_id;

  public P1(Lock lock_id_in) {
    this.lock_id = lock_id_in;
  }

  public void run() {
    boolean cc;
    int round;
    for (round = 0; round < 3; round++) {
      System.out.println("P1 entering CS, round:" + round);

      do {
        cc = this.lock_id.Tset();

        try {
          sleep(200);
        } catch (InterruptedException e) {
        }

        if (cc) {
          System.out.println("P1 still trying");
        }
      } while (cc);

      System.out.println("P1 is in CS, round:" + round);

      try {
        sleep(2000);
      } catch (InterruptedException e) {
      }

      this.lock_id.free();
      System.out.println("P1 is out of CS, round:" + round);

      try {
        sleep(500);
      } catch (InterruptedException e) {
      }
    }

    System.out.println("P1 finished!!!");
  }
}

class P2 extends Thread {
  private Lock lock_id;

  public P2(Lock lock_id_in) {
    this.lock_id = lock_id_in;
  }

  public void run() {
    boolean cc;
    int round;
    for (round = 0; round < 3; round++) {
      System.out.println("P2 entering CS, round:" + round);

      do {
        cc = this.lock_id.Tset();

        try {
          sleep(200);
        } catch (InterruptedException e) {
        }

        if (cc) {
          System.out.println("P2 still trying");
        }
      } while (cc);

      System.out.println("P2 is in CS, round:" + round);

      try {
        sleep(1000);
      } catch (InterruptedException e) {
      }

      this.lock_id.free();
      System.out.println("P2 is out of CS, round:" + round);

      try {
        sleep(500);
      } catch (InterruptedException e) {
      }
    }

    System.out.println("P2 finished!!!");
  }
}