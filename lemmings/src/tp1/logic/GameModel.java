package tp1.logic;

import tp1.exceptions.OffBoardException;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {

    public boolean setRole(LemmingRole role, Position position)
            throws OffBoardException;

}
