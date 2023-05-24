package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;

import java.util.LinkedList;
import java.util.Optional;

public class Head extends Command {
    public static ReplyObj head(LinkedList<SpaceMarine> spaceMarines) {
        Optional<SpaceMarine> firstElement = spaceMarines.stream().findFirst();
        if(firstElement.isPresent()){
            return new ReplyObj(firstElement.get().toString());
        }
        return new ReplyObj("Коллекция пустая");
    }
}
