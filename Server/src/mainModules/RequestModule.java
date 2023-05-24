package mainModules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mainProgramms.RequestObj;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class RequestModule {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static RequestObj getRequest(ByteBuffer buffer, SocketChannel channel) throws IOException {
        buffer.flip();
        channel.read(buffer);
        return GSON.fromJson(new String(buffer.array(), buffer.position(), buffer.remaining()), RequestObj.class);

    }
}
