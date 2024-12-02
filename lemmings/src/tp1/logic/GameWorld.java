package tp1.logic;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameWorld {

    public boolean isInAir(Position pos);

    boolean isWallInPos(Position pos);
    boolean isExitDoorInPos(GameObject g);
    boolean isMetalInPos(Position nextPos);

}
