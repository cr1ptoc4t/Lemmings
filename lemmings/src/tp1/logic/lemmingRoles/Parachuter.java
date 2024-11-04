package tp1.logic.lemmingRoles;
import  tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;

public class Parachuter implements LemmingRole {
    private static final String NAME = Messages.PARACHUTE_ROL_NAME;
    private static final String HELP = Messages.PARACHUTE_ROL_HELP;
    private static final String ICON = Messages.LEMMING_PARACHUTE;

    @Override
    public void start(Lemming lemming) {

    }

    public void play(Lemming lemming) {

    }

    public String getIcon(Lemming lemming) {
        return ICON;
    }

    private String getName() {
        return NAME;
    }

    public String getHelp() {
        return HELP;
    }

    @Override
    public String toString() {
        return getName();
    }
}
