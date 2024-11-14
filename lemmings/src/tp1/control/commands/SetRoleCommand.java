package tp1.control.commands;

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
    public void execute(Game game, GameView view) {
        if (_pos.valid_position()) {
            if (game.setRole(_role, _pos)) {
                game.update();
                view.showGame();
            } else
                view.showError(Messages.COMMAND_ROLE_ERROR + Messages.ERROR_INVALID_POSITION);
        } else
            view.showError(Messages.COMMAND_ROLE_ERROR + Messages.ERROR_INVALID_POSITION);
    }

    @Override
    public Command parse(String[] commandWords) {
        if (commandWords.length == 4) {
            if (this.matchCommandName(commandWords[0])) {
                LemmingRole role = LemmingRoleFactory.parse(commandWords[1]);
                if (role != null) {
                    int x = Integer.parseInt(commandWords[3]) - 1;
                    int y = Position.convert(Character.toUpperCase(commandWords[2].charAt(0)));
                    return new SetRoleCommand(role, new Position(x, y));
                }
            }
        }
        return null;
    }

    @Override
    public String helpText() {
        return Messages.COMMAND_ROLE_DETAILS + " " + Messages.COMMAND_ROLE_HELP + LemmingRoleFactory.helpText();
    }
}
