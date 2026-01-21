package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PrefixSumTest {

    PrefixSum victim = new PrefixSum();

    @Test
    void testPrefixSum() {
        int[] arr = { 10, 20, 10, 5, 15};
        int[] expected = { 10, 30, 40, 45, 60};
        int[] actual = victim.calculatePrefixSum(arr);

        assertArrayEquals(expected, actual);
    }
}
