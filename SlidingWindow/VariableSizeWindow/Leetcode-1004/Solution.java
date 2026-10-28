
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int count = 0;
        int low = 0;

        for (int high = 0; high < n; high++) {
            if (nums[high] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[low] == 0) {
                    count--;
                }
                low++;

                int len = high - low + 1;
                res = Math.max(len, res);
            }

            int len = high - low + 1;
            res = Math.max(len, res);
        }

        return res;
    }
}
