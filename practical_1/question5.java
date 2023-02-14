public class question5 {
  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Non-static methods must be called by creating objects");
  }

  // Main method
  public static void main(String args[]) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would compile an error

    question5 myObj = new question5(); // Create an object of MyClass
    myObj.myPublicMethod(); // Call the public method on the object
  }
}
