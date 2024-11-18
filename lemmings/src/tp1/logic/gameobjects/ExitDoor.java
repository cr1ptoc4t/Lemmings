package tp1.logic.gameobjects;

<<<<<<< HEAD
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor {

    private final Position _pos;

    public ExitDoor(Position _pos){
        this._pos=_pos;
    }

    public String toString(){
        return Messages.EXIT_DOOR;
    }
    public boolean isInPos(Position p){
        return p.equals(_pos);
=======
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {
    public ExitDoor(Game game, Position pos) {
        super(game, pos);
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
        if(other.interactWith(this)){
            isAlive=false;
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
>>>>>>> v2.0
    }

}
