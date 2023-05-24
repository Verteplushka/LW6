package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class Clear extends Command {
    public static ReplyObj clear(LinkedList<SpaceMarine> spaceMarines) {
        spaceMarines.clear();
        return new ReplyObj("Коллекция успешно очищена");
    }
}
