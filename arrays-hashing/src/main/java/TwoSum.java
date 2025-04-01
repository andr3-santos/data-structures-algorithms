import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexToComplement = new HashMap<>();
        int[] retArray = new int[2];
        for (int i = 0; i <nums.length; i++) {
            int complement = target - nums[i];
            Integer i1 = indexToComplement.get(complement);
            if (i1 != null) {
                if (i1 < i) {
                    retArray[0] = i1;
                    retArray[1] = i;
                } else if (i1 > i) {
                    retArray[0] = i;
                    retArray[1] = i1;
                }
            }
            indexToComplement.put(nums[i], i);
        }

        return retArray;
    }
}
