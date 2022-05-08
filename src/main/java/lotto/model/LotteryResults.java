package lotto.model;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lotto.enums.Grade;

public final class LotteryResults {

    private static final int START_COUNT = 0;
    private static final int INCREASE_VALUE = 1;

    private static final Map<Grade, Integer> gradeMap = new EnumMap<>(Grade.class);

    private LotteryResults() {
    }

    static {
        for (Grade value : Grade.values()) {
            gradeMap.put(value, START_COUNT);
        }
    }


    public static void increase(Grade grade) {
        int originValue = gradeMap.get(grade);
        gradeMap.put(grade, originValue + INCREASE_VALUE);
    }

    public static List<LotteryResult> getLotteryResult() {
        List<LotteryResult> lotteryResults = new ArrayList<>();
        for (Entry<Grade, Integer> gradeIntegerEntry : array()) {
            lotteryResults.add(
                    new LotteryResult(gradeIntegerEntry.getKey(), gradeIntegerEntry.getValue()));
        }

        return lotteryResults;
    }

    public static double yield(long money) {
        return (double) sum() / money;
    }

    private static long sum() {
        return array()
                .stream()
                .mapToLong(grade -> grade.getKey().getAwardPrice() * grade.getValue())
                .sum();
    }

    private static Set<Entry<Grade, Integer>> array() {
        return gradeMap
                .entrySet()
                .stream()
                .filter(g -> g.getKey() != Grade.NONE)
                .sorted((c, o) -> o.getKey().getExpectNumber() - (c.getKey().getExpectNumber()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Map<Grade, Integer> result() {
        return gradeMap;
    }
}
