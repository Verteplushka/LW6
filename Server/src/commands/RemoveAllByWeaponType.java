package commands;

import collectionClasses.SpaceMarine;
import collectionClasses.Weapon;
import mainProgramms.ReplyObj;

import java.util.LinkedList;

public class RemoveAllByWeaponType extends Command {
    public static ReplyObj removeAllByWeaponType(LinkedList<SpaceMarine> spaceMarines, Weapon comparableWeaponType) {
        int count = 0;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (curSpaceMarine.getWeaponType() == comparableWeaponType) {
                spaceMarines.remove(curSpaceMarine);
                count++;
            }
        }
        return new ReplyObj("Успешно удалено объектов: " + count);
    }
}
