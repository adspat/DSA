class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int low = 0 ;
        int ans = 0 ;
        int windowSum = 0 ;
        int n = arr.length ;
        for(int high=0;high<n;high++){
            windowSum += arr[high];
            if(high-low+1 == k){
                int size = high-low+1 ;
                int average = windowSum/size ;
                if(average>=threshold){
                    ans ++ ;
                }
                windowSum -= arr[low] ;
                low ++ ;
            }
            
        }
        return ans ;
    }
}