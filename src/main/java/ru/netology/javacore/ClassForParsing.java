package ru.netology.javacore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassForParsing {
    @SerializedName("type")
    @Expose
    private String commandType;
    private String task;

    public ClassForParsing() {
    }

    public String getCommandType() {
        return commandType;
    }

    public String getTask() {
        return task;
    }
}
