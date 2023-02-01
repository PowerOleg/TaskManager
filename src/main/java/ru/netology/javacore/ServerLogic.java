package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerLogic {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    { "type": "ADD", "task": "Купить пирожок" }

    public String[] parse(String clientRequest) {
        ClassForParsing classForParsing = gson.fromJson(clientRequest, ClassForParsing.class);
        String[] commandTypeAndTask = {classForParsing.getType(), classForParsing.getTask()};

    }

    public Command getCommandType(String type) {



        return new CommandAdd();
    }
}
