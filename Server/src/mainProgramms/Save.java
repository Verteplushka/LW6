package mainProgramms;

import collectionClasses.SpaceMarine;
import commands.Command;

import java.io.*;
import java.util.LinkedList;

public class Save{
    public static void save(LinkedList<SpaceMarine> spaceMarines) throws IOException {
        OutputStream os = new FileOutputStream(System.getenv("File"));
        Writer out = new OutputStreamWriter(os);
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            int count = 0;
            for (String curStr : curSpaceMarine.getList()) {
                out.write(curStr);
                count++;
                if (count != 12) {
                    out.write(";");
                }

            }

            out.write("\n");
        }
        out.close();
        System.out.println("Коллекция успешно записана в файл");
    }
}
