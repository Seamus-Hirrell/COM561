package practical_10;

import java.io.IOException;
import java.net.*;

/**
 * This example illustrates using threads to send and receive multi-
 * cast messages in one process.
 */
public class SenderReceiver {
  // An application which uses a multicast socket to send
  // a single message to a multicast group, and a separate
  // thread which uses a separate multicast socket to receive
  // messages sent to the same group.
  // Three command-line arguments are expected:
  // <multicast IP address>, <multicast port>, <YourFirstName>
  public static void main(String[] args) {
    if (args.length != 3)
      System.out.println("Three command-line arguments are expected.");
    else {
      try {
        InetAddress group = InetAddress.getByName(args[0]);
        int port = Integer.parseInt(args[1]);
        String userName = args[2];
        byte[] data = userName.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, group, port);
        try (MulticastSocket socket = new MulticastSocket(port)) {
          socket.setTimeToLive(1);
          socket.send(packet);
          System.out.println("The name " + userName + " has been broadcast to the group");
          Thread listenThread = new ReadThread(group, port);
          listenThread.start();
        }
      } catch (NumberFormatException | IOException se) {
        se.printStackTrace();
      }
    }
  }
}