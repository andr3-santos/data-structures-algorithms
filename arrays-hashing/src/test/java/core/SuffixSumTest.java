package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuffixSumTest {

    private SuffixSum victim = new SuffixSum();

    @Test
    void suffixSum() {
        int[] input = { 15, 10, 25, 5, 10, 20};
        int[] expected = {85, 70, 60, 35, 30, 20};
        int[] actual = victim.suffixSum(input);

        assertArrayEquals(expected, actual);
    }
}