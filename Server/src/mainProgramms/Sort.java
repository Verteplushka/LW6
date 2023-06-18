package mainProgramms;

import collectionClasses.SpaceMarine;

import java.util.Collections;
import java.util.LinkedList;

public class Sort {
    public static LinkedList<SpaceMarine> sort(LinkedList<SpaceMarine> spaceMarines) {
        Collections.sort(spaceMarines);
        return spaceMarines;
    }
}
