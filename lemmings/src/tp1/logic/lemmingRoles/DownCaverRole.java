package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaverRole extends AbstractRole {
    private boolean hasCaved;

    @Override
    public void start(Lemming lemming) {
        hasCaved = false;
    }

    @Override
    public void play(Lemming lemming) {
        //if (!lemming.exits()) {
            if (lemming.isFalling())    //si esta cayendo
                lemming.handle_fall();
            else if (lemming.isInAir()) {//si va a caer
                if (hasCaved) {
                    hasCaved = false;
                    lemming.disableRole();
                }
                lemming.fall();
            } else if (lemming.can_cave()) { //si pared normal debajo
                lemming.cave();
                hasCaved = true;
            } else {                //si pared metalica debajo
                lemming.handle_fall();
            }
            lemming.checkPosition();
        //}
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
        return Messages.LEMMING_DOWN_CAVER_SHORTCUT;
    }

    @Override
    public boolean receiveInteraction(GameItem other, Lemming lemming) {
        return other.interactWith(lemming);
    }

    // devuelven true si existe interaccion
    @Override
    public boolean interactWith(Lemming receiver, Lemming lemming) {
        return false;
    }

    @Override
    public boolean interactWith(Wall wall, Lemming lemming) {
        return true;
    }

    @Override
    public boolean interactWith(ExitDoor door, Lemming lemming) {
        return true;
    }

    @Override
    public LemmingRole copia() {
        return new DownCaverRole();
    }

}
