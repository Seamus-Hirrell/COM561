package practical_2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Use a BufferedReader to read characters from the console.
public class BRRead {
  public static void main(String args[]) throws Exception {
    char c;

    // Create a BufferedReader using System.in.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter characters, 'q' to quit.");

    // Read characters.
    do {
      c = (char) br.read();
      System.out.println(c);
    } while (c != 'q');
  }
}
