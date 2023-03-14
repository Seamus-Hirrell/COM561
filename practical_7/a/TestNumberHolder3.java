package a;

import java.util.ArrayList;

public class TestNumberHolder3 {

  public static void printGeneratedNumbers(ArrayList<Integer> thisList) {
    System.out.println("\nElements in list:");
    for (int i = 0; i < thisList.size(); i++) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws InterruptedException {
    NumberHolder3 holder = new NumberHolder3();
    Thread numberHolderThread = new Thread(holder);
    numberHolderThread.start();

    Thread.sleep(500);
    numberHolderThread.interrupt(); // interrupts the thread
    System.out.println("The thread was terminated using the interrupt() method");

    ArrayList<Integer> temp = holder.getList();
    System.out.println("The list has the following " + temp.size() + " values:");
    printGeneratedNumbers(temp);
  }
}