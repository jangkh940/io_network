package network.chat.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import network.chat.command.ChangeCommand;
import network.chat.command.Command;
import network.chat.command.DefaultCommand;
import network.chat.command.ExitCommand;
import network.chat.command.JoinCommand;
import network.chat.command.MessageCommand;
import network.chat.command.UsersCommand;

public class CommandManagerV4 implements CommandManager {

  private static final String DELIMITER = "\\|";
  private final SessionManager sessionManager;
  private final Map<String, Command> commands = new HashMap<>();
  private final Command defaultCommand = new DefaultCommand();

  public CommandManagerV4(SessionManager sessionManager) {
    this.sessionManager = sessionManager;
    commands.put("/join", new JoinCommand(sessionManager));
    commands.put("/message", new MessageCommand(sessionManager));
    commands.put("/change", new ChangeCommand(sessionManager));
    commands.put("/users", new UsersCommand(sessionManager));
    commands.put("/exit", new ExitCommand());
  }

  @Override
  public void execute(String totalMessage, Session session) throws IOException {
    String[] args = totalMessage.split(DELIMITER);
    String key = args[0];

    // NullObject Pattern
    Command command = commands.getOrDefault(key, defaultCommand);
    command.execute(args, session);
  }
}
