package mainProgramms;

import collectionClasses.*;

import java.util.Scanner;

public class GetSpaceMarineFromUser {
    public static SpaceMarine get(Scanner inputScanner){
        SpaceMarine spaceMarine;
        String name;
        Coordinates coordinates;
        int health;
        AstartesCategory category;
        Weapon weaponType;
        MeleeWeapon meleeWeapon;
        Chapter chapter;

        Double x;
        Long y;
        String chapterName;
        String parentLegion;
        Long marinesCount;
        Scanner scanner = inputScanner.useDelimiter(";");

        name = scanner.next();
        String line = scanner.next().replace('.', ',');
        Scanner doubleScanner = new Scanner(line);
        x = doubleScanner.nextDouble();
        y = scanner.nextLong();
        coordinates = new Coordinates(x, y);
        health = scanner.nextInt();
        category = AstartesCategory.valueOf(scanner.next());
        weaponType = Weapon.valueOf(scanner.next());
        meleeWeapon = MeleeWeapon.valueOf(scanner.next());
        chapterName = scanner.next();
        parentLegion = scanner.next();
        marinesCount = scanner.nextLong();
        chapter = new Chapter(chapterName, parentLegion, marinesCount);
        return new SpaceMarine(name, coordinates, health, category, weaponType, meleeWeapon, chapter);

    }
}
