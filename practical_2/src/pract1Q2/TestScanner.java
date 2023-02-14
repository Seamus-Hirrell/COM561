/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pract1Q2;

/**
 *
 * @author csf19lis
 */
import java.util.Scanner;

public class TestScanner {
  public static void main(String args[]) throws Exception {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Type two integers: ");
      int i1 = scan.nextInt(); // reads an integer
      int i2 = scan.nextInt(); // reads an integer
      System.out.println("They were " + i1 + " and " + i2);
      System.out.print("Type two words: ");
      String firstWord = scan.next();
      String secondWord = scan.next();
      System.out.println("They were " + firstWord + " and " + secondWord);
    }
  }
}
