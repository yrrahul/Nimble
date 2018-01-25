package nimble.core;

import nimble.core.File.*;

import java.nio.*;

import static spark.Spark.*;

public class Init {
    public static void main(String[] args) {
        get("/write", (req, res) -> {
            String test = "This is a test";
            String path = "/Users/rahul/niotest";
            FileWriteImpl init = new FileWriteImpl();
            return init.write(path, ByteBuffer.wrap(test.getBytes()));
        });
    }
}
