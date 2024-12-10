package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
    public ExitDoor(GameWorld game, Position pos) {
        super(game, pos);
    }

    public ExitDoor() {

    }

    @Override
    public String getIcon() {
        return Messages.EXIT_DOOR;
    }

    @Override
    public void update() {

    }

    @Override
    public boolean receiveInteraction(GameItem other) {
        if (other.interactWith(this)) {
            isAlive = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean interactWith(Lemming lemming) {
        return true;
    }

    @Override
    public boolean interactWith(Wall wall) {
        return false;
    }

    @Override
    public boolean interactWith(ExitDoor door) {
        return false;
    }

    @Override
    public boolean isExit() {
        return true;
    }


    @Override
    public String getName() {
        return Messages.EXITDOOR_NAME;
    }

    @Override
    public GameObject copy(GameWorld game, Position p) {
        return new ExitDoor(game, p);
    }
}
