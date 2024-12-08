package meow.ngc;

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
}
