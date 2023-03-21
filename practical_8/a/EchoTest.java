package practical_8.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoTest {
  public static void main(String[] args) {
    Socket echoSocket = null;
    PrintWriter os = null;

    BufferedReader is = null;
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    try {
      echoSocket = new Socket("localhost", 4000);

      os = new PrintWriter(new OutputStreamWriter(echoSocket.getOutputStream()));
      is = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
    } catch (UnknownHostException e) {
      System.err.println("Cannot connect to localhost");
    } catch (IOException e) {
      System.err.println("Couldn't get I/O streams");
    }

    // you are now connected to the localhost and get input and output streams
    if (echoSocket != null && os != null && is != null) {
      try {
        String userInput = null;
        while (!(userInput = stdIn.readLine()).isEmpty()) {
          os.println(userInput);
          os.flush();

          String echoedText = is.readLine();
          System.out.println("Echoed Text: " + echoedText);
        }

        os.close();
        is.close();

        echoSocket.close();
      } catch (IOException e) {
        System.err.println("I/O failed to communicate");
      }
    }
  }
}