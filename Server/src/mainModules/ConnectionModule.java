package mainModules;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class ConnectionModule {
    public static Iterator<SelectionKey> connect(Selector selector){
        return selector.selectedKeys().iterator();
    }
}
