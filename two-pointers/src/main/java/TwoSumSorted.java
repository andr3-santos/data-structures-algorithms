public class TwoSumSorted {

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

    public static void main(String[] args) {
        TwoSumSorted s = new TwoSumSorted();
        int[] ints = s.twoSum(new int[]{-5, -3, 0, 2, 4, 6, 8}, 5);
        System.out.println(ints);
    }
}
