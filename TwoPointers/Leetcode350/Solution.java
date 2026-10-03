package TwoPointers.Leetcode350;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// intersection of two arrays-II using two pointers approach
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Sort both arrays in ascending order
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        
        // Two-pointer approach to find common elements
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                i++;
            }
        }
        
        // Convert List<Integer> to primitive int[] array
        int[] result = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }
        
        return result;
    }
    // intersection of two arrays-II using HashMap approach
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : nums2) {
            if (map.getOrDefault(x, 0) > 0) {
                result.add(x);
                map.put(x, map.get(x) - 1);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        // Using two pointers approach
        int[] intersection1 = solution.intersect(nums1, nums2);
        System.out.println("Intersection using two pointers: " + Arrays.toString(intersection1));

        // Using HashMap approach
        int[] intersection2 = solution.intersect2(nums1, nums2);
        System.out.println("Intersection using HashMap: " + Arrays.toString(intersection2));
    }
}

