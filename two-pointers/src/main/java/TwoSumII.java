public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{++i, ++j};

            if (sum > target) {
                j--;
            } else {
                i++;
            }

        }
        throw new IllegalArgumentException("Array does not have solution"); // assuming it's ok since problem states there's always a solution.
    }
}
