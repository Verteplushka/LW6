package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReadException;
import mainProgramms.ReplyObj;
import mainProgramms.Sort;

import java.util.LinkedList;

public class UpdateId extends Command {
    public static ReplyObj update(LinkedList<SpaceMarine> spaceMarines, SpaceMarine newSpaceMarine, int id) throws ReadException {

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

        if (newSpaceMarine != null) {
            newSpaceMarine.setId(id);
            spaceMarines.add(newSpaceMarine);
            Sort.sort(spaceMarines);
            return new ReplyObj("Объект успешно обновлен");
        } else {
            throw new ReadException("Неверно задан объект");
        }

    }
}
