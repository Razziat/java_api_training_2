package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {
    @Test
    void main_withInvalidPort_shouldPrintErrorMessage() throws IOException, InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        try {
            Launcher.main(new String[]{"123"});
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String expectedOutput = "Enter port number between 1024 and 65535:\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void main_withNoArgs_shouldPrintErrorMessage() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        try {
            Launcher.main(new String[]{});
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String expectedOutput = "No argument, program needs 1 or 2 arguments to be launched\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void main_withValidPort_shouldCreateServer() throws IOException {
        try {
            Launcher.main(new String[]{"8080"});
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Here you can add assertions to check that the server is actually created and running properly
    }

}
