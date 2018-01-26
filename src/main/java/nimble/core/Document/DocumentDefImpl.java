package nimble.core.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul
 * This class represents the document structure
 * for a collection.
 */

public class DocumentDefImpl implements DocumentDef {

    private List<String> props = null;

    public DocumentDefImpl() {
        this.props = new ArrayList<>(100);
    }

    /**
     * @return List of document properties for this collection
     */
    @Override
    public List<String> getProps() {
        return props;
    }

    /**
     * @param props Add all the document properties
     * @return true if the document properties are set.
     */
    @Override
    public boolean setProps(List<String> props) {
        return this.props.addAll(props);
    }

    /**
     * @param prop Add a single document property for
     *             this collection
     * @return
     */
    @Override
    public boolean addProp(String prop) {
        return this.props.add(prop);
    }
}
