package practical_3;

class ThreadDemo {
  public static void main(String[] args) {
    MyThread mt = new MyThread();
    mt.start();

    // wait 1000 milliseconds
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted");
    }

    for (int i = 0; i < 50; i++) {
      System.out.println("i = " + i + ", i * i = " + i * i);
    }
  }
}

class MyThread extends Thread {
  public void run() {
    for (int count = 1, row = 1; row < 20; row++, count++) {
      for (int i = 0; i < count; i++) {
        System.out.print('*');
      }
      System.out.println();
    }

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted");
    }

    for (int count = 1, row = 1; row < 20; row++, count++) {
      for (int i = 0; i < count; i++) {
        System.out.print('*');
      }
      System.out.println();
    }
  }
}