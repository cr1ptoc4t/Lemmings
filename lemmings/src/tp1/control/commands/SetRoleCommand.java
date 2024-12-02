package tp1.control.commands;

import tp1.exceptions.*;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

import java.lang.NumberFormatException;


public class SetRoleCommand extends Command {

    private static final String NAME = Messages.COMMAND_ROLE_NAME;
    private static final String SHORTCUT = Messages.COMMAND_ROLE_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_ROLE_DETAILS;
    private static final String HELP = Messages.COMMAND_ROLE_HELP;
    private LemmingRole _role;
    private Position _pos;

    public SetRoleCommand(LemmingRole role, Position pos) {
        super(NAME, SHORTCUT, DETAILS, HELP);
        this._role = role;
        this._pos = pos;
    }

    public SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public void execute(Game game, GameView view) throws CommandExecuteException {

        try {
            if (!game.setRole(_role, _pos)) {
                //throw new CommandExecuteException(String.format(Messages.EXC_NO_LEMMING_IN_POS, _pos.toString(), _role.getName()), null);
                view.showError(String.format(Messages.EXC_NO_LEMMING_IN_POS, _pos.toString(), _role.getName()+"\n"));
            }else {
                game.update();
                view.showGame();
            }
        } catch (OffBoardException e) {
            throw new CommandExecuteException(Messages.COMMAND_EXECUTE_EXCEPTION, e);
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (commandWords.length != 4)
            throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);

        try {
            LemmingRole role = LemmingRoleFactory.parse(commandWords[1]);

            int x = Integer.parseInt(commandWords[3]) - 1;
            int y = Position.convert(commandWords[2].charAt(0));

            return new SetRoleCommand(role, new Position(x, y));
        } catch (NumberFormatException e) {
            throw new CommandParseException(String.format(Messages.INVALID_ROLE, commandWords), e);
        } catch (RoleParseException e) {
            //throw new CommandParseException( "Invalid command parameters",e);
            throw new CommandParseException(e.getMessage());
        }

    }

    @Override
    public String helpText() {
        return Messages.COMMAND_ROLE_DETAILS + " " + Messages.COMMAND_ROLE_HELP + LemmingRoleFactory.helpText();
    }
}
