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


    public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException {
        String[] words = line.trim().split("\\s+");

        if (!words[1].equalsIgnoreCase(getName()))
            return null;

        try {
            Position p = new Position(words[0]);
            if(!p.valid_position())
                throw new OffBoardException(Messages.INVALID_POSITION);

            return new Wall(game, p);
        }catch (Exception e){
            throw new ObjectParseException(String.format(Messages.INVALID_OBJECT_POSITION, line));
        }

    }

    @Override
    public String getName() {
        return Messages.WALL_NAME;
    }
}
