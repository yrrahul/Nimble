package nimble.core.Connection;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import nimble.core.Document.*;


import java.io.IOException;
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
    public void addDocumentMeta(Session session, String doc) {
        DocumentColl docColl = DocumentColl.getInstance();
        DocumentDefImpl newDoc = new DocumentDefImpl();
        newDoc.addProp(doc);
        docColl.addDocument(newDoc);
        try {
            session.getRemote().sendString("message received");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
