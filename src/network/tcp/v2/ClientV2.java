package network.tcp.v2;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV2 {

  private static final int PORT = 12345;

  public static void main(String[] args) throws IOException {
    log("클라이언트 시작");
    Socket socket = new Socket("localhost", PORT);
    DataInputStream input = new DataInputStream(socket.getInputStream());
    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
    log("소켓 연결 : " + socket);

    while (true) {
      System.out.print("전송 문자 : ");
      // 서버에게 문자 보내기
      Scanner scanner = new Scanner(System.in);
      String toSend = scanner.nextLine();
      output.writeUTF(toSend);
      log("client -> server : " + toSend);

      if(toSend.equals("exit")) {
        break;
      }

      // 서버로부터 문자 받기
      String received = input.readUTF();
      log("clent <- server : " + received);
    }

    // 자원 정리
    log("연결 종료 : " + socket);
    input.close();;
    output.close();
    socket.close();
  }
}