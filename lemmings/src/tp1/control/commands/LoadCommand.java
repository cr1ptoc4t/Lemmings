package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends Command {

    private static final String NAME = Messages.COMMAND_LOAD_NAME;
    private static final String SHORTCUT = Messages.COMMAND_LOAD_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_LOAD_DETAILS;
    private static final String HELP = Messages.COMMAND_LOAD_HELP;
    private String _file;

    public LoadCommand(String file) {
        super(NAME, SHORTCUT, DETAILS, HELP);
        this._file=file;
    }

    public LoadCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }


    @Override
    public void execute(Game game, GameView view) throws CommandExecuteException {

    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(commandWords.length!=2) throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
        else return new LoadCommand(commandWords[1]);

    }


}
