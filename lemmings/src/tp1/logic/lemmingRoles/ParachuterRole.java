package tp1.logic.lemmingRoles;
import  tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;

public class ParachuterRole implements LemmingRole {
    private static final String NAME = Messages.PARACHUTE_ROL_NAME;
    private static final String HELP = Messages.PARACHUTE_ROL_HELP;
    private static final String ICON = Messages.LEMMING_PARACHUTE;
    private static final String SHORTCUT = Messages.PARACHUTE_ROL_SYMBOL;

    @Override
    public void start(Lemming lemming) {

    }

    public void play(Lemming lemming) {

    }

    public String getIcon(Lemming lemming) {
        return ICON;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public String getShortcut() {
        return SHORTCUT;
    }

    public String getHelp() {
        return HELP;
    }

    @Override
    public String toString() {
        return getName();
    }


}
