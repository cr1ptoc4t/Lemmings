package tp1.logic.lemmingRoles;

import tp1.control.commands.*;

import java.util.Arrays;
import java.util.List;

public class LemmingRoleFactory {

    private static final List<LemmingRole> availableRoles = Arrays.asList(
            new ParachuterRole(),
            new WalkerRole(),
            new DownCaverRole()
    );

    public static LemmingRole parse(String input){
        for (LemmingRole role : availableRoles) {
            if (input.equalsIgnoreCase(role.getName()) ||
                    input.equalsIgnoreCase(role.getShortcut())) {
                return role;
            }
        }
        return null;
    }

    public static String helpText() {
        StringBuilder roles = new StringBuilder();

        for (LemmingRole role : availableRoles) {
            roles.append("\t\t").append(role.getHelp()).append("\n");
        }

        return roles.toString();
    }
}
