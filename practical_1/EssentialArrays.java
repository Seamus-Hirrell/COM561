/*
 * Program: EssentialArrays Class
 * Purpose: demonstrate Java array of arrays
 */

public class EssentialArrays {
  public static void main(String args[]) {
    int myTable[][] = new int[2][3]; // this statement sets up a two-dimensional array
    System.out.println("This is an array of arrays...");
    myTable[0][0] = 1;
    myTable[0][1] = 2;
    myTable[0][2] = 3;
    myTable[1][0] = 4;
    myTable[1][1] = 5;
    myTable[1][2] = 6;
    System.out.println(myTable[0][0]);
    System.out.println(myTable[0][1]);
    System.out.println(myTable[0][2]);
    System.out.println(myTable[1][0]);
    System.out.println(myTable[1][1]);
    System.out.println(myTable[1][2]);
  }
}
