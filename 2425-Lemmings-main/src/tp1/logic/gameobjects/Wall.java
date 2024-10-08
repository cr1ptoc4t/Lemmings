package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class Wall {
    private Position _pos;
    public Wall(Position _pos){
        this._pos=_pos;
    }

    public String toString(){
        return Messages.WALL;
    }
    public boolean isInPos(Position p){
        return p.equals(_pos);
    }
    public boolean isInPos(Wall p){
        return p._pos.equals(_pos);
    }
}
