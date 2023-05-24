package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;
import mainProgramms.Sort;

import java.util.LinkedList;

public class PrintAscending extends Command {
    public static ReplyObj printAscending(LinkedList<SpaceMarine> spaceMarines) {
        Sort.sort(spaceMarines);
        return Show.show(spaceMarines);
    }
}
