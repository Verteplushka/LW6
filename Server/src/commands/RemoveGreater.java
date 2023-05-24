package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;
import mainProgramms.Sort;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class RemoveGreater extends Command {
    public static ReplyObj removeGreater(LinkedList<SpaceMarine> spaceMarines, SpaceMarine comparableSpaceMarine) {
//        int count = 0;
//        for (SpaceMarine curSpaceMarine : spaceMarines) {
//            if (comparableSpaceMarine.compareTo(curSpaceMarine) < 0) {
//                spaceMarines.remove(curSpaceMarine);
//                count++;
//            }
//        }

        int prevSize = spaceMarines.size();
        spaceMarines.removeIf(spaceMarine -> spaceMarine.compareTo(comparableSpaceMarine) > 0);

        Sort.sort(spaceMarines);
        return new ReplyObj("Успешно удалено объектов: " + (prevSize - spaceMarines.size()));
    }
}
