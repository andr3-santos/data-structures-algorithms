import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AnagramTest {

    private final Anagram victim = new Anagram();

    @Test
    void isAnagram() {
        String s = "abc";
        String t = "acb";
        assertTrue(victim.isAnagram(s, t));
    }

    @Test
    void isNotAnagram() {
        String s = "abc";
        String t = "cbb";
        assertFalse(victim.isAnagram(s, t));
    }
}