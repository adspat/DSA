import java.util.HashMap;

// Longest Substring Without Repeating Characters

class Solution {
    public int longestUniqueSubstr(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        int low = 0;
        int ans = 0;
        
        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            // Map mein frequency badhao
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
            
            int len = high - low + 1;
            
            // Jab tak duplicates hain (map size < window length)
            while (mpp.size() < len) {
                char lowChar = s.charAt(low);
                mpp.put(lowChar, mpp.get(lowChar) - 1);
                
                // Agar frequency 0 ho jaye toh map se hata do
                if (mpp.get(lowChar) == 0) {
                    mpp.remove(lowChar);
                }
                
                low++;
                len = high - low + 1;
            }
            
            ans = Math.max(len, ans);
        }
        return ans;
    }
}