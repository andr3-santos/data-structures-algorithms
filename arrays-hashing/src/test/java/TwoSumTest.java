import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private final TwoSum victim = new TwoSum();

    @Test
    void twoSum() {
        int[] nums = {3, 4, 5, 6};
        int target = 7;
        int[] expected = {0, 1};

        int[] actual = victim.twoSum(nums, target);

        assertArrayEquals(expected, actual);
    }
}