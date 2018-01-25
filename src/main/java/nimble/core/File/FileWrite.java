package nimble.core.File;

import java.nio.*;

public interface FileWrite {
    boolean write(String path, ByteBuffer buf);
}
