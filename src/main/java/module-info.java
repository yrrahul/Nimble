module Nimble {
    requires java.base;
    requires java.logging;
    requires spark.core;
    requires websocket.api;

    exports nimble.core.Connection;
}