package com.exercise.active_edge.exercise1;

import java.util.HashSet;
import java.util.Set;

public class SmallestNonOccurringInteger {

    private static int SMALLEST_INTEGER = 1;

    public static int findSmallestNonOccurringInteger(int[] array) {
        Set<Integer> setOfPositiveInteger = new HashSet<>();

        for (int num : array) {
            if (num > 0) {
                setOfPositiveInteger.add(num);
            }
        }

        while (setOfPositiveInteger.contains(SMALLEST_INTEGER)) {
            SMALLEST_INTEGER++;
        }

        return SMALLEST_INTEGER;
    }
}
