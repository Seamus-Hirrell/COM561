import java.util.ArrayList;
import java.util.List;

public class Junit_Q2 {

  public Envelope preProcessMessages(List<Message> listOfMessage) {

    // Create new message and put it in the envelop
    Envelope env = new Envelope();
    env.setEnvelopeId("1");
    env.setMessage(new ArrayList<Message>());

    for (Message msg : listOfMessage) {
      env.getMessage().add(msg);
    }

    return env;
  }

  public List<Message> generateListOfMessages() {
    Envelope env = new Envelope();
    env.setEnvelopeId("2LIST");

    env.setMessage(new ArrayList<Message>());

    env.getMessage().add(new Message("NAME1", "BODY1", "DESC1"));
    env.getMessage().add(new Message("NAME2", "BODY2", "DESC2"));

    return env.getMessage();
  }

  public Envelope postProcessMessages(List<Message> listOfMessage) {
    // Create new message and put it in the envelop
    Envelope env = new Envelope();
    env.setEnvelopeId("2");

    env.setMessage(new ArrayList<Message>());
    for (Message msg : listOfMessage) {
      env.getMessage().add(msg);
    }

    return env;
  }

}
