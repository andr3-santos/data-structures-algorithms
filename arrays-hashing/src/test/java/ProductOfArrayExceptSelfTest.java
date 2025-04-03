import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    private final ProductOfArrayExceptSelf victim = new ProductOfArrayExceptSelf();

    @Test
    void productExceptSelf() {
        int[] input = {1, 2, 4, 6};
        int[] expected = {48, 24, 12, 8};

        int[] actual = victim.productExceptSelf(input);

        assertArrayEquals(expected, actual);
    }
}