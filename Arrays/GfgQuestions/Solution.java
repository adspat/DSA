import java.util.*;


// GFG rearrangeArray 

class Solution {
    public int[] rearrangeArray(int[] arr) {
        
        Arrays.sort(arr);

        for (int i = 2; i < arr.length; i = i + 2) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        return arr;
    }
}