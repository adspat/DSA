class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0 , high = 0 ;
        int res = Integer.MAX_VALUE ;
        int sum = 0 ;
        while(high<nums.length){
            sum += nums[high];
            while(sum>=target){
                int len = high-low+1;
                res = Math.min(res,len);
                sum = sum-nums[low];
                low ++ ;
            }
            high ++ ;
        }
        return res == Integer.MAX_VALUE ? 0 : res ;
    }
}