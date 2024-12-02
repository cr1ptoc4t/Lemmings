package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

import java.io.FileNotFoundException;

public class SaveCommand extends NoParamsCommand{
    private static String NAME = Messages.SAVE_COMMAND_NAME;
    private static String SHORTCUT = Messages.SAVE_COMMAND_SHORTCUT;
    private static String DETAILS = Messages.SAVE_COMMAND_DETAILS;
    private static String HELP = Messages.SAVE_COMMAND_HELP;

    private String _file;

    public SaveCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    public SaveCommand(String file){
        super(NAME, SHORTCUT, DETAILS, HELP);
        this._file =file;

    }

    @Override
    public void execute(Game game, GameView view) throws CommandExecuteException {
        try{
            game.save(_file, view);
        }catch (GameModelException e){
            throw new CommandExecuteException(String.format(Messages.FILE_NOT_FOUND, _file));
        }
    }

    public Command parse(String[] commandWords) throws CommandParseException {
        if(commandWords.length!=2)
            throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
        else return new SaveCommand(commandWords[1]);
    }
}
