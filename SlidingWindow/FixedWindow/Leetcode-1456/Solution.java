class Solution {
    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ;
    }
    public int maxVowels(String s, int k) {
        int count = 0 ;
        int ans = 0 ;
        int low = 0 ;
        int n = s.length();
        for(int high = 0 ; high<n;high++){
            if(isVowel(s.charAt(high))){
                count ++ ;
            }
            if(high - low + 1 == k){
                ans = Math.max(ans,count);
                if(isVowel(s.charAt(low))){
                    count -- ;
                }
                low ++ ;
            }
        }
        return ans ;
    }
}