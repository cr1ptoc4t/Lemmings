package tp1.control.commands;

import tp1.exceptions.*;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;


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
            if (game.setRole(_role, _pos)) {
                game.update();
                view.showGame();
            }
        } catch (OffBoardException e) {
            view.showError(e.getMessage());
            throw new CommandExecuteException(Messages.COMMAND_ROLE_ERROR);
        }
    }

    @Override
    public Command parse(String[] commandWords) throws GameParseException {
        if (commandWords.length == 4) {
            if (this.matchCommandName(commandWords[0])) {
                try {
                    LemmingRole role = LemmingRoleFactory.parse(commandWords[1]);
                    if (role != null) {
                        String x_str = commandWords[3];
                        String y_str = commandWords[2];
                        // check primer caracter es un numero y segundo no
                        if (Character.isDigit(x_str.charAt(0)) && !Character.isDigit(y_str.charAt(0))) {
                            int x = Integer.parseInt(x_str) - 1;
                            int y = Position.convert(Character.toUpperCase(y_str.charAt(0)));
                            // no hace falta mirar si la posicion es correcta porque ya lo hace el execute
                            return new SetRoleCommand(role, new Position(x, y));
                        } else throw new GameParseException(Messages.EXC_INVALID_COMMAND_PARAM, null);
                    }
                } catch (RoleParseException e) {
                    throw new GameParseException(Messages.UNKNOWN_ROLE, e);
                }
            }
        }  throw new GameParseException(Messages.INVALID_COMMAND, null);

    }

    @Override
    public String helpText() {
        return Messages.COMMAND_ROLE_DETAILS + " " + Messages.COMMAND_ROLE_HELP + LemmingRoleFactory.helpText();
    }
}
