/*
 * Program: EssentialFlow
 * Purpose: Simple demonstration of Java control flow
 */

public class EssentialFlow {
  public static void main(String args[]) {
    System.out.println("BRANCHING");
    // If-then branching
    boolean OK = true;

    // This is a simple if-then statement
    if (OK) {
      System.out.println("OK");
    } else {
      System.out.println("NOT OK");
    }

    // Multiple line if-then branches
    if (OK) {
      System.out.println("This is");
      System.out.println("OK");
    } else {
      System.out.println("Or is it");
      System.out.println("NOT OK");
    }

    // SWITCH type branching
    int temperature = 37;
    switch (temperature) {
      case (0):
        System.out.println("Freezing water!");
        break;
      case (37):
        System.out.println("Human body.");
        break;
      case (100):
        System.out.println("Boiling water!");
        break;
      default:
        System.out.println("Some temperature.");
    }

    System.out.println("LOOPING");
    // Simple FOR loop
    int counter;
    for (counter = 1; counter > 0; counter--) {
      System.out.println("Hi down: " + counter);
    }

    // FOR loop with non-unit step sizes.
    for (counter = -50; counter < 99; counter += 50) {
      System.out.println("Hi again: " + counter);
    }

    // WHILE loop with condition checked at the start
    counter = 0;
    OK = true;

    while (OK) {
      System.out.println("Still OK: " + counter);
      counter++;
      OK = (counter < 3);
    } // end while

    // DO-WHILE loop executes at least once; condition check at end.
    counter = 500;
    do {
      System.out.println("OK = " + OK + " counter = " + counter);
      counter++;
      OK = (counter < 3);
    } while (OK);
  } // end main
} // end EssentialFlow
