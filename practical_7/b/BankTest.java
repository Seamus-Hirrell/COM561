package b;

class BankTest {
  public static void main(String[] args) {
    Bank b = new Bank();
    for (int i = 0; i < Bank.NACCOUNTS; i++) {
      new TransactionSource(b, i).start();
    }
  }
}