package meow.ngc.Day;

import meow.ngc.InputHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Three extends InputHandler {
    private final String inputLocation = "src/inputs/Three/input";

    private int calculateMultiplesSum() {
        int product = 0;

        if (!getInputs(inputLocation).isBlank()) {
            final String inputs = getInputs(inputLocation);
            final Pattern desiredExpr = Pattern.compile("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)");

            Matcher m = desiredExpr.matcher(inputs);
            while (m.find()) {
                System.out.println(Integer.valueOf(m.group(1)) + " + " + Integer.valueOf(m.group(2)));
                product += (Integer.valueOf(m.group(1)) * Integer.valueOf(m.group(2)));
            }
        }

        return product;
    }

    public final int runInputsCalculation() {
        return calculateMultiplesSum();
    }
}
