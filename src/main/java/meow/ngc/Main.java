package meow.ngc;

import meow.ngc.Day.One;
import meow.ngc.Day.Two;

public class Main {
    public static void main(String[] args) {
        final One dayOne = new One();
        System.out.println("Day one answer: " + dayOne.getPairsDistanceSum());
        System.out.println("Total similarity score: " + dayOne.calculateSimilarity());
        System.out.println();

        final Two dayTwo = new Two();
        System.out.println("Day two Answer: " + dayTwo.getNumberOfSafeReports());
        System.out.println();
    }
}