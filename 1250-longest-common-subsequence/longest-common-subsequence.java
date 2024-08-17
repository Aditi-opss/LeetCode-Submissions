class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length() + 1][text2.length() + 1];
        return longestCommonSubsequenceHelper(text1, text2, 0, 0, dp);
    }

    public int longestCommonSubsequenceHelper(String t1, String t2, int i1, int i2, Integer[][] dp) {
        if(i1 >= t1.length() || i2 >= t2.length()) return 0;
        int x = 0;
        int y = 0;

        if(dp[i1][i2] != null) return dp[i1][i2];
        if(t1.charAt(i1) == t2.charAt(i2)) 
            x = 1 + longestCommonSubsequenceHelper(t1, t2, i1 + 1, i2 + 1, dp);
        else {
            x = longestCommonSubsequenceHelper(t1, t2, i1 + 1, i2, dp);
            y = longestCommonSubsequenceHelper(t1, t2, i1, i2 + 1, dp);
        }

        return dp[i1][i2] = Math.max(x, y);
    }
}