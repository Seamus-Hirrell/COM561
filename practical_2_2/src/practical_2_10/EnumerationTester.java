package practical_2_10;

import java.util.ArrayList;
import java.util.List;

public class EnumerationTester {
  public static void main(String args[]) {
    List<String> dayNames = new ArrayList<String>();
    dayNames.add("Sunday");
    dayNames.add("Monday");
    dayNames.add("Tuesday");
    dayNames.add("Wednesday");
    dayNames.add("Thursday");
    dayNames.add("Friday");
    dayNames.add("Saturday");

    for (String dayName : dayNames) {
      System.out.println(dayName);
    }
  }
}
