package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectTimeoutMain1 {

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();

    try {
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress("192.168.1.250", 15678), 1000);
    } catch (ConnectException e) {
      e.printStackTrace();
    }



    long end = System.currentTimeMillis();

    System.out.println("end = " + (end - start));
  }
}
