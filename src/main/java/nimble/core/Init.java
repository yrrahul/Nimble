package nimble.core;

import static spark.Spark.*;

public class Init {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
