package mainProgramms;

import collectionClasses.SpaceMarine;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {
    public static LinkedList<SpaceMarine> readFile(String fileName) {
        LinkedList<SpaceMarine> spaceMarines = new LinkedList<>();
        try {
            Path path = Paths.get(fileName);

            Scanner scanner = new Scanner(path);
            while (scanner.hasNext()) {
                SpaceMarine curSpaceMarine = GetSpaceMarineFromFile.getSpaceMarineFromFile(new Scanner(scanner.next()));
                if (curSpaceMarine != null) {
                    for (SpaceMarine compSpaceMarine : spaceMarines) {
                        if (curSpaceMarine.getId().equals(compSpaceMarine.getId())) {
                            throw new ReadException("В файле нарушена уникальность id, некоторые объекты коллекции не загружены");
                        }
                    }
                    spaceMarines.add(curSpaceMarine);
                }
            }
            if (spaceMarines.size() == 0) {
                throw new NoSuchElementException();
            }
        } catch (ReadException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException | NullPointerException | IllegalArgumentException |
                 java.time.format.DateTimeParseException exception) {
            System.out.println("Ошибка чтения исходного файла, часть объектов не удалось считать");
        } catch (NoSuchElementException exception) {
            System.out.println("Неверно заданы поля объекта, часть объектов не удалось считать");
        }
        Sort.sort(spaceMarines);
        return spaceMarines;
    }

}
