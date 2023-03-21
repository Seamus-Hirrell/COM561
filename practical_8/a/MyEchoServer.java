package practical_8.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// This program demonstrates a simple TCP/IP socket-based echo server.
public class MyEchoServer {
  public static void main(String[] args) {
    // using port 4000 as the echo port
    int port = Integer.parseInt("4000");

    try (
        ServerSocket serverSocket = new ServerSocket(port);) {
      System.out.println("Server is listening on port " + port);

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("New client connected");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        String inputLine;
        while ((inputLine = input.readLine()) != null) {
          output.println(inputLine);
          output.flush();
        }
      }
    } catch (IOException e) {
      System.out.println("Server exception: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
