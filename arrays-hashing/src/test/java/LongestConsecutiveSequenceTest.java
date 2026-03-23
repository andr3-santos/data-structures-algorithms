import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    private final LongestConsecutiveSequence victim = new LongestConsecutiveSequence();

    @Test
    void longestConsecutive() {
        int expected = 4;
        int actual = victim.longestConsecutive(new int[]{2, 20, 4, 10, 3, 4, 5});
        assertEquals(expected, actual);
    }
}