package practical_3;

class RunThreads {
  public static void main(String[] args) {
    ShowName possibleThread = new ShowName();
    Thread t1 = new Thread(possibleThread, "Kate");
    Thread t2 = new Thread(possibleThread, "John");
    Thread t3 = new Thread(possibleThread, "Mary");
    t1.start();
    t2.start();
    t3.start();
  }
}

class ShowName implements Runnable {
  public void run() {
    while (true) {
      System.out.println("Thread name: " + Thread.currentThread().getName());
    }
  }
}