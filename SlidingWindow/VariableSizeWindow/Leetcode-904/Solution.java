// https://leetcode.com/problems/fruit-into-baskets/
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mpp = new HashMap<>();

        int n = fruits.length;
        int res = 0;
        int low = 0;

        for (int high = 0; high < n; high++) {
            int fruit = fruits[high];
            mpp.put(fruit, mpp.getOrDefault(fruit, 0) + 1);

            while (mpp.size() > 2) {
                int leftFruit = fruits[low];

                mpp.put(leftFruit, mpp.get(leftFruit) - 1);

                if (mpp.get(leftFruit) == 0) {
                    mpp.remove(leftFruit);
                }

                low++;
            }

            if (mpp.size() <= 2) {
                int len = high - low + 1;
                res = Math.max(len, res);
            }
        }

        return res;
    }
}