package practical_5_b_3;

public class BoundedBufferTest2 {
  public static void main(String[] args) {
    BoundedBuffer b = new BoundedBuffer();

    Producer p1 = new Producer(b);
    Consumer c1 = new Consumer(b);

    p1.start();
    c1.start();
  }
}
