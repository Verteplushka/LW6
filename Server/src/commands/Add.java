package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReadException;
import mainProgramms.ReplyObj;
import mainProgramms.Sort;

import java.util.LinkedList;

public class Add extends Command {
    public static ReplyObj add(LinkedList<SpaceMarine> spaceMarines, SpaceMarine newSpaceMarine) throws ReadException {
        for (SpaceMarine compSpaceMarine : spaceMarines) {
            if (newSpaceMarine.getId().equals(compSpaceMarine.getId())) {
                throw new ReadException("Объект с таким id (" + newSpaceMarine.getId() + ") уже есть в коллекции");
            }
        }
        spaceMarines.add(newSpaceMarine);
        Sort.sort(spaceMarines);
        return new ReplyObj( "Объект успешно добавлен");
    }
}
