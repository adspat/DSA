// Max Sum Subarray of Size K

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int low = 0 ;
        int high = k-1;
        int sum = 0 , res = 0 ;
        for(int i=0;i<=high;i++){
            sum += arr[i];
        }
        while(high<arr.length){
            res = Math.max(res,sum);
            low ++ ;
            high ++ ;
            if(high == arr.length)break;
            sum = sum-arr[low-1];
            sum = sum + arr[high];
        }
        return res ;
    }
}