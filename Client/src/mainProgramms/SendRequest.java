package mainProgramms;

import java.io.*;
import java.net.*;
import java.nio.BufferOverflowException;
import java.util.NoSuchElementException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class SendRequest {
    private static final Gson MyGson = new GsonBuilder().setPrettyPrinting().create();
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void begin() {
        try {
            socket = new Socket("127.0.0.1", 8000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException exception) {
            System.out.println("Ошибка подключения к серверу");
            System.exit(0);
        }
    }

    public static void run(RequestObj sendingObj) throws IOException, NoSuchElementException, SocketException {
        try {
            String json = sendingObj.toString();

            out.println(json);

            char[] chars = new char[1024 * 1024];
            in.read(chars);
            ReplyObj replyObj = MyGson.fromJson(new String(java.util.Arrays.copyOfRange(chars, 0, java.lang.String.valueOf(chars).indexOf('\0'))), ReplyObj.class);
            System.out.println(replyObj);
        } catch (NullPointerException exception) {
            System.exit(0);
        }catch (IllegalArgumentException | JsonSyntaxException exception){
            System.out.println("Получено слишком большое сообщение");
            System.exit(0);
        }
        catch (BufferOverflowException exception) {
            System.out.println("Буфер переполнен");
        }
    }
}

