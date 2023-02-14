package testio;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Testio {

  // method to convert a string representation to equivalent integer value
  public static int stringToInt(String s) {
    Integer idValue = null;
    try {
      idValue = Integer.valueOf(s);
    } catch (NumberFormatException e) {
      System.out.println("Exception caught from toInt(): " + e.getMessage());
    }
    return idValue;
  }

  public static void main(String args[]) throws Exception {

    // maps the default System.in stream to BufferedReader to readLine is available
    BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Type two integers with a <return> after each: ");
    System.out.flush();
    int i1 = stringToInt(cin.readLine());
    int i2 = stringToInt(cin.readLine());
    System.out.println("The integers were " + i1 + " and " + i2);
    System.out.println();
    System.out.println("Type two words with a <return> after each: ");
    System.out.flush();
    String firstWord = cin.readLine();
    String secondWord = cin.readLine();
    System.out.println("The words were " + firstWord + " and " + secondWord);
  }
}
