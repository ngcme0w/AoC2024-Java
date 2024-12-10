package meow.ngc;

import meow.ngc.Day.One;
import meow.ngc.Day.Two;
import meow.ngc.Day.Three;

public class Main {
    public static void main(String[] args) {
        final One dayOne = new One();
        System.out.println("Day one answer: " + dayOne.getPairsDistanceSum());
        System.out.println("Total similarity score: " + dayOne.calculateSimilarity());

        final Two dayTwo = new Two();
        System.out.println("Day two answer: " + dayTwo.getNumberOfSafeReports());

        final Three dayThree = new Three();
        System.out.println("Day three answer: " + dayThree.runInputsCalculation());
    }
}