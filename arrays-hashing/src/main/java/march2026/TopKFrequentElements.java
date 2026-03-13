package march2026;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> freqMap = new HashMap<>();
       List<Integer>[] freqArray = new ArrayList[nums.length + 1];

        for (int i = 0; i < freqArray.length; i++) {
            freqArray[i] = new ArrayList<>();
        }

        for (int num: nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        freqMap.forEach((number, nrTimesItAppears) -> {
            freqArray[nrTimesItAppears].add(number);
        });

        int index = 0;
        int[] res = new int[k];
        for (int i = freqArray.length -1; i > 0 && index < k; i--) {
            for (int n: freqArray[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }


    // 5,3,3,2,6
    // 5 - 1
    // 3 - 2
    // 2 - 1
    // 6 - 1
}
