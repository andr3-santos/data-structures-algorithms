import java.util.HashSet;

public class HasDuplicate {

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            nonDuplicateNumbers.add(nums[i]);
        }
        return nums.length != nonDuplicateNumbers.size();
    }
}
