import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class Junit_Q2Test {
  public Junit_Q2Test() {
  }

  /**
   * Test of preProcessMessages method.
   */
  @Test
  public void testPreProcessMessages() {
    System.out.println("preProcessMessages");
    List<Message> listOfMessage = new ArrayList<Message>();

    listOfMessage.add(new Message("NAME1", "BODY1", "DESC1"));
    listOfMessage.add(new Message("NAME2", "BODY2", "DESC2"));
    listOfMessage.add(new Message("NAME3", "BODY3", "DESC3"));

    Junit_Q2 instance = new Junit_Q2();
    Envelope result = instance.preProcessMessages(listOfMessage);

    assertTrue(result.getMessage().size() > 0); // there should be messages processed

  }

  /**
   * Test of generateListOfMessages method
   */
  @Test
  public void testGenerateListOfMessages() {
    System.out.println("generateListOfMessages");
    Junit_Q2 instance = new Junit_Q2();

    List<Message> result = instance.generateListOfMessages();
    assertTrue(result.size() > 0); // there should be messages processed
  }

  /**
   * Test of postProcessMessages method, of class NetBeansSampleJUnitApplication.
   */
  @Test
  public void testPostProcessMessages() {
    System.out.println("postProcessMessages");
    List<Message> listOfMessage = new ArrayList<Message>();

    listOfMessage.add(new Message("NAME1", "BODY1", "DESC1"));
    listOfMessage.add(new Message("NAME2", "BODY2", "DESC2"));
    listOfMessage.add(new Message("NAME3", "BODY3", "DESC3"));

    Junit_Q2 instance = new Junit_Q2();
    Envelope expResult = new Envelope();

    Envelope result = instance.postProcessMessages(listOfMessage);

    // We are expecting that the composition of the class changed.
    assertFalse(expResult.equals(result));
  }

}
