package meow.ngc.Day;

import meow.ngc.InputHandler;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Three extends InputHandler {
    private final String inputLocation = "src/inputs/Three/input";
    private boolean withExtraInstructions = false;

    public void toggleExtraInstructions() {
        withExtraInstructions = !withExtraInstructions;
    }

    private int calculateMultiplesSum() {
        int product = 0, modifiedProduct = 0;

        boolean continueMatching = true;

        if (!getInputs(inputLocation).isBlank()) {
            final BufferedReader inputs = getBufferedInputs(inputLocation);
            Pattern desiredExpr;

            if (!withExtraInstructions)
                desiredExpr = Pattern.compile("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)");
            else
                desiredExpr = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");
            
            for (String line: inputs.lines().toList()) {
                final Matcher match = desiredExpr.matcher(line);
                while (match.find()) {
                    if (match.group(0).equals("do()")) {
                        continueMatching = true;
                    } else if (match.group(0).equals("don't()")) {
                        continueMatching = false;
                    } else {
                        product += Integer.parseInt(match.group(1)) * Integer.parseInt(match.group(2));
                        if(continueMatching)
                            modifiedProduct += Integer.parseInt(match.group(1)) * Integer.parseInt(match.group(2));
                    }
                }
            }
        }

        return withExtraInstructions ? modifiedProduct : product;
    }

    public final int runInputsCalculation() {
        return calculateMultiplesSum();
    }
}