package practical_3;

class RunIdlers {
  public static void main(String[] args) {
    Idler lover = new Idler(8000);
    Idler hater = new Idler(16000);

    new Thread(lover, "She loves me").start();
    new Thread(hater, "No, she hates me").start();

    // occasionally print out a statement to show that RunIdlers can execute
    // concurrently with the two threads
    while (true) {
      System.out.println("Current Thread is: " + Thread.currentThread().getName());
      CDS.idle((int) (Math.random() * 10000));
    }
  }
}

class Idler implements Runnable {
  private int private_idle;

  Idler(int idleTime) {
    private_idle = idleTime;
  }

  public void run() {
    while (true) {
      System.out.println("Current Thread is: " + Thread.currentThread().getName());

      // sleep for a random time between 0 and private_idle
      CDS.idle((int) (Math.random() * private_idle));
    }
  }
}

class CDS {
  public static void idle(int millisecs) {
    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getName() + " : About to sleep for " + millisecs + " milliseconds");

    try {
      Thread.sleep(millisecs);
    } catch (InterruptedException e) {
      System.out.println(mainThread.getName() + " : Interrupted");
    }

    System.out.println(mainThread.getName() + " : Woken up");
  }
}
