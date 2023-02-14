package practical_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    executor.submit(new Runnable() {
      public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Hello " + threadName);
      }
    });

    executor.submit(() -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello " + threadName);
    });
  }
}
