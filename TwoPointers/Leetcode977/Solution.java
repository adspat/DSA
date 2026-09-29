

public class Solution {

    //Leetcode 977 squares of sorted array 

    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        // Find first non-negative element
        int positiveIndexStart = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                positiveIndexStart = i;
                break;
            }
        }

        // All elements are negative
        if (positiveIndexStart == -1) {
            for (int i = n - 1; i >= 0; i--) {
                ans[n - 1 - i] = nums[i] * nums[i];
            }
            return ans;
        }

        int negativeIndexEnd = positiveIndexStart - 1;

        // Square all elements
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int index = 0;

        // Merge negative and positive parts
        while (negativeIndexEnd >= 0 && positiveIndexStart < n) {

            if (nums[negativeIndexEnd] < nums[positiveIndexStart]) {
                ans[index++] = nums[negativeIndexEnd];
                negativeIndexEnd--;
            } 
            else {
                ans[index++] = nums[positiveIndexStart];
                positiveIndexStart++;
            }
        }

        // Remaining negative elements
        while (negativeIndexEnd >= 0) {
            ans[index++] = nums[negativeIndexEnd];
            negativeIndexEnd--;
        }

        // Remaining positive elements
        while (positiveIndexStart < n) {
            ans[index++] = nums[positiveIndexStart];
            positiveIndexStart++;
        }

        return ans;
    }
}