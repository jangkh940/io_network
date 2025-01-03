package network.chat.command;

import java.io.IOException;
import java.util.List;
import network.chat.server.Session;
import network.chat.server.SessionManager;

public class UsersCommand implements Command {

  private final SessionManager sessionManager;

  public UsersCommand(SessionManager sessionManager) {
    this.sessionManager = sessionManager;
  }

  @Override
  public void execute(String[] args, Session session) throws IOException {
    List<String> usernames = sessionManager.getAllUsername();
    StringBuilder sb = new StringBuilder();
    sb.append("전체 접속자 : ").append(usernames.size()).append("\n");
    for (String username : usernames) {
      sb.append(" - ").append(username).append("\n");
    }
    session.send(sb.toString());
  }
}
