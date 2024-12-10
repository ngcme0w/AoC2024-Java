package meow.ngc;

import meow.ngc.Day.One;
import meow.ngc.Day.Two;
import meow.ngc.Day.Three;

public class Main {
    public static void main(String[] args) {
        final One dayOne = new One();
        System.out.println("[day #1] answer: " + dayOne.getPairsDistanceSum());
        System.out.println("[day #1] part 2: " + dayOne.calculateSimilarity());

        final Two dayTwo = new Two();
        System.out.println("[day #2] answer: " + dayTwo.getNumberOfSafeReports());

        final Three dayThree = new Three();
        System.out.println("[day #3] answer: " + dayThree.runInputsCalculation());
        dayThree.toggleExtraInstructions();
        System.out.println("[day #3] part 2: " + dayThree.runInputsCalculation());

    }
}