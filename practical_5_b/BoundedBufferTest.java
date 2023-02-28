package practical_5_b;

public class BoundedBufferTest {
  public static void main(String[] args) {
    BoundedBuffer b = new BoundedBuffer();

    ProducerForBB p1 = new ProducerForBB(b);
    ConsumerForBB c1 = new ConsumerForBB(b);

    p1.start();
    c1.start();
  }
}
