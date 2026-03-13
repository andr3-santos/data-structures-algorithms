package march2026;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean hasDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        return numSet.size() != nums.length;
    }
}
