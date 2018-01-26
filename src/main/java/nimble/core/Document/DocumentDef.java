package nimble.core.Document;

import java.util.List;

public interface DocumentDef {

    List<String> getProps();

    boolean setProps(List<String> props);

    boolean addProp(String prop);




}
