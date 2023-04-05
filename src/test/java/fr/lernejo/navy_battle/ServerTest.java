package fr.lernejo.navy_battle;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.HttpServer;

class ServerTest {
    private Server server;
    private HttpServer httpServer;

    @Before
    public void setUp() throws Exception {
        server = new Server(8080);
        httpServer = server.initServer();
    }

    @After
    public void tearDown() throws Exception {
        httpServer.stop(0);
    }

    @Test
    public void testInitServer() {
        assertNotNull("Failed to initialize HttpServer", httpServer);
    }

    @Test
    public void testRunServer() throws IOException {
        assertTrue("Failed to start server", server.runServer());

        URL pingUrl = new URL("http://localhost:8080/ping");
        HttpURLConnection pingConn = (HttpURLConnection) pingUrl.openConnection();
        pingConn.setRequestMethod("GET");
        pingConn.connect();
        int pingResponseCode = pingConn.getResponseCode();
        assertEquals("Unexpected ping response code", 200, pingResponseCode);

        URL getSeaUrl = new URL("http://localhost:8080/api/game/start");
        HttpURLConnection getSeaConn = (HttpURLConnection) getSeaUrl.openConnection();
        getSeaConn.setRequestMethod("GET");
        getSeaConn.connect();
        int getSeaResponseCode = getSeaConn.getResponseCode();
        assertEquals("Unexpected getSea response code", 200, getSeaResponseCode);
    }


}
