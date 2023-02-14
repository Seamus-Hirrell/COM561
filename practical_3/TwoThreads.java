package practical_3;

public class TwoThreads {

  public static class Thread1 extends Thread {
    public void run() {
      // sleep for 1 second
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("Thread1 interrupted");
      }

      while (true) {
        System.out.println("A");
        System.out.println("B");
      }
    }
  }

  public static class Thread2 extends Thread {
    public void run() {
      while (true) {
        System.out.println("1");
        System.out.println("2");
      }
    }
  }

  public static void main(String[] args) {
    new Thread1().start();
    new Thread2().start();
  }
}
