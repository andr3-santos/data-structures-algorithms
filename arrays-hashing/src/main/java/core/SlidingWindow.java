package core;

public class SlidingWindow {

    public int naiveSlidingWindow(int[] input, int k) {
        int biggestSum = Integer.MIN_VALUE;
        for (int i = 0; i + k <= input.length; i++) {
            int insideSum = 0;

            for (int j = i; j < i + k; j++) {
                insideSum += input[j];
            }
            biggestSum = Math.max(insideSum, biggestSum);
        }
        return biggestSum;
    }


    public int slidingWindow(int[] input, int k) {
       return 0;
    }
}
