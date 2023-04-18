package practical_10;

import java.net.*;

/**
 * This class is to be used with SenderReceiver for reading multi-
 * cast messages while the main thread sends a multi-cast message. Each
 * message read is echoed on the screen.
 */
class ReadThread extends Thread {
  static final int MAX_LEN = 30;
  private final InetAddress group;
  private final int port;

  public ReadThread(InetAddress group, int port) {
    this.group = group;
    this.port = port;
  }

  @Override
  public void run() {
    try (MulticastSocket socket = new MulticastSocket(port)) {
      socket.joinGroup(group);
      while (true) {
        byte[] data = new byte[MAX_LEN];
        DatagramPacket packet = new DatagramPacket(data, data.length, group, port);
        socket.receive(packet);
        String s = new String(packet.getData());
        System.out.println(s);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}