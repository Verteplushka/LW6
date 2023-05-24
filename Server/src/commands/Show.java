package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class Show extends Command {
    public static ReplyObj show(LinkedList<SpaceMarine> spaceMarines) {
        if (spaceMarines.size() == 0) {
            return new ReplyObj("Коллекция пустая");
        }
        ReplyObj replyObj = new ReplyObj();

        spaceMarines.stream().map(SpaceMarine :: toString).forEach(replyObj::addString);
        return replyObj;
    }
}
