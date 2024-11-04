package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

    private static final List<Command> availableCommands = Arrays.asList(
            new UpdateCommand(),
            new ResetCommand(),
            new HelpCommand(),
            new ExitCommand(),
            new SetRoleCommand()
    );

    public static Command parse(String[] commandWords) {
        for(Command c: availableCommands) {
            if(c.matchCommandName(commandWords[0]))
                return c.parse(commandWords);
        }
        return null;
    }

    public static String commandHelp() {
        StringBuilder commands = new StringBuilder();

        for (Command c : availableCommands) {
            commands.append(c.helpText());
        }

        return commands.toString();
    }

}
