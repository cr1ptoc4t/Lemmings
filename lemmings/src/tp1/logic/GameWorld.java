package tp1.logic;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameWorld {

    public boolean isInAir(Position pos);

    boolean isWallInPos(Position pos);
    boolean isExitDoorInPos(GameObject g);
    boolean isMetalInPos(Position nextPos);
/*  ESTO NO VA AQUI
    private static Position getPositionFrom(String line) throws ObjectParseException, OffBoardException {
        Position p = new Position(line.charAt(1), line.charAt(3));
        return p;
    }
    private static String getObjectNameFrom(String line) throws ObjectParseException {
        int spacePos = line.indexOf(' ');

        // Si hay un espacio, extrae la subcadena hasta el espacio
        String result = (spacePos != -1) ? line.substring(0, spacePos) : line;

        return result;
    }
    private static Direction getLemmingDirectionFrom(String line) throws ObjectParseException {
        Direction d = Direction.parse(line);
        if(d == Direction.NONE){
            throw new ObjectParseException("Invalid direction");
        }
        return d;
    }
    private static int getLemmingHeigthFrom(String line) throws ObjectParseException {
        if(false)
            throw new ObjectParseException("Invalid height");
        return 1;
    }

    private static LemmingRole getLemmingRoleFrom(String line) throws ObjectParseException {
        return null;
    }
*/
}
