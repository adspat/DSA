import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> mpp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // Count frequency
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Find elements appearing more than n/3 times
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}