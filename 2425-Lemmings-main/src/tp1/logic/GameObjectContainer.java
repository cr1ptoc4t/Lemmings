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

    private int _ndead_lemmings;
    private int _nexit_lemmings;

    public GameObjectContainer() {
        initContainer();
    }

    public void add(Lemming lemming) {
        _lemmings[_nlemmings] = lemming;
        _nlemmings++;
    }

    public void add(Wall wall) {
        if (!isWallInPos(wall)) {
            _walls[_nwalls] = wall;
            _nwalls++;
        }

    }

    public void add(ExitDoor exitDoor) {
        this._exit_door = exitDoor;
    }

    public String someoneInPos(Position pos) {
        int i = 0;
        while (i < _nlemmings && !_lemmings[i].isInPos(pos))
            i++;

        if (i != _nlemmings)
            return _lemmings[i].toString();
        else {
            i = 0;
            while (i < _nwalls && !_walls[i].isInPos(pos))
                i++;

            if (i != _nwalls)
                return _walls[i].toString();

            else if (_exit_door.isInPos(pos))
                return _exit_door.toString();
        }

        return "";

    }

    public int get_nlemmings() {
        return _nlemmings;
    }
    public int get_nwalls() {
        return _nwalls;
    }
    public int get_ndead_lemmings() {
        return _ndead_lemmings;
    }
    public int get_nexit_lemmings() {
        return _nexit_lemmings;
    }


    private void initContainer() {
        _nlemmings = 0;
        _lemmings = new Lemming[2000];
        _nwalls = 0;
        _walls = new Wall[2000];
    }

    public void update() {
        for (int i = 0; i < _nlemmings; i++) {
            _lemmings[i].update();
        }
    }

    public boolean isWallInPos(Wall w){
        int i=0;
        while(i<_nwalls && !_walls[i].isInPos(w)) i++;
        return i!=_nwalls;
    }

    public void procesaMuertos(){
        int i=0;
        while( i<_nlemmings){
            if(!_lemmings[i].isAlive()){
                _ndead_lemmings++;
                for(int j=i; j<_nlemmings-1; j++) {
                    _lemmings[j] = _lemmings[j + 1];
                }
            }
            else i++;
        }
    }
}
