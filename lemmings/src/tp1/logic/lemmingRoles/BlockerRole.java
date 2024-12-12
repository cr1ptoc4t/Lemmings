package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;

public class BlockerRole extends AbstractRole {

    public void start( Lemming lemming ){
        lemming.setSolid(true);
    }

    public void play( Lemming lemming ){
    }

    public String getIcon( Lemming lemming ){
        return "B";
    }

    public String getName(){
        return "Blocker";
    }
    public String getHelp(){
        return "[B]locker: Blocker lemmings are solid and can't be passed through. \n";
    }
    public String getShortcut(){
        return "B";
    }

    public LemmingRole copia(){
        return new BlockerRole();
    }
}
