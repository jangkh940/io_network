package network.chat.command;

import java.io.IOException;
import network.chat.server.Session;
import network.chat.server.SessionManager;

public class ChangeCommand implements Command {

  private final SessionManager sessionManager;


  public ChangeCommand(SessionManager sessionManager) {
    this.sessionManager = sessionManager;
  }

  @Override
  public void execute(String[] args, Session session) {
    // /change|han2
    String changeName = args[1];
    sessionManager.sendAll(session.getUsername() +"님이 " + changeName + "로 이름을 변경했습니다.");
    session.setUsername(changeName);
  }
}
