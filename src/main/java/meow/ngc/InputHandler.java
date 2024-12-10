package meow.ngc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputHandler {
    public String getInputs(String inputLocation) {
        try {
            return Files.readString(Paths.get(inputLocation));
        } catch (IOException ioe) {
            System.err.println("Unable to read inputs.");
            System.exit(1);
        }

        return "";
    }

    public BufferedReader getBufferedInputs(String inputLocation) {
        try {
            return new BufferedReader(new FileReader(inputLocation));
        } catch (IOException ioe) {
            System.err.println("Unable to read inputs.");
            System.exit(1);
        }

        return null;
    }
}
