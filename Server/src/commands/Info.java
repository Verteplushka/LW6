package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class Info extends Command {
    public static ReplyObj info(LinkedList<SpaceMarine> spaceMarines) {
        ReplyObj replyObj = new ReplyObj();
        replyObj.addString("Тип: LinkedList");
        replyObj.addString("Дата инициализации: " + java.time.ZonedDateTime.now());
        replyObj.addString("Количество элементов: " + spaceMarines.size());
        return replyObj;
    }
}
