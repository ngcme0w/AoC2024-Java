package meow.ngc.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class One
{
    private final String inputLocation = "src/inputs/One/input";

    private String getInputs() throws IOException {
        return Files.readString(Paths.get(inputLocation));
    }

    private Map<Integer, Integer> mapInputs() throws IOException {
        return Arrays.stream(getInputs()
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

        for (int givenKey : unsortedMap.keySet()) {
            givenKeys.add(givenKey);
        }

        for (int givenValue : unsortedMap.values()) {
            givenValues.add(givenValue);
        }

        givenKeys.sort(Comparator.naturalOrder());
        givenValues.sort(Comparator.naturalOrder());

        for (int i = 0; i < givenValues.size(); i++) {
            sortedPairs.put(givenKeys.get(i), givenValues.get(i));
        }

        return sortedPairs;
    }

    private int calculatePairDistance(int a, int b) {
        return Math.abs(a - b);
    }

    private ArrayList<Integer> returnAllPairDistances() throws IOException {
        return sortColumns(mapInputs())
                .entrySet()
                .stream()
                .map(entry -> calculatePairDistance(entry.getKey(), entry.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int getSumOfArrayList(ArrayList<Integer> pairs) {
        return pairs.stream().mapToInt(Integer::intValue).sum();
    }

    public int getPairsDistanceSum() throws IOException {
        return getSumOfArrayList(returnAllPairDistances());
    }
}
