package core;

public class SuffixSum {

    public int[] suffixSum(int[] input) {
        int sum = 0;
        int[] res = new int[input.length];
        for (int i = input.length-1; i >= 0; i--) {
            sum += input[i];
            res[i] = sum;
        }
        return res;
    }
}
