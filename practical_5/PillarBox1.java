package practical_5;

import java.util.concurrent.Semaphore;

class PillarBox1 {
  public static void main(String[] args) {
    ThePillarBox singleLetterBox = new ThePillarBox(0);

    Semaphore emptyBox = new Semaphore(1);
    Semaphore fullBox = new Semaphore(0);

    Producer p = new Producer(emptyBox, fullBox, singleLetterBox);
    Consumer c = new Consumer(emptyBox, fullBox, singleLetterBox);

    p.start();
    c.start();

    System.out.println("Threads Producer and Consumer commanded to start");
  }
}
