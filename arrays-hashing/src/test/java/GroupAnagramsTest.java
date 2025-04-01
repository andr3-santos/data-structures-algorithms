import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GroupAnagramsTest {

    private final GroupAnagrams victim = new GroupAnagrams();

    @Test
    void groupAnagrams() {
        String[] input = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> expected = List.of(List.of("hat"), List.of("act", "cat"), List.of("stop", "pots", "tops"));
        List<List<String>> actual = victim.groupAnagrams(input);

        // Normalize the actual and expected output for comparison
        List<List<String>> normalizedActual = normalize(actual);
        List<List<String>> normalizedExpected = normalize(expected);

        assertEquals(normalizedExpected, normalizedActual);
    }

    @Test
    void groupAnagramsFreq() {
        String[] input = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> expected = List.of(List.of("hat"), List.of("act", "cat"), List.of("stop", "pots", "tops"));
        List<List<String>> actual = victim.groupAnagramsFreq(input);

        // Normalize the actual and expected output for comparison
        List<List<String>> normalizedActual = normalize(actual);
        List<List<String>> normalizedExpected = normalize(expected);

        assertEquals(normalizedExpected, normalizedActual);
    }

    private List<List<String>> normalize(List<List<String>> list) {
        return list.stream()
                .map(inner -> {
                    List<String> sortedInner = new ArrayList<>(inner);
                    Collections.sort(sortedInner);
                    return sortedInner;
                })
                .sorted(Comparator.comparing(Object::toString)) // sort outer list
                .toList();
    }
}