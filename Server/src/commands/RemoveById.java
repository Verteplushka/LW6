package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReadException;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class RemoveById extends Command {
    public static ReplyObj removeById(LinkedList<SpaceMarine> spaceMarines, int id) throws ReadException {
        boolean flag = false;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (curSpaceMarine.getId() == id) {
                flag = true;
                spaceMarines.remove(curSpaceMarine);
                break;
            }
        }
        if (!flag) {
            throw new ReadException("В коллекции нет объекта с таким id");
        }
        return new ReplyObj("Объект успешно удален");
    }
}
