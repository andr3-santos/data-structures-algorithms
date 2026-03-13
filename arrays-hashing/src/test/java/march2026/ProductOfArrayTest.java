package march2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductOfArrayTest {

    private final ProductOfArray victim = new ProductOfArray();

    @Test
    void productExceptSelf() {
        int[] input = {1, 2, 4, 6};
        int[] expected = {48, 24, 12, 8};

        int[] actual = victim.productExceptSelf(input);

        assertArrayEquals(expected, actual);
    }
}