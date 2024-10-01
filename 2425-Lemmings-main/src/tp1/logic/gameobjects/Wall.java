package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class Wall {
    private Position _pos;
    Wall(Position _pos){
        this._pos=_pos;
    }

    public String toString(){

        return Messages.WALL;
    }
}
