package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;

public class ParachuterRole extends AbstractRole {

    @Override
    public void start(Lemming lemming) {

    }

    public void play(Lemming lemming) {
        if (!lemming.exits()) {
            // caso en el que el lemming esta cayendo
            if (lemming.isFalling())
                lemming.handle_no_damage_fall();
            else {
                // caso va a caer
                if (lemming.isInAir())
                    lemming.fall();
                //caso en el que el se asigna rol cuando esta en tierra
                else{
                    lemming.disableRole();
                    lemming.normal_step();
                }
            }
            lemming.checkPosition();
        }
    }

    public String getIcon(Lemming lemming) {
        return Messages.LEMMING_PARACHUTE;
    }

    public String getName() {
        return Messages.PARACHUTE_ROL_NAME;
    }


    @Override
    public String getShortcut() {
        return Messages.PARACHUTE_ROL_SYMBOL;
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
        return lemming.exits();
    }

    @Override
    public LemmingRole copia() {
        return new ParachuterRole();
    }


    public String getHelp() {
        return Messages.PARACHUTE_ROL_HELP;
    }

    @Override
    public String toString() {
        return getName();
    }


}
