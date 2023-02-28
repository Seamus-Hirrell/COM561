package practical_5;

public class CDS {
  public static void idle(int millisecs) {
    Thread mainThread = Thread.currentThread();

    System.out.println(mainThread.getName() + ": About to sleep");
    try {
      Thread.sleep(millisecs);
    } catch (InterruptedException e) {
    }

    System.out.println(mainThread.getName() + ": Woken up");
  }

  public static void idleQuietly(int millisecs) {
    try {
      Thread.sleep(millisecs);
    } catch (InterruptedException e) {
    }
  }
}