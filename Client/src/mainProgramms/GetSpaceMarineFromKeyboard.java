package mainProgramms;

import enums.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class GetSpaceMarineFromKeyboard {
    public static String getSpaceMarineFromKeyboard() {
        System.out.println("Внимание! Поля не могут содержать символ ';'");
        return getName() + ";" + getCoordinates() + ";" + getHealth() + ";" + getCategory() + ";" + getWeaponType() + ";" + getMeleeWeapon() + ";" + getChapter();
    }

    private static String getName() {
        String name = null;
        Scanner scanner = new Scanner(System.in);
        String curStr;
        System.out.println("Введите поле name (String not null):");
        while ((curStr = scanner.next()) != null) {
            try {
                if (!curStr.equals("") & !curStr.contains(";")) {
                    name = curStr;
                    break;
                } else {
                    System.out.println("Поле name (String not null) введено неверно, попробуйте еще раз:");
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Поле name (String not null) введено неверно, попробуйте еще раз:");
            }
        }
        return name;
    }

    private static String getCoordinates() {
        Double x;
        Long y;
        Scanner scanner = new Scanner(System.in);
        Double curDub;
        Long curLong;
        String s = null;
        boolean flag = false;
        System.out.println("Введите поле x (double <=432) для coordinates:");
        while (true) {
            try {
                if (!flag) {
                    flag = true;
                    s = scanner.next();
                }
                String line = s.replace('.', ',');
                Scanner doubleScanner = new Scanner(line);
                curDub = doubleScanner.nextDouble();
                if (curDub <= 432) {
                    x = curDub;
                    break;
                } else {
                    System.out.println("Поле x (double <=432) для coordinates введено неверно, попробуйте еще раз:");
                    flag = false;
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Поле x (double <=432) для coordinates введено неверно, попробуйте еще раз:");
                s = scanner.next();
            }
        }

        System.out.println("Введите поле y (long >-429) для coordinates:");
        while (true) {
            try {
                curLong = scanner.nextLong();
                if (curLong > -429) {
                    y = curLong;
                    break;
                } else {
                    System.out.println("Поле y (long >-429) для coordinates введено неверно, попробуйте еще раз:");
                }
            } catch (NoSuchElementException exception) {//два раза выводится сообщение об ошибке
                System.out.println("Поле y (long >-429) для coordinates введено неверно, попробуйте еще раз:");
                scanner.next();
            }
        }

        return x  + ";" + y;
    }

    private static int getHealth() {
        int health;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите поле health (int >0):");
        while (true) {
            try {
                int curVal = scanner.nextInt();
                if (curVal > 0) {
                    health = curVal;
                    break;
                } else {
                    System.out.println("Поле health (int >0) введено неверно, попробуйте еще раз:");
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Поле health (int >0) введено неверно, попробуйте еще раз:");
                scanner.next();
            }
        }
        return health;
    }

    private static AstartesCategory getCategory() {
        AstartesCategory category=null;
        Scanner scanner = new Scanner(System.in);
        String curStr;
        System.out.println("Введите поле category (SCOUT, INCEPTOR, CHAPLAIN):");
        while ((curStr = scanner.next()) != null) {
            try {
                category = AstartesCategory.valueOf(curStr);
                break;
            } catch (NoSuchElementException | IllegalArgumentException exception) {
                System.out.println("Поле category введено неверно, попробуйте еще раз:");
            }
        }
        return category;
    }

    private static Weapon getWeaponType() {
        Weapon weaponType = null;
        Scanner scanner = new Scanner(System.in);
        String curStr;
        System.out.println("Введите поле weaponType (BOLTGUN, HEAVY_BOLTGUN, BOLT_PISTOL, BOLT_RIFLE, COMBI_FLAMER):");
        while ((curStr = scanner.next()) != null) {
            try {
                weaponType = Weapon.valueOf(curStr);
                break;
            } catch (NoSuchElementException | IllegalArgumentException exception) {
                System.out.println("Поле weaponType введено неверно, попробуйте еще раз:");
            }
        }
        return weaponType;
    }

    private static MeleeWeapon getMeleeWeapon() {
        MeleeWeapon meleeWeapon = null;
        Scanner scanner = new Scanner(System.in);
        String curStr;
        System.out.println("Введите поле meleeWeapon (CHAIN_AXE, MANREAPER, LIGHTING_CLAW):");
        while ((curStr = scanner.next()) != null) {
            try {
                meleeWeapon = MeleeWeapon.valueOf(curStr);
                break;
            } catch (NoSuchElementException | IllegalArgumentException exception) {
                System.out.println("Поле meleeWeapon введено неверно, попробуйте еще раз:");
            }
        }
        return meleeWeapon;
    }

    private static String getChapter() {
        Scanner scanner = new Scanner(System.in);
        String chapterName = null;
        String parentLegion = null;
        Long marinesCount;
        String curStr;
        Long curLong;
        System.out.println("Введите поле name (String not null) для chapter:");
        while ((curStr = scanner.next()) != null) {
            try {
                if (!curStr.equals("") & !curStr.contains(";")) {
                    chapterName = curStr;
                    break;
                } else {
                    System.out.println("Поле name (String not null) для chapter введено неверно, попробуйте еще раз:");
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Поле name (String not null) для chapter введено неверно, попробуйте еще раз:");
                scanner.next();
            }
        }

        System.out.println("Введите поле parentLegion (String) для chapter:");
        while ((curStr = scanner.next()) != null) {
            try {
                if (!curStr.contains(";")) {
                    parentLegion = curStr;
                    break;
                } else {
                    System.out.println("Поле parentLegion (String) для chapter введено неверно, попробуйте еще раз:");
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Поле parentLegion (String) для chapter введено неверно, попробуйте еще раз:");
                scanner.next();
            }
        }

        System.out.println("Введите поле marinesCount (Long >0 <=1000) для chapter:");
        while (true) {
            try {
                curLong = scanner.nextLong();
                if (curLong > 0 & curLong <= 1000) {
                    marinesCount = curLong;
                    break;
                } else {
                    System.out.println("Поле marinesCount (Long >0 <=1000) для chapter введено неверно, попробуйте еще раз:");
                }
            } catch (NoSuchElementException exception) {
                System.out.println("Поле marinesCount (Long >0 <=1000) для chapter введено неверно, попробуйте еще раз:");
                scanner.next();
            }
        }
        return chapterName + ";" + parentLegion + ";" + marinesCount;
    }
}
