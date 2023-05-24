package mainProgramms;

import enums.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GetSpaceMarineFromFileEnter {
    public static String getSpaceMarineFromFileEnter(Scanner scanner) {
        String name;
        int health;
        AstartesCategory category;
        Weapon weaponType;
        MeleeWeapon meleeWeapon;
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
                                        return name + ";" + x + ";" + y + ";" + health + ";" + category + ";" + weaponType + ";" + meleeWeapon + ";" + chapterName + ";" + parentLegion + ";" + marinesCount;
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