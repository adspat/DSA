class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0 ;
        int low = 0 ;
        int windowProduct = 1 ;
        int n = nums.length; 
        int ans = 0 ;
        for(int high=0;high<n;high++){
            windowProduct *= nums[high] ;
            while(windowProduct>=k){
                windowProduct /= nums[low] ;
                low ++ ;
            }
            ans += high-low + 1 ;
        }
        return ans ;
    }
};