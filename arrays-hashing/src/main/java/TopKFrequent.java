import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        // Initialize frequency array
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // Get how many times each number appears
        for (int n : nums) {
            count.merge(n, 1, Integer::sum);
        }

        // Add the respective frequency to the freq array
        count.forEach((key, value) -> {
            freq[value].add(key);
        });

        int[] res = new int[k];
        int index = 0;

        // Get top occurring elements in freq array;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n: freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

}
