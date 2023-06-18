package mainProgramms;

import java.io.*;
import java.net.*;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.NoSuchElementException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class SendRequest {
    private static final Gson MyGson = new GsonBuilder().setPrettyPrinting().create();
    private static Socket socket;
    // private static BufferedReader in;
    // private static PrintWriter out;

    private static ObjectInputStream inputStream;
    private static ObjectOutputStream outputStream;
    private static boolean flag = true;
    private static SocketChannel clientChannel;
    private static ByteBuffer buffer;
    private static final int BUFFER_SIZE = 10000;

    public static void begin() {
        try {
//            socket = new Socket("localhost", 8000);
//            outputStream = new ObjectOutputStream(socket.getOutputStream());
            clientChannel = SocketChannel.open();
            clientChannel.connect(new InetSocketAddress("localhost", 8000));
            buffer = ByteBuffer.allocate(BUFFER_SIZE);

            while (!clientChannel.finishConnect()) {
            }
            System.out.println("Соединение с сервером установлено.");


        } catch (IOException exception) {
            System.out.println("Ошибка подключения к серверу");
            System.exit(0);
        }
    }

    public static void run(RequestObj sendingObj) throws IOException, NoSuchElementException, SocketException {
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(sendingObj);
            objectStream.flush();
            ByteBuffer writingBuffer = ByteBuffer.wrap(byteStream.toByteArray());
            clientChannel.write(writingBuffer);

            buffer.clear();
            clientChannel.read(buffer);
            buffer.flip();
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            ByteArrayInputStream byteStream2 = new ByteArrayInputStream(buffer.array());
            ObjectInputStream objectStream2 = new ObjectInputStream(byteStream2);
            ReplyObj replyObj = (ReplyObj) objectStream2.readObject();


//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(sendingObj);
//            objectOutputStream.flush();
//            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
//            outputStream.writeObject(sendingObj);
//            outputStream.flush();
//            if(flag) {
//                flag = false;
//                inputStream = new ObjectInputStream(socket.getInputStream());
//            }
//            ReplyObj replyObj = (ReplyObj) inputStream.readObject();

            if (replyObj == null) {
                System.out.println("Не удалось получить ответ от сервера");
                System.exit(0);
            }
            System.out.println(replyObj);
        } catch (NullPointerException exception) {
            System.exit(0);
        } catch (IllegalArgumentException | JsonSyntaxException exception) {
            System.out.println("Получено слишком большое сообщение");
            System.exit(0);
        } catch (BufferOverflowException exception) {
            System.out.println("Буфер переполнен");
        } catch (ClassNotFoundException exception) {
            System.out.println("Передан объект некорректного класса");
        }
    }
}

