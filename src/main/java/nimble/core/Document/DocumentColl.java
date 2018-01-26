package nimble.core.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul
 * Singleton Class which will have all the document
 * metadata
 */
public class DocumentColl {
    private static DocumentColl DOCUMENT = new DocumentColl();
    private List<DocumentDefImpl> documentDefs = null;

    /**
     * @return Singleton object instance
     */
    public synchronized static DocumentColl getInstance() {
        return DOCUMENT;
    }

    /**
     * @param doc add document definition to the list
     */
    public synchronized void addDocument(DocumentDefImpl doc) {
        documentDefs.add(doc);
    }

    private DocumentColl() {
        documentDefs = new ArrayList<>(100);
    }
}
