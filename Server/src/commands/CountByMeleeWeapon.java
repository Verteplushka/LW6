package commands;

import collectionClasses.MeleeWeapon;
import collectionClasses.SpaceMarine;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class CountByMeleeWeapon extends Command {
    public static ReplyObj countByMeleeWeapon(LinkedList<SpaceMarine> spaceMarines, MeleeWeapon comparableMeleeType) {
        int count = 0;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (curSpaceMarine.getMeleeWeapon() == comparableMeleeType) {
                count++;
            }
        }
        return new ReplyObj("Найдено объектов: " + count);
    }
}
