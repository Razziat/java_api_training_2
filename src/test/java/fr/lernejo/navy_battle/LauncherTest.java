package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {
    @Test
    public void testInvalidPortNumber() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        String[] args = {"-1"};
        try {
            Launcher.main(args);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Enter port number between 1024 and 65535:\n", outContent.toString());
        outContent.reset();

        String[] args2 = {"65536"};
        try {
            Launcher.main(args2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Enter port number between 1024 and 65535:\n", outContent.toString());
        outContent.reset();
    }

    @Test
    public void testNoArguments() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        String[] args = {};
        try {
            Launcher.main(args);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals("No argument, program needs 1 or 2 arguments to be launched\n", outContent.toString());
    }
    
}
