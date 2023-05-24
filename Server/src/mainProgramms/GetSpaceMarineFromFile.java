package mainProgramms;

import collectionClasses.*;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class GetSpaceMarineFromFile {
    public static SpaceMarine getSpaceMarineFromFile(Scanner inputScanner) {
        SpaceMarine spaceMarine;
        Integer id;
        String name;
        Coordinates coordinates;
        java.time.ZonedDateTime creationData;
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
        while (scanner.hasNext()) {
            if ((id = scanner.nextInt()) > 0) {
                if (!(name = scanner.next()).equals("")) {
                    String line1 = scanner.next().replace('.', ',');
                    Scanner doubleScanner1 = new Scanner(line1);
                    if ((x = doubleScanner1.nextDouble()) <= 432) {
                        if ((y = scanner.nextLong()) > -429) {
                            coordinates = new Coordinates(x, y);
                            creationData = ZonedDateTime.parse(scanner.next());
                            if ((health = scanner.nextInt()) > 0) {
                                category = AstartesCategory.valueOf(scanner.next());
                                weaponType = Weapon.valueOf(scanner.next());
                                meleeWeapon = MeleeWeapon.valueOf(scanner.next());
                                if (!(chapterName = scanner.next()).equals("")) {
                                    parentLegion = scanner.next();
                                    if ((marinesCount = scanner.nextLong()) > 0 && marinesCount <= 1000) {
                                        chapter = new Chapter(chapterName, parentLegion, marinesCount);
                                        spaceMarine = (new SpaceMarine(id, name, coordinates, creationData, health, category, weaponType, meleeWeapon, chapter));
                                        return spaceMarine;
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }
        return null;
    }
}
