package tp1.logic.lemmingRoles;

import tp1.exceptions.RoleParseException;
import tp1.view.Messages;

import java.util.Arrays;
import java.util.List;

public class LemmingRoleFactory {

    private static final List<LemmingRole> availableRoles = Arrays.asList(
            new DownCaverRole(),
            new ParachuterRole(),
            new WalkerRole()
    );

    public static LemmingRole parse(String input) throws RoleParseException {
        for (LemmingRole role : availableRoles) {
            if (input.equalsIgnoreCase(role.getName()) ||
                    input.equalsIgnoreCase(role.getShortcut())) {
                return role.copia();
            }
        }
        throw new RoleParseException(String.format(Messages.UNKNOWN_ROLE, input));
    }

    public static String helpText() {
        StringBuilder roles = new StringBuilder();
        for (LemmingRole role : availableRoles) {
            roles.append(Messages.TAB).append(Messages.TAB).append(role.getHelp());
        }
        return roles.toString();
    }
}
