package a;

import java.util.ArrayList;
import java.util.Random;

public class NumberHolder2 implements Runnable {
  private final int CAPACITY = 1000;
  private final ArrayList<Integer> list = new ArrayList<>(CAPACITY);
  private volatile boolean done = false;

  public ArrayList<Integer> getList() {
    return list;
  }

  public void shutdown() {
    done = true;
  }

  @Override
  public synchronized void run() {
    Random number = new Random();
    int i = CAPACITY;

    while (!done && i > 0) {
      list.add(number.nextInt(100));

      try {
        Thread.sleep(50);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }

      i--;
    }
  }
}
