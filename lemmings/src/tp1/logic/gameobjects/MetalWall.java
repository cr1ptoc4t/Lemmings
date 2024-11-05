package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class MetalWall extends GameObject{
    public MetalWall(Game game, Position pos) {
        super(game, pos);
    }

    @Override
    public String getIcon() {
        return "";
    }

    @Override
    public void update() {

    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
