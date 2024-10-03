package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor {
    private Position _pos;
    public ExitDoor(Position _pos){
        this._pos=_pos;
    }

    public String toString(){
        return Messages.EXIT_DOOR;
    }
    public boolean isInPos(Position p){
        return p.equals(_pos);
    }
}
