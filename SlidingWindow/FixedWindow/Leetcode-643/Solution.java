class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = -Double.MAX_VALUE ;
        int low = 0 ;
        int n = nums.length ;
        double windowSum = 0.0 ;
        for(int high=0;high<n;high++){
            windowSum += nums[high] ;
            if(high-low+1 == k){
                int size = high-low+1 ;
                double average = windowSum / size ;
                ans = Math.max(ans,average);
                windowSum -= nums[low] ;
                low ++ ;
            }
        }
        return ans ;
    }
}