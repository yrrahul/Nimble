package nimble.core.File;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class FileWriteImpl implements FileWrite {
    @Override
    public boolean write(String path, ByteBuffer buf) {
        ByteBuffer test = ByteBuffer.allocateDirect(100);
        test = buf;
        Set options = new HashSet();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);
        try (SeekableByteChannel chn = Files.newByteChannel(Paths.get(path), options)) {
            chn.write(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
