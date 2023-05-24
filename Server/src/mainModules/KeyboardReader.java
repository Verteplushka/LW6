package mainModules;

import collectionClasses.SpaceMarine;
import mainProgramms.Save;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class KeyboardReader {
    public static void read(LinkedList<SpaceMarine> spaceMarines) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (reader.ready()) {
            String input = reader.readLine();
            switch(input){
                case "exit":
                    Save.save(spaceMarines);
                    System.out.println("Программа завершена");
                    System.exit(0);
                case "save":
                    Save.save(spaceMarines);
            }
        }
    }
}
