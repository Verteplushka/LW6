package mainProgramms;

import collectionClasses.*;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GetSpaceMarineFromFileEnter {
    public static SpaceMarine getSpaceMarineFromFileEnter(Scanner scanner) {

        SpaceMarine spaceMarine;
        Integer id;
        String name;
        Coordinates coordinates;
        ZonedDateTime creationData;
        int health;
        AstartesCategory category;
        Weapon weaponType;
        MeleeWeapon meleeWeapon;
        Chapter chapter;
        try {
            while (scanner.hasNext()) {
                if (!(name = scanner.next()).equals("")) {
                    Double x;
                    Long y;
                    String line1 = scanner.next().replace('.', ',');
                    Scanner doubleScanner = new Scanner(line1);
                    if ((x = doubleScanner.nextDouble()) <= 432) {
                        String line2 = scanner.next().replace('.', ',');
                        Scanner doubleScanner2 = new Scanner(line2);
                        if ((y = doubleScanner2.nextLong()) > -429) {
                            coordinates = new Coordinates(x, y);
                            if ((health = scanner.nextInt()) > 0) {
                                category = AstartesCategory.valueOf(scanner.next());
                                weaponType = Weapon.valueOf(scanner.next());
                                meleeWeapon = MeleeWeapon.valueOf(scanner.next());
                                String chapterName;
                                String parentLegion;
                                Long marinesCount;
                                if (!(chapterName = scanner.next()).equals("")) {
                                    parentLegion = scanner.next();
                                    if ((marinesCount = scanner.nextLong()) > 0 && marinesCount <= 1000) {
                                        chapter = new Chapter(chapterName, parentLegion, marinesCount);
                                        spaceMarine = (new SpaceMarine(name, coordinates, health, category, weaponType, meleeWeapon, chapter));
                                        return spaceMarine;
                                    }
                                }
                            }
                        }
                    }

                }

            }
        } catch (NoSuchElementException | IllegalArgumentException |
                 java.time.format.DateTimeParseException exception) {
        }
        return null;
    }
}