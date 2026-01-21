package core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowTest {
    private SlidingWindow victim = new SlidingWindow();

    @Test
    void slidingWindow() {
        int[] input = {5, 2, -1, 0, 3};
        int expected = 6;
        int actual = victim.naiveSlidingWindow(input, 3);

        assertEquals(expected, actual);
    }

    @Test
    void slidingWindow2() {
        int[] input = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int expected = 39;
        int actual = victim.naiveSlidingWindow(input, 4);

        assertEquals(expected, actual);

    }

    @Test
    void slidingWindow3() {
        int[] input = {5, 2, -1, 0, 3};
        int expected = 6;
        int actual = victim.slidingWindow(input, 3);

        assertEquals(expected, actual);
    }

    @Test
    void slidingWindow4() {
        int[] input = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int expected = 39;
        int actual = victim.slidingWindow(input, 4);

        assertEquals(expected, actual);
    }
}