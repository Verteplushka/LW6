package mainProgramms;

import enums.MeleeWeapon;
import enums.Weapon;

import java.io.IOException;
import java.net.SocketException;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadCommandsFromKeyboard {
    public static void readCommandFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String firstPart = null;
        String line;
        try {
            while (true) {
                if (firstPart == null) {
                    System.out.println("Введите команду:");
                }
                line = scanner.next();
                try {
                    switch (line) {
                        case "help":
                            SendRequest.run(new RequestObj("help"));
                            break;
                        case "info":
                            SendRequest.run(new RequestObj("info"));
                            break;
                        case "show":
                            SendRequest.run(new RequestObj("show"));
                            break;
                        case "head":
                            SendRequest.run(new RequestObj("head"));
                            break;
                        case "add":
                            String addingSpaceMarine = GetSpaceMarineFromKeyboard.getSpaceMarineFromKeyboard();
                            SendRequest.run(new RequestObj("add", addingSpaceMarine));
                            break;
                        case "remove_greater":
                            String compSpaceMarine = GetSpaceMarineFromKeyboard.getSpaceMarineFromKeyboard();
                            SendRequest.run(new RequestObj("remove_greater", compSpaceMarine));
                            break;
                        case "print_ascending":
                            SendRequest.run(new RequestObj("print_ascending"));
                            break;
                        case "remove_first":
                            SendRequest.run(new RequestObj("remove_first"));
                            break;
                        case "clear":
                            SendRequest.run(new RequestObj("clear"));
                            break;
                        default:
                            int id;
                            if (firstPart != null) {
                                switch (firstPart) {
                                    case "update":
                                        id = Integer.parseInt(line);
                                        firstPart = null;
                                        SendRequest.run(new RequestObj("update", id));
                                        break;
                                    case "remove_by_id":
                                        id = Integer.parseInt(line);
                                        firstPart = null;
                                        SendRequest.run(new RequestObj("remove_by_id", id));
                                        break;
                                    case "execute_script":
                                        firstPart = null;
                                        ExecuteScript.executeScript(line);
                                        //SendRequest.run(new RequestObj("execute_script", line));
                                        break;
                                    case "remove_all_by_weapon_type":
                                        Weapon weaponType = Weapon.valueOf(line);
                                        firstPart = null;
                                        SendRequest.run(new RequestObj("remove_all_by_weapon_type", weaponType.toString()));
                                        break;
                                    case "count_by_melee_weapon":
                                        MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(line);
                                        firstPart = null;
                                        SendRequest.run(new RequestObj("count_by_melee_weapon", meleeWeapon.toString()));
                                        break;
                                }
                            } else if (line.equals("update") | line.equals("remove_by_id") | line.equals("execute_script") | line.equals("remove_all_by_weapon_type") | line.equals("count_by_melee_weapon")) {
                                firstPart = line;
                            } else {
                                firstPart = null;
                                throw new ReadException("Неверно введена команда");
                            }
                    }
                } catch (ReadException exception) {
                    System.out.println(exception.getMessage());
                    firstPart = null;
                } catch (NoSuchFileException exception) {
                    System.out.println("Ошибка чтения файла");
                }
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Не удалось получить ответ от сервера/Некорректно введена команда");
        } catch (SocketException exception) {
            System.out.println("Сервер отключен");
        } catch (IOException exception) {
            System.out.println("Ошибка подключения к серверу");
        }
    }
}
