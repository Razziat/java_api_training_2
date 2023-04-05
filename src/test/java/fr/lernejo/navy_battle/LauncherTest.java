package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Launcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class LauncherTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @ParameterizedTest
    @ValueSource(strings = {"1023", "0", "-1", "65536", "9999999"})
    public void testInvalidPortNumber(String portNumber) {
        System.setOut(new PrintStream(output));
        String[] args = {portNumber};
        try {
            Launcher.main(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("Enter port number between 1024 and 65535:\n", output.toString());
    }

    @Test
    public void testNoArguments() {
        System.setOut(new PrintStream(output));
        String[] args = {};
        try {
            Launcher.main(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("No argument, program needs 1 or 2 arguments to be launched\n", output.toString());
    }

    @Test
    public void testServerOnly() throws IOException, InterruptedException {
        String[] args = {"5000"};
        Launcher.main(args);
        // Here you can add your assertions to check if the server is started correctly.
    }

    @Test
    public void testServerAndClient() throws IOException, InterruptedException {
        String[] args = {"5000", "http://localhost:8080"};
        Launcher.main(args);
        // Here you can add your assertions to check if the server and client are started correctly.
    }

}
