class Solution {
    public boolean sahi(int[] have, int[] needed) {
        for (int i = 0; i < 256; i++) {
            if (have[i] < needed[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int low = 0;
        int[] have = new int[256];
        int[] needed = new int[256];
        int ans = Integer.MAX_VALUE;
        int start = -1;
        
        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }
        
        for (int high = 0; high < s.length(); high++) {
            have[s.charAt(high)]++;
            
            while (sahi(have, needed)) {
                int len = high - low + 1;
                if (len < ans) {
                    ans = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        
        if (start == -1) return "";
        
        // Java mein substring(start, end) hota hai, 
        // isiliye end index (start + ans) pass kiya gaya hai.
        return s.substring(start, start + ans);
    }
}