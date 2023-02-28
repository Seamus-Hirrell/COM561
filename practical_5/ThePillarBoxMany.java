package practical_5;

public class ThePillarBoxMany {
  private final int SIZE = 10;

  private int[] values = new int[SIZE];
  private int front;
  private int rear;

  ThePillarBoxMany() {
    for (int i = 0; i < SIZE; i++) {
      values[i] = 0;
    }

    front = 0;
    rear = 0;
  }

  public void putValue(int v) {
    values[rear] = v;
    rear = (rear + 1) % SIZE;
  }

  public int getValue() {
    int temp = values[front];
    front = (front + 1) % SIZE;
    return temp;
  }
}
