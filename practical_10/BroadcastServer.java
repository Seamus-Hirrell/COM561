package practical_10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class BroadcastServer {
  public static final int PORT = 1234;

  public static void main(String[] args) throws Exception {
    InetAddress address = InetAddress.getByName("239.1.2.3");
    try (MulticastSocket socket = new MulticastSocket()) {
      // join a Multicast group and send the group messages
      socket.joinGroup(address);
      for (;;) { // infinite loop
        Thread.sleep(10000);
        System.out.println("Sending ");
        String str = ("This is IRONMAN calling!!");
        byte[] data = str.getBytes();
        DatagramPacket packet = new DatagramPacket(data, str.length(), address, PORT);
        socket.send(packet);
      }
    } catch (IOException e) {
      System.err.println("Unable to open MulticastSocket " + e);
    }
  }
}