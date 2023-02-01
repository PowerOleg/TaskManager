package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerLogic {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String[] parse(String clientRequest) {
        ClassForParsing classForParsing = gson.fromJson(clientRequest, ClassForParsing.class);
        return new String[]{classForParsing.getCommandType(), classForParsing.getTask()};
    }

    public Command getCommandType(String commandType) {
        switch (commandType) {
            case "ADD":
                return new CommandAdd();
            case "REMOVE":
                return new CommandRemove();
            default:
                return null;
        }
    }
}
