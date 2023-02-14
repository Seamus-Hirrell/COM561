/*
 * Program: EssentialOperators
 * Purpose: Simple demonstration of Java operators.
 */

public class EssentialOperators {
  public static void main(String args[]) {
    int myInteger = 42;
    double myReal = 3.14159;
    System.out.println("UNARY OPERATORS");
    System.out.println(-myInteger); // negate an integer
    System.out.println(-myReal); // negate a real number
    System.out.println(myInteger++); // display the number then add 1 to it
    System.out.println(myInteger--); // display the number then subtract 1
    System.out.println("BINARY OPERATORS");
    System.out.println(myInteger + 100); // addition
    System.out.println(myInteger - myReal); // subtraction
    System.out.println(100 * myReal); // multiplication
    System.out.println(myInteger / 3.0); // division with real
    System.out.println(myInteger / 3); // division without remainder
    System.out.println(myInteger / 3); // real division
    System.out.println(myInteger % 3); // modulo arithmetic shows the remainder
    System.out.println("RELATIONAL OPERATORS");
    System.out.println(myInteger > 32); // greater than
    System.out.println(myInteger >= 32); // greater than or equal to
  } // end Main
} // end EssentialOperators
