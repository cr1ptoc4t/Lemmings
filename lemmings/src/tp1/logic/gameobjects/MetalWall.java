package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject{
    public MetalWall(Game game, Position pos) {
        super(game, pos);
    }

    @Override
    public String getIcon() {
        return Messages.METALWALL;
    }

    @Override
    public void update() {

    }

    @Override
    public boolean receiveInteraction(GameItem other) {
        return false;
    }

    @Override
    public boolean interactWith(Lemming lemming) {
        return false;
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
    public boolean isSolid(){
        return true;
    }

    public boolean isMetal(){
        return true;
    }
}
