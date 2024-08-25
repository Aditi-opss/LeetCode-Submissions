class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return s;
        
        String ans = "";
        int max = 0, l = 0, r = 0;
        for(int i = 0; i < n; i++) {
            l = i; r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--; 
                r++; 
            }
            int strLen = r-l-1;
            if(max < strLen) {
                max = strLen;
                ans = s.substring(l+1, r);
            }

            l = i; r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--; 
                r++; 
            }
            int strLen2 = r-l-1;
            if(max < strLen2) {
                max = strLen2;
                ans = s.substring(l+1, r);
            }

        }
        return ans;
    }
}