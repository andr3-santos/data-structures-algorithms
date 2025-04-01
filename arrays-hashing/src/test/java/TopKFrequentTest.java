import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentTest {

    private final TopKFrequent victim = new TopKFrequent();
    @Test
    void topKFrequent() {
        int[] input = {1, 2, 2, 3, 3, 3};
        int target = 2;
        int[] expected = {2, 3};

        int[] actual = victim.topKFrequent(input, target);
        assertArrayEquals(expected, actual);
    }
}