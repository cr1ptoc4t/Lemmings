package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject{
    public MetalWall(GameWorld game, Position pos) {
        super(game, pos);
    }

    public MetalWall() {

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

    public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException {
        String[] words = line.trim().split("\\s+");

        if (!words[1].equalsIgnoreCase(getName()))
            return null;

        try {
            Position p = new Position(words[0]);
            if(!p.valid_position())
                throw new OffBoardException(Messages.INVALID_POSITION);

            return new MetalWall(game, p);
        }catch (Exception e){
            throw new ObjectParseException("Invalid MetalWall");
        }

    }

    @Override
    public String getName() {
        return Messages.METALWALL_NAME;
    }
}
