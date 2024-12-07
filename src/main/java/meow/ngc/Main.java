package meow.ngc;

import meow.ngc.Day.One;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        One dayOne = new One();
        try {
            System.out.println("Day one answer: " + dayOne.getPairsDistanceSum());
            System.out.println("Total similarity score: " + dayOne.calculateSimilarity());
        } catch (IOException ioe) {
            System.err.println("IOException occurred.");
        }
    }
}