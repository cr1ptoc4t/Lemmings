package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class Wall extends GameObject{

    public Wall(GameWorld game, Position pos) {
        super(game, pos);
    }

    public Wall() {

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


    @Override
    public String getName() {
        return Messages.WALL_NAME;
    }

    @Override
    public GameObject copy(GameWorld game, Position p) {
        return new Wall(game, p);
    }
}
