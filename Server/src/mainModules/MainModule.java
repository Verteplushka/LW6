package mainModules;


import java.io.*;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;

import collectionClasses.*;
import com.google.gson.JsonSyntaxException;
import mainProgramms.ExecuteRequestObj;
import mainProgramms.FileReader;
import mainProgramms.ReplyObj;
import mainProgramms.RequestObj;

import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MainModule {
    private static final int BUFFER_SIZE = 10000;
    private static final int PORT_NAME = 8000;
    private static Selector selector;
    private static ServerSocketChannel serverSocket;
    private static ByteBuffer buffer;

    public static void run() {
        String fileName = System.getenv("File");
        LinkedList<SpaceMarine> spaceMarines = FileReader.readFile(fileName);
        try {

            selector = Selector.open();
            serverSocket = ServerSocketChannel.open();
            serverSocket.configureBlocking(false);
            buffer = ByteBuffer.allocate(BUFFER_SIZE);

            serverSocket.bind(new InetSocketAddress(PORT_NAME));
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);



            while (true) {
                KeyboardReader.read(spaceMarines);

                if (selector.selectNow() == 0) {
                    continue;
                }

                Iterator<SelectionKey> keyIterator = ConnectionModule.connect(selector);
                ByteBuffer tempBuffer = ByteBuffer.allocate(BUFFER_SIZE * 5);
                //tempBuffer.put(new byte[]{-84, -19, 0, 5});

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (!key.isValid()) {
                        continue;
                    }

                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel clientSocketChannel = serverSocketChannel.accept();

                        clientSocketChannel.configureBlocking(false);

                        clientSocketChannel.register(selector, SelectionKey.OP_READ);

                        System.out.println("Подключился клиент: " + clientSocketChannel.getRemoteAddress());
                    } else if (key.isReadable()) {
                        SocketChannel clientSocketChannel = (SocketChannel) key.channel();

                        try {
                            //buffer = ByteBuffer.allocate(BUFFER_SIZE);
                            buffer.clear();
                            buffer.put(new byte[BUFFER_SIZE]);
                            buffer.clear();
                            int bytesRead = clientSocketChannel.read(buffer);
                            if (bytesRead > 0) {
                                buffer.flip();
                                byte[] bytes = new byte[buffer.remaining()];
                                buffer.get(bytes);
                                ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer.array());
                                ObjectInputStream objectStream = new ObjectInputStream(byteStream);
                                try {
                                    RequestObj recievedObj = (RequestObj) objectStream.readObject();
                                    System.out.println("Получено сообщение от клиента " + clientSocketChannel.getRemoteAddress() + ": " + recievedObj);


                                    ReplyObj replyObj = ExecuteRequestObj.executeCommand(spaceMarines, recievedObj);
                                    ByteArrayOutputStream byteStream2 = new ByteArrayOutputStream();
                                    ObjectOutputStream objectStream2 = new ObjectOutputStream(byteStream2);
                                    objectStream2.writeObject(replyObj);
                                    objectStream2.flush();

                                    ByteBuffer writingBuffer = ByteBuffer.wrap(byteStream2.toByteArray());

                                    clientSocketChannel.write(writingBuffer);

                                    System.out.println("Отправлено сообщение клиенту " + clientSocketChannel.getRemoteAddress() + ": " + replyObj.getJson());
                                    //ReplyModule.reply(buffer, clientSocketChannel, replyObj);
                                }catch(StreamCorruptedException e){
                                    e.printStackTrace();

                                }
                            } else if (bytesRead < 0) {
                                System.out.println("Клиент " + clientSocketChannel.getRemoteAddress() + " отключился");
                                key.cancel();
                                clientSocketChannel.close();
                            }
                        } catch (SocketException exception) {
                            System.out.println("Клиент " + clientSocketChannel.getRemoteAddress() + " отключился");
                            key.cancel();
                            clientSocketChannel.close();
                            break;
                        }
                    }
                }

            }
        } catch (IOException exception) {
            System.out.println("Проблемы с соединением");
        } catch (JsonSyntaxException | NullPointerException exception) {
            System.out.println("Передан некорректный запрос");
        } catch (ClassNotFoundException exception) {
            System.out.println("Передан объект некорректного класса");
        }
    }
}