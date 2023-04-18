package practical_10;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class BroadcastClient {
  public static final int PORT = 1234;

  public static void main(String[] args) throws Exception {
    InetAddress address = InetAddress.getByName("239.1.2.3");
    try (MulticastSocket socket = new MulticastSocket(PORT)) {
      socket.joinGroup(address);
      for (;;) { // infinite loop
        byte[] data = new byte[100];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        for (;;) {
          socket.receive(packet);
          String str = new String(packet.getData());
          System.out.println("Message received from " + packet.getAddress() + " : " + str);
        }
      }
    } catch (java.io.IOException e) {
      System.err.println("Unable to create Socket on specified port");
    }
  }
}
