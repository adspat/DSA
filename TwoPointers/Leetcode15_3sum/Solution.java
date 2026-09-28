class Solution {

    //  3Sum Soltuion code
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        int n = nums.length ;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1])continue ;
            int target = -1 * nums[i];
            int left = i+1 ;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left] + nums[right] ;
                if(sum == target){
                    matrix.add(new ArrayList<>(List.of(nums[i],nums[left],nums[right])));
                    left ++ ;
                    right -- ;
                    while(left<n && nums[left] == nums[left-1])left ++ ;
                    while(right>=0 && nums[right] == nums[right+1])right -- ;
                }
                else if(sum<target) left ++ ;
                else right -- ;
            }
        }
        return matrix ;
    }
}