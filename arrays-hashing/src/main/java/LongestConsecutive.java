import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            integerSet.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (!integerSet.contains(num - 1)) {
                int length = 1;
                while (integerSet.contains(num + 1)) {
                    num++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();

        int i = lc.longestConsecutive(new int[]{1, 20, 4, 10, 3, 4, 5});
        System.out.printf("Longest Consecutive: %d\n", i);
    }
}
