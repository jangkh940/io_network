package network.chat.command;

import java.io.IOException;
import network.chat.server.Session;

public class ExitCommand implements Command {

  @Override
  public void execute(String[] args, Session session) throws IOException {
    throw new IOException("exit");
  }
}
