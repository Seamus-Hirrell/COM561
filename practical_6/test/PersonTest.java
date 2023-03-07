import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class PersonTest {
  @Test
  public void testGetDisplayName() {
    Person person = new Person("Josh", "Hayden", null);
    String displayName = person.getDisplayName();
    assertEquals("Hayden, Josh", displayName);
  }

  @Test
  public void testGetAge() {
    Person person = new Person("Malcolm", "Marshall", LocalDate.parse("2013-01-12"));
    long age = person.getAge();
    assertEquals(10, age);
  }
}
