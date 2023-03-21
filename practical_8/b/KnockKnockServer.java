package practical_8.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class KnockKnockServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(4444);
      try {
        Socket clientSocket = serverSocket.accept();
        try (BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter os = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));) {
          System.out.println("Knock Knock Server Waiting");

          KKState kks = new KKState();
          String inputLine, outputLine;
          outputLine = kks.processInput(null);

          os.println(outputLine);
          os.flush();

          while ((inputLine = is.readLine()) != null) {
            outputLine = kks.processInput(inputLine);

            os.println(outputLine);
            os.flush();

            if (outputLine.equals("Bye.")) {
              break;
            }
          }

          clientSocket.close();
          serverSocket.close();
        } catch (IOException e) {
          System.out.println("Failed to create I/O streams " + e);
          e.printStackTrace();
        }
      } catch (IOException e) {
        System.out.println("Accept failed on port: " + 4444 + ", " + e);
        System.exit(1);
      }

      serverSocket.close();
    } catch (IOException e) {
      System.out.println("Could not listen on port: " + 4444 + ", " + e);
      System.exit(1);
    }
  }
}