package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class DownCaverRole implements LemmingRole{
    @Override
    public void start(Lemming lemming) {

    }

    @Override
    public void play(Lemming lemming) {

    }

    @Override
    public String getIcon(Lemming lemming) {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getHelp() {
        return Messages.LEMMING_DOWN_CAVER_HELP;
    }

    @Override
    public String getShortcut() {
        return "";
    }

}
