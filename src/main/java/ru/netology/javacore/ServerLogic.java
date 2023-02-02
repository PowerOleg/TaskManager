package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerLogic {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ClassForParsing parse(String clientRequest) {
        return gson.fromJson(clientRequest, ClassForParsing.class);
    }

    public Command getCommandType(String commandType) {
        switch (commandType) {
            case "ADD":
                return new CommandAdd();
            case "REMOVE":
                return new CommandRemove();
            case "RESTORE":
                return new CommandRestore();
            default:
                return null;
        }
    }
}
