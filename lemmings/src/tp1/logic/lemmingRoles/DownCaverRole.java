package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaverRole extends AbstractRole{
    private boolean hasCaved = false;
    @Override
    public void start(Lemming lemming) {

    }

    @Override
    public void play(Lemming lemming) {

    }

    @Override
    public String getIcon(Lemming lemming) {
        return Messages.LEMMING_DOWN_CAVER;
    }

    @Override
    public String getName() {
        return Messages.LEMMING_DOWN_CAVER_NAME;
    }

    @Override
    public String getHelp() {
        return Messages.LEMMING_DOWN_CAVER_HELP;
    }

    @Override
    public String getShortcut() {
        return "";
    }

    @Override
    public boolean receiveInteraction(GameItem other, Lemming lemming) {
        return false;
    }

    @Override
    public boolean interactWith(Lemming receiver, Lemming lemming) {
        return false;
    }

    @Override
    public boolean interactWith(Wall wall, Lemming lemming) {
        return false;
    }

    @Override
    public boolean interactWith(ExitDoor door, Lemming lemming) {
        return false;
    }

}
