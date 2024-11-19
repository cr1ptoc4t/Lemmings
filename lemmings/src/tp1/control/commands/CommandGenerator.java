package tp1.control.commands;

import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

    private static final List<Command> availableCommands = Arrays.asList(
            new SetRoleCommand(),
            new UpdateCommand(),
            new ResetCommand(),
            new HelpCommand(),
            new ExitCommand()
    );

    public static Command parse(String[] commandWords) throws CommandParseException {
        for(Command c: availableCommands) {
            if(c.matchCommandName(commandWords[0]))
                return c.parse(commandWords);
        }
        throw new CommandParseException(Messages.UNKNOWN_COMMAND.formatted(commandWords[0]));
//        return null;
    }

    public static String commandHelp() {
        StringBuilder commands = new StringBuilder();

        for (Command c : availableCommands) {
            commands.append(Messages.TAB).append(c.helpText());
        }

        return commands.toString();
    }

}
