package mainModules;


import java.io.IOException;
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
import java.util.Iterator;
import java.util.LinkedList;

public class MainModule {
    private static final int BUFFER_SIZE = Integer.MAX_VALUE/2;
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
                            int bytesRead = clientSocketChannel.read(buffer);

                            if (bytesRead > 0) {
                                RequestObj recievedObj = RequestModule.getRequest(buffer, clientSocketChannel);
                                ReplyObj replyObj = ExecuteRequestObj.executeCommand(spaceMarines, recievedObj);
                                ReplyModule.reply(buffer, clientSocketChannel, replyObj);
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
        }
    }

    public static ByteBuffer getBuffer() {
        return buffer;
    }

    public static Selector getSelector() {
        return selector;
    }

    public static ServerSocketChannel getServerSocket() {
        return serverSocket;
    }

    public static int getPortName() {
        return PORT_NAME;
    }
}