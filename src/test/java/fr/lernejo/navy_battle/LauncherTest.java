package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

public class LauncherTest {
    @Test
    void launch() {
        Launcher launch = new Launcher();
        String[] arg = new String[1];
        arg[0] = "9876";
        String[] args = new String[2];
        args[0] = "8795";
        args[1] = "http://localhost:9876";
        String[] argss = new String[3];
        argss[0] = "8795";
        argss[1] = "http://localhost:9876";
        argss[2] = "8795";

        try {
            Launcher.main(arg);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Launcher.main(args);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Launcher.main(argss);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
