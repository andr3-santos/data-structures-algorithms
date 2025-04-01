import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HasDuplicateTest {

    private final HasDuplicate victim = new HasDuplicate();

    @Test
    void hasDuplicateWithoutDuplicateArray() {
        int[] numbers = {1, 2, 3, 4};
        assertFalse(victim.hasDuplicate(numbers));
    }

    @Test
    void hasDuplicateWithDuplicateArray() {
        int[] numbers = {1, 2, 2, 4};
        assertTrue(victim.hasDuplicate(numbers));
    }
}