package tp1.logic.gameobjects;

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
        if(other.interactWith(this)){
            isAlive=false;
            return true;
        } return false;
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

    public boolean isSolid(){
        return true;
    }

}
