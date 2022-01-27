package com.example.finalproject.controller.command;

import com.example.finalproject.controller.CommandType;
import com.example.finalproject.controller.command.impl.*;
import com.example.finalproject.controller.command.impl.client.EditPersonalInformationAboutClient;
import com.example.finalproject.controller.command.impl.common.*;
import com.example.finalproject.controller.command.impl.owner.AddNewButlerCommand;
import com.example.finalproject.controller.command.impl.owner.AddNewOwnerCommand;
import com.example.finalproject.controller.command.impl.owner.AddNewRoomCommand;

import java.util.EnumMap;

public class CommandProvider {
    private static CommandProvider instance;
    private final EnumMap<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    private CommandProvider() {
        commands.put(CommandType.SIGN_IN, new SignInCommand());
        commands.put(CommandType.DEFAULT, new DefaultCommand());
        commands.put(CommandType.CHANGE_LOCALE,new ChangeLocaleCommand());
        commands.put(CommandType.SIGN_UP, new SignUpCommand());
        commands.put(CommandType.SHOW_ALL_ROOMS, new ShowAllRoomsCommand());
        commands.put(CommandType.EDIT_PERSONAL_INFORMATION, new EditPersonalInformationCommand());
        commands.put(CommandType.EDIT_PERSONAL_INFORMATION_ABOUT_CLIENT, new EditPersonalInformationAboutClient());
        commands.put(CommandType.SIGN_OUT, new SignOutCommand());
        commands.put(CommandType.ADD_ROOM, new AddNewRoomCommand());
        commands.put(CommandType.ADD_BUTLER, new AddNewButlerCommand());
        commands.put(CommandType.ADD_OWNER, new AddNewOwnerCommand());
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