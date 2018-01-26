package nimble.core.Connection;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import nimble.core.Document.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@WebSocket
public class DocInitImpl implements DocInit {

    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnWebSocketConnect
    public void connected(Session session) {
        sessions.add(session);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void addDocumentMeta(Session session, byte[] buf, int offset, int buflen) {
        //DocumentColl docColl = DocumentColl.getInstance();
        // DocumentDefImpl newDoc = new DocumentDefImpl();
        //String doc = byt.toString();
        // newDoc.addProp(doc);
        //newDoc.setProps(doc);
        //docColl.addDocument(newDoc);
        try {
            session.getRemote().sendString("message received");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
