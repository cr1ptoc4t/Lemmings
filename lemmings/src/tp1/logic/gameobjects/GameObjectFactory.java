package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.GameWorld;
import tp1.logic.lemmingRoles.DownCaverRole;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.ParachuterRole;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.view.Messages;

import java.util.Arrays;
import java.util.List;

public class GameObjectFactory {

    private static final List<GameObject> availableObjects = Arrays.asList(
            new ExitDoor(),
            new Lemming(),
            new MetalWall(),
            new Wall()
    );

    public static GameObject parse(String line, GameWorld game)
            throws ObjectParseException, OffBoardException {

        String[] words = line.trim().split("\\s+");

        try {
            for (GameObject obj : availableObjects) {
                if (obj.getName().equals(words[1])) {
                    return obj.parse(line, game);
                }
            }
        } catch (OffBoardException e) {
            throw new OffBoardException(e.getMessage());
        } catch (ObjectParseException e) {
            throw new ObjectParseException(e.getMessage());
        }


        throw new ObjectParseException(String.format(Messages.UNKNOWN_GAME_OBJECT, line));
        //lanza ObjectParserException si line no se corresponde con ninguno
        //de los objetos disponibles (todos han devuelto null)
        //o alguno de ellos ha generado una excepción

        //lanza OffBoardException si la posición en line está fuera del tablero

        //NUNCA devuelve null
    }

}
