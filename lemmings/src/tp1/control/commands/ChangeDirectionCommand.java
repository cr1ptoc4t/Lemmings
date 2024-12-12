package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.GameView;
import tp1.view.Messages;

public class ChangeDirectionCommand extends Command {

    private static final String NAME = "ChangeDirection";
    private static final String SHORTCUT = "CD";
    private static final String DETAILS = "[C]hange[D]irection <letter1>, <letter2>,\n" +
            "<number1>, <number2>";
    private static final String HELP = "Change the direction of all walker Lemmings located within the square formed by\n" +
            "the positions (<letter1>, <number1>), (<letter1>, <number2>),\n" +
            "(<letter2>, <number2>), and (<letter2>, <number1>).";

    private int x0, x1, y0, y1;

    public ChangeDirectionCommand(int x0, int x1, int y0, int y1) {
        super(NAME, SHORTCUT, DETAILS, HELP);
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }

    public ChangeDirectionCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }


    @Override
    public void execute(Game game, GameView view) throws CommandExecuteException {
        try {
            game.changeDirection(x0, x1, y0, y1);
            view.showGame();
        } catch (GameModelException e) {
            throw new CommandExecuteException("error ", e);
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(commandWords.length!=5)
            throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
        else
            return new ChangeDirectionCommand(Position.convert(commandWords[1].charAt(0)),
                    Position.convert(commandWords[2].charAt(0)), Integer.parseInt(commandWords[3]),
                    Integer.parseInt(commandWords[4]));

    }

}
