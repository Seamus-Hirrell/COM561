package b;

class Bank {
  public static final int INITIAL_BALANCE = 10000;
  public static final int NACCOUNTS = 10;

  private final long[] accounts;
  private int ntransacts;

  public Bank() {
    accounts = new long[NACCOUNTS];
    for (int i = 0; i < NACCOUNTS; i++) {
      accounts[i] = INITIAL_BALANCE;
    }
    ntransacts = 0;
    test();
  }

  /*
   * public void transfer(int from, int to, int amount) {
   * while (accounts[from] < amount) {
   * try {
   * Thread.sleep(5);
   * } catch (InterruptedException e) {
   * System.out.println("Interrupted");
   * }
   * }
   * 
   * accounts[from] -= amount;
   * accounts[to] += amount;
   * 
   * ntransacts++;
   * if (ntransacts % 5000 == 0) {
   * test();
   * }
   * }
   */

  public synchronized void transfer(int from, int to, int amount) {
    while (accounts[from] < amount) {
      try {
        wait(); // this wait() replaces sleep()
      } catch (InterruptedException e) {
      }
    }

    accounts[from] -= amount;
    accounts[to] += amount;
    ntransacts++;

    if (ntransacts % 5000 == 0) {
      test();
    }
    notify(); // this notify() is added to notify waiting threads
  }

  private void test() {
    long sum = 0;
    for (int i = 0; i < NACCOUNTS; i++) {
      sum += accounts[i];
    }
    System.out.println("Transactions:" + ntransacts + " Sum: " + sum);
  }
}