package core;

public class PrefixSum {

    public int[] calculatePrefixSum(int[] entry) {
        int[] res = new int[entry.length];
        int sum = 0;
        for (int i = 0; i < entry.length; i++) {
            sum += entry[i];
            res[i] = sum;
       }
        return res;
    }
}