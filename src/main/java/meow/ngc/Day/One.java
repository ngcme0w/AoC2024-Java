package meow.ngc.Day;

import meow.ngc.InputHandler;

import java.util.*;
import java.util.stream.Collectors;

public class One extends InputHandler {
    private final String inputLocation = "src/inputs/One/input";

    private Map<Integer, Integer> mapInputs() {
        return Arrays.stream(getInputs(inputLocation)
                .split(System.lineSeparator()))
                .map(columnLine -> columnLine.split("\s+"))
                .collect(Collectors.toMap(
                        s -> Integer.parseInt(s[0]),
                        s-> Integer.parseInt(s[1])));

    }

    private Map<Integer, Integer> sortColumns(Map<Integer, Integer> unsortedMap) {
        List<Integer> givenKeys = new ArrayList<>();
        List<Integer> givenValues = new ArrayList<>();
        Map<Integer, Integer> sortedPairs = new TreeMap<>();

        for (int givenKey : unsortedMap.keySet())
            givenKeys.add(givenKey);

        for (int givenValue : unsortedMap.values())
            givenValues.add(givenValue);

        givenKeys.sort(Comparator.naturalOrder());
        givenValues.sort(Comparator.naturalOrder());

        for (int i = 0; i < givenValues.size(); i++)
            sortedPairs.put(givenKeys.get(i), givenValues.get(i));

        return sortedPairs;
    }

    private int calculateArraySum(List<Integer> arr) {
        return arr.stream().mapToInt(Integer::intValue).sum();
    }

    private int getSimilarityScore(Map<Integer, Integer> similarPairs) {
        List<Integer> resultsUnsummed = new ArrayList<>();
        for (int key : similarPairs.keySet())
            resultsUnsummed.add(key * similarPairs.get(key));

        return calculateArraySum(resultsUnsummed);
    }

    public int calculateSimilarity() {
        Map<Integer, Integer> pairsInstanceCounter = new TreeMap<>();

        for (int key : mapInputs().keySet()) {
            pairsInstanceCounter.putIfAbsent(key, 0);
            for (int value : mapInputs().values())
                if (key == value)
                    pairsInstanceCounter.computeIfPresent(key, (k, v) -> v + 1);
        }

        return getSimilarityScore(pairsInstanceCounter);
    }

    private int calculatePairDistance(int a, int b) {
        return Math.abs(a - b);
    }

    private ArrayList<Integer> returnAllPairDistances() {
        return sortColumns(mapInputs())
                .entrySet()
                .stream()
                .map(entry -> calculatePairDistance(entry.getKey(), entry.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int getSumOfArrayList(ArrayList<Integer> pairs) {
        return pairs.stream().mapToInt(Integer::intValue).sum();
    }

    public int getPairsDistanceSum() {
        return getSumOfArrayList(returnAllPairDistances());
    }
}
