import java.util.*;
class Solution {
    public ArrayList<Integer> countDistinct(int[] arr, int k) {

        int low = 0;
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int high = 0; high < n; high++) {

            // Add incoming element
            map.put(arr[high], map.getOrDefault(arr[high], 0) + 1);

            if (high - low + 1 == k) {

                // Count distinct elements
                ans.add(map.size());

                // Remove outgoing element
                int x = arr[low];
                map.put(x, map.get(x) - 1);

                // Remove key if frequency becomes zero
                if (map.get(x) == 0) {
                    map.remove(x);
                }

                low++;
            }
        }

        return ans;
    }
}