package com.exercise.active_edge.exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmallestNonOccurringIntegerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findSmallestNonOccurringIntegerReturns5() {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int smallestNonreoccurringNumber = SmallestNonOccurringInteger.findSmallestNonOccurringInteger(array1);
        assertThat(smallestNonreoccurringNumber).isEqualTo(5);
    }

    @Test
    void findSmallestNonOccurringIntegerReturns1() {
        int[] array2 = {5, -1, -3};
        int smallestNonreoccurringNumber = SmallestNonOccurringInteger.findSmallestNonOccurringInteger(array2);
        assertThat(smallestNonreoccurringNumber).isEqualTo(1);
    }
}