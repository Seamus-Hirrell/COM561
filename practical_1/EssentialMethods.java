/*
 * Program: EssentialMethods
 * Purpose: Simple demonstration of Java methods
 */

public class EssentialMethods {
  public static void main(String args[]) {
    greeter("Hello, methods.");
    greeter(waver(3));
  }

  public static void greeter(String greeting) {
    repeater(greeting, 1);
  }

  public static String waver(int waves) {
    repeater("WAVE", waves);
    return ("Done waving.");
  }

  public static void repeater(String line, int times) {
    for (int counter = 1; counter <= times; counter++) {
      System.out.println(line);
    }
  }
}
