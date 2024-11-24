package tp1.control.commands;

import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameParseException;
import tp1.exceptions.RoleParseException;
import tp1.view.Messages;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

    private static final List<Command> availableCommands = Arrays.asList(
            new SetRoleCommand(),
            new UpdateCommand(),
            new ResetCommand(),
            new LoadCommand(),
            new HelpCommand(),
            new ExitCommand()
    );

    public static Command parse(String[] commandWords) throws CommandParseException {
        //try {
            for (Command c : availableCommands) {
                if (c.matchCommandName(commandWords[0])) {
                    return c.parse(commandWords);
                }
            }
        //} //catch (CommandParseException e) {
          //  throw new CommandParseException(e.getMessage());
        //}
        throw new CommandParseException(String.format(Messages.UNKNOWN_COMMAND, commandWords[0]));
    }

    public static String commandHelp() {
        StringBuilder commands = new StringBuilder();

        for (Command c : availableCommands) {
            commands.append(Messages.TAB).append(c.helpText());
        }

        return commands.toString();
    }

}
