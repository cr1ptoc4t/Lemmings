package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

import java.util.ArrayList;

public class GameObjectContainer {
    //Array de walls
    private int _nwalls;
    private Wall[] _walls;
    //Array de Lemmings
    private int _nlemmings;
    private Lemming[] _lemmings;
    private ExitDoor _exit_door;

    GameObjectContainer(){
        _nlemmings=0;
        _lemmings= new Lemming[2000];
        //_exit_door= new ExitDoor();
        _nwalls=0;
        _walls = new Wall[2000];
    }

    public void add(Lemming lemming) {
        _lemmings[_nlemmings] = lemming;
        _nlemmings++;
    }

    public void add(Wall wall) {
        _walls[_nwalls] = wall;
        _nwalls++;
    }

    public void add(ExitDoor exitDoor) {
        this._exit_door=exitDoor;
    }

    public String someoneInPos(Position pos){
        int i=0;
        while(i<_nlemmings && !_lemmings[i].isInPos(pos))
            i++;

        if(i!=_nlemmings)
            return _lemmings[i].toString();
        else{
            i=0;
            while(i<_nwalls && !_walls[i].isInPos(pos))
                i++;

            if(i!=_nwalls)
                return _walls[i].toString();

        }


        return "";

    }
}
