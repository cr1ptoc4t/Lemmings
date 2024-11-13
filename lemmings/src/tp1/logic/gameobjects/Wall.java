package tp1.logic.gameobjects;

<<<<<<< HEAD
import tp1.logic.Position;
import tp1.view.Messages;

public class Wall {
    private final Position _pos;
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
=======
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Wall extends GameObject{

    public Wall(Game game, Position pos) {
        super(game, pos);
    }

    @Override
    public String getIcon() {
        return Messages.WALL;
    }

    @Override
    public void update() {

    }

    @Override
    public boolean receiveInteraction(GameItem other) {
        return other.interactWith(this);
    }

    @Override
    public boolean interactWith(Lemming lemming) {
        isAlive = false;
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

    public boolean isSolid(){
        return true;
>>>>>>> v2.0
    }
}
