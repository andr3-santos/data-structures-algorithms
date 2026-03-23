import java.util.List;

public class GroupAnagrams {

    public List<List<Integer>> groupAnagrams(String[] strs) {
        for (String s : strs) {
            int[] freq = new int[26];
            char[] charArray = s.toCharArray();
            for (char c: charArray) {
                freq[c - 'a']++;
            }
            System.out.println(freq);

        }

        return null;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        g.groupAnagrams(new String[]{"cat"});
    }
}


