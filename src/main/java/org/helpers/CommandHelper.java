package org.helpers;

import org.commands.*;

import java.util.HashMap;

public class CommandHelper {
    private static HashMap<String, ICommand> commands = null;
    static {
        commands = new HashMap<>();
        commands.put("login", new CommandLogin());
        commands.put("initiatives", new CommandInitiatives());
        commands.put("propose", new CommandPropose());
        commands.put("reports", new CommandReports());
        // TODO
    }

    private CommandHelper(){
    }

    public static ICommand getCommand(String key){
        return commands.get(key);
    }
}

