package channels;

import utility.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal implements Channel {
    @Override
    public String getName() {
        return "Terminal";
    }

    @Override
    public String input() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void output(String output) {
        System.out.println("Jarvis: " + output + "\n");
    }

    @Override
    public void initialize() {
        Logger.logDebug("Inizializzato correttamente il terminale.");
    }
}
