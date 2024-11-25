package tp1.logic;

import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {
    public boolean isFinished();
    public boolean setRole(LemmingRole role, Position position) throws OffBoardException;
    public void reset();
    public void update();



    //public boolean isInAir(Position rolePosition);
   // public boolean isWallInPos(Position position);
    //public boolean isMetalInPos(Position position);
    //public boolean isExitDoorInPos(GameObject g);
}
