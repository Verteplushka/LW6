package mainModules;

import mainProgramms.ReplyObj;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ReplyModule {
    public static void reply(ByteBuffer buffer, SocketChannel channel, ReplyObj replyObj) throws IOException {
        buffer.clear();
        buffer.put(replyObj.getJson().getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
    }
}
