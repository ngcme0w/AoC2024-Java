package meow.ngc;

import meow.ngc.Day.One;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final One dayOne = new One();
        System.out.println("Day one answer: " + dayOne.getPairsDistanceSum());
        System.out.println("Total similarity score: " + dayOne.calculateSimilarity());
    }
}