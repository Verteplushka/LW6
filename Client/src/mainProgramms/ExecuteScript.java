package mainProgramms;


import java.io.IOException;
import java.util.LinkedList;

public class ExecuteScript {
    private static int recursionCounter = 0;

    public static void executeScript(String fileName) throws IOException, ReadException {
        if (getRecursionCounter() > 10) {
            resetRecursionCounter();
            throw new ReadException("Недопустимая глубина рекурсии");
        }
        incRecursionCounter();
        ReadCommadsFromFile.readCommandsFromFile(fileName);
    }

    private static int getRecursionCounter() {
        return recursionCounter;
    }

    private static void incRecursionCounter() {
        ExecuteScript.recursionCounter++;
    }

    public static void resetRecursionCounter() {
        ExecuteScript.recursionCounter = 0;
    }
}
