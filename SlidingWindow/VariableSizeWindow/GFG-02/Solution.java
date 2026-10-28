// https://www.geeksforgeeks.org/problems/longest-k-substring0752/1
import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        Map<Character, Integer> mpp = new HashMap<>();

        int n = s.length();
        int res = -1;
        int low = 0;

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            while (mpp.size() > k) {
                char leftChar = s.charAt(low);

                mpp.put(leftChar, mpp.get(leftChar) - 1);

                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }

                low++;
            }

            if (mpp.size() == k) {
                int len = high - low + 1;
                res = Math.max(len, res);
            }
        }

        return res;
    }
}