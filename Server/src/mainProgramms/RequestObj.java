package mainProgramms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class RequestObj implements Serializable {
    private static final Gson MyGson = new GsonBuilder().setPrettyPrinting().create();
    private String commandName;
    private String attribute = null;
    private int id;
    public RequestObj(String commandName, String attribute, int id){
        this.commandName = commandName;
        this.attribute = attribute;
        this.id = id;
    }
    public RequestObj(String commandName, String attribute){
        this.commandName = commandName;
        this.attribute = attribute;
    }
    public RequestObj(String commandName){
        this.commandName = commandName;
    }
    public RequestObj(String commandName, int id){
        this.commandName = commandName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getCommandName() {
        return commandName;
    }

    @Override
    public String toString() {
        return MyGson.toJson(this).replace("\n", "");
    }
}
