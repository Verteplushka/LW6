package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class RemoveFirst extends Command {
    public static ReplyObj removeFirst(LinkedList<SpaceMarine> spaceMarines) {
        spaceMarines.removeFirst();
        return new ReplyObj("Первый элемент коллекции успешно удален");
    }
}
