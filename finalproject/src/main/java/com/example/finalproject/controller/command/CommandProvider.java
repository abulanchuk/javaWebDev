package com.example.finalproject.controller.command;

import com.example.finalproject.controller.CommandType;
import com.example.finalproject.controller.command.impl.*;
import com.example.finalproject.controller.command.impl.client.AddMoneyToBankAccountCommand;
import com.example.finalproject.controller.command.impl.client.ChangePasswordCommand;
import com.example.finalproject.controller.command.impl.client.CreateOrderCommand;
import com.example.finalproject.controller.command.impl.client.EditPersonalInformationAboutClientCommand;
import com.example.finalproject.controller.command.impl.common.*;
import com.example.finalproject.controller.command.impl.owner.*;

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
        commands.put(CommandType.EDIT_PERSONAL_INFORMATION_ABOUT_CLIENT, new EditPersonalInformationAboutClientCommand());
        commands.put(CommandType.SIGN_OUT, new SignOutCommand());
        commands.put(CommandType.ADD_ROOM, new AddNewRoomCommand());
        commands.put(CommandType.ADD_BUTLER, new AddNewButlerCommand());
        commands.put(CommandType.ADD_OWNER, new AddNewOwnerCommand());
        commands.put(CommandType.DELETE_CLIENT, new DeleteClientCommand());
        commands.put(CommandType.DELETE_BUTLER, new DeleteButlerCommand());
        commands.put(CommandType.UPDATE_CASH, new AddMoneyToBankAccountCommand());
        commands.put(CommandType.CREATE_ORDER, new CreateOrderCommand());
        commands.put(CommandType.CHANGE_PASSWORD, new ChangePasswordCommand());
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