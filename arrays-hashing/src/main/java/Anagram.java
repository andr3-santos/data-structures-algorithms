import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
    }
}
