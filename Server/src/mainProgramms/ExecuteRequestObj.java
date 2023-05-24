package mainProgramms;

import collectionClasses.MeleeWeapon;
import collectionClasses.SpaceMarine;
import collectionClasses.Weapon;
import commands.*;

import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExecuteRequestObj {
    public static ReplyObj executeCommand(LinkedList<SpaceMarine> spaceMarines, RequestObj recievedObj) {
        String command = recievedObj.getCommandName();
        ReplyObj prevReplyObj = new ReplyObj();
        try {
            switch (command) {
                case "help":
                    return Help.help();
                case "info":
                    return Info.info(spaceMarines);
                case "show":
                    return Show.show(spaceMarines);
                case "head":
                    return Head.head(spaceMarines);
                case "add":
                    SpaceMarine addingSpaceMarine = GetSpaceMarineFromUser.get(new Scanner(recievedObj.getAttribute()));
                    return Add.add(spaceMarines, addingSpaceMarine);
                case "remove_greater":
                    return RemoveGreater.removeGreater(spaceMarines, GetSpaceMarineFromFile.getSpaceMarineFromFile(new Scanner(recievedObj.getAttribute())));
                case "print_ascending":
                    return PrintAscending.printAscending(spaceMarines);
                case "remove_first":
                    return RemoveFirst.removeFirst(spaceMarines);
                case "clear":
                    return Clear.clear(spaceMarines);
                case "update":
                    return UpdateId.update(spaceMarines, GetSpaceMarineFromFile.getSpaceMarineFromFile(new Scanner(recievedObj.getAttribute())), recievedObj.getId());
                case "remove_by_id":
                    return RemoveById.removeById(spaceMarines, recievedObj.getId());
                case "remove_all_by_weapon_type":
                    Weapon weaponType = Weapon.valueOf(recievedObj.getAttribute());
                    return RemoveAllByWeaponType.removeAllByWeaponType(spaceMarines, weaponType);
                case "count_by_melee_weapon":
                    MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(recievedObj.getAttribute());
                    return CountByMeleeWeapon.countByMeleeWeapon(spaceMarines, meleeWeapon);
            }
        } catch (ReadException exception) {
            prevReplyObj.addString(exception.getMessage());
            return prevReplyObj;
        } catch (DateTimeParseException exception) {
            prevReplyObj.addString("Неверное поле creationDate");
            return prevReplyObj;
        } catch (java.lang.IndexOutOfBoundsException exception) {
            prevReplyObj.addString("В коллекции нет объекта с таким индексом");
            return prevReplyObj;
        } catch (IllegalArgumentException exception) {
            prevReplyObj.addString("Неверно введено поле/команда");
            return prevReplyObj;
        } catch (NullPointerException exception) {
            prevReplyObj.addString("Ошибка");
            return prevReplyObj;
        } catch (NoSuchElementException exception) {
            prevReplyObj.addString("Ошибка поиска элемента/Неправильно задан объект коллекции");
            return prevReplyObj;
        }
        prevReplyObj.addString("Неверная команда на сервере??");
        return prevReplyObj;
    }
}
