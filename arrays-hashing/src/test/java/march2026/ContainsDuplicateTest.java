package march2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

    private final ContainsDuplicate victim = new ContainsDuplicate();

    @Test
    void hasDuplicateWithoutDuplicateArray() {
        int[] numbers = {1, 2, 3, 4};
        assertFalse(victim.hasDuplicates(numbers));
    }

    @Test
    void hasDuplicateWithDuplicateArray() {
        int[] numbers = {1, 2, 2, 4};
        assertTrue(victim.hasDuplicates(numbers));
    }
}