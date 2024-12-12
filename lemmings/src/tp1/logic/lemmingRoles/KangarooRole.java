package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;

public class KangarooRole extends AbstractRole{

    public void start( Lemming lemming ){
        lemming.setSolid(false);
    }

    public void play( Lemming lemming ){
        if(lemming.wallInFront() && lemming.canJump()){
            lemming.jump();
        } else{
            lemming.disableRole();
            lemming.normal_step();
        }
    }

    public String getIcon( Lemming lemming ){
        return "🦘";
    }

    public String getName(){
        return "Kangaroo";
    }
    public String getHelp(){
        return "[K]angaroo: jumps the wall infront of him\n";
    }
    public String getShortcut(){
        return "K";
    }

    public LemmingRole copia(){
        return new KangarooRole();
    }
}
