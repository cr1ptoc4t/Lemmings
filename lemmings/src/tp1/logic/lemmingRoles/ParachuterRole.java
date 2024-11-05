package tp1.logic.lemmingRoles;

import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;

public class ParachuterRole implements LemmingRole {

    @Override
    public void start(Lemming lemming) {

    }

    public void play(Lemming lemming) {
        if (!lemming.dies()) {
            if (lemming.isFalling())
                lemming.handle_no_damage_fall();
            else if (lemming.isInAir())
                lemming.fall();

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

    public String getHelp() {
        return Messages.PARACHUTE_ROL_HELP;
    }

    @Override
    public String toString() {
        return getName();
    }


}
