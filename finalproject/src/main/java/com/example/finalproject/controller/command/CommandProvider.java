package com.example.finalproject.controller.command;

import com.example.finalproject.controller.CommandType;
import com.example.finalproject.controller.command.impl.ChangeLocaleCommand;
import com.example.finalproject.controller.command.impl.DefaultCommand;
import com.example.finalproject.controller.command.impl.SignInCommand;

import java.util.EnumMap;

public class CommandProvider {
    private static CommandProvider instance;
    private final EnumMap<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    private CommandProvider() {
        commands.put(CommandType.SIGN_IN, new SignInCommand());
        commands.put(CommandType.DEFAULT, new DefaultCommand());
        commands.put(CommandType.CHANGE_LOCALE,new ChangeLocaleCommand());
    }

    public static CommandProvider getInstance() {
        if (instance == null) {
            instance = new CommandProvider();
        }
        return instance;
    }

    public Command getCommand(CommandType commandType) {
        if (commandType == null) {
            return commands.get(CommandType.DEFAULT);
        }
        return commands.get(commandType);
    }
}