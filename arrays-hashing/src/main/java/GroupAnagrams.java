import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedStringToList = new HashMap<>();
        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            sortedStringToList.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(s);
        }

        return sortedStringToList.values().stream().toList();
    }

    public List<List<String>> groupAnagramsFreq(String[] strs) {
        HashMap<String, List<String>> stringHashMap = new HashMap<>();
        for (String s: strs) {
            int[] freqArray = new int[26];
            char[] charArray = s.toCharArray();
            // "abc" - 'a' - 'a' = 0
            for (char c: charArray) {
                freqArray[c - 'a']++;
            }

            String key = Arrays.toString(freqArray);
            stringHashMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return stringHashMap.values().stream().toList();
    }
}
