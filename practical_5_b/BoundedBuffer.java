package practical_5_b;

public class BoundedBuffer {
  private int SIZE = 10;
  private int buffer[] = new int[SIZE];

  private boolean writable = true;
  private boolean readable = false;

  private int readLocation = 0;
  private int writeLocation = 0;

  private int val;

  public synchronized int get() {
    while (!readable) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }

    writable = true;
    val = buffer[readLocation];
    readLocation = (readLocation + 1) % SIZE;

    if (readLocation == writeLocation) {
      readable = false;
    }

    notify();
    return val;
  }

  public synchronized void put(int value) {
    while (!writable) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }

    buffer[writeLocation] = value;
    readable = true;
    writeLocation = (writeLocation + 1) % SIZE;

    if (writeLocation == readLocation) {
      writable = false;
    }
    notify();
  }
}
