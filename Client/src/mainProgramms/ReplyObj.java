package mainProgramms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;

public class ReplyObj {
    private static final Gson MyGson = new GsonBuilder().setPrettyPrinting().create();
    private final LinkedList<String> stringList = new LinkedList<String>();

    public ReplyObj() {
    }

    public ReplyObj(String inputString) {
        this.addString(inputString);
    }

    public void addString(String addingString) {
        this.stringList.add(addingString);
    }

    public LinkedList<String> getStringList() {
        return stringList;
    }

    public String getJson() {
        return MyGson.toJson(this).replace("\n", "");
    }

    @Override
    public String toString() {
        String outputString = "";
        for (int i = 0; i < this.stringList.size()-1; i++) {
            outputString = outputString + this.stringList.get(i) + "\n";
        }
        outputString = outputString + this.stringList.getLast();
        return outputString;
    }
}
