package a;

import java.util.ArrayList;

public class TestNumberHolder1 {

  public static void printGeneratedNumbers(ArrayList<Integer> thisList) {
    // enumerates the elements in the list
    System.out.println("\nElements in list:");
    for (Integer i : thisList) {
      System.out.println(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws InterruptedException {
    NumberHolder1 holder = new NumberHolder1();
    Thread numberHolderThread = new Thread(holder);
    numberHolderThread.start();

    Thread.sleep(2000);
    numberHolderThread.stop();
    System.out.println("The thread was terminated using the deprecated Java stop() method.");

    ArrayList<Integer> temp = holder.getList();
    System.out.println("The list has the following " + temp.size() + " values:");
    printGeneratedNumbers(temp);
  }
}
