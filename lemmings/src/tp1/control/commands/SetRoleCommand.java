package tp1.control.commands;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

import javax.management.relation.Role;

public class SetRoleCommand extends Command{

    private static final String NAME = Messages.COMMAND_ROLE_NAME;
    private static final String SHORTCUT = Messages.COMMAND_ROLE_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_ROLE_DETAILS;
    private static final String HELP = Messages.COMMAND_ROLE_HELP;
    private LemmingRole _role;
    private Position _pos;

    public SetRoleCommand(LemmingRole role, Position pos) {
        super(NAME, SHORTCUT, DETAILS, HELP);
        this._role=role;
        this._pos=pos;
    }

    public SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public void execute(Game game, GameView view) {
        game.setRole(_role, _pos);
        view.showGame();
    }

    @Override
    public Command parse(String[] commandWords) {
        if(commandWords.length==4 && this.matchCommandName(commandWords[0])){
            Position p = new Position(Integer.valueOf(commandWords[2]), Integer.valueOf(commandWords[3]));
            if(p.valid_position()){
                LemmingRole role = LemmingRoleFactory.parse(commandWords[1]);
                if(role!=null) return new SetRoleCommand(role, p);
            }
        }
        return null;
    }

    @Override
    public String helpText() {
        return Messages.COMMAND_ROLE_DETAILS + " " + Messages.COMMAND_ROLE_HELP + "\n"+ LemmingRoleFactory.helpText();
    }
}
