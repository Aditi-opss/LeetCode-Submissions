class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length() + 1];
        return numDecodingsHelper(s, 0, dp);
    }

    public int numDecodingsHelper(String s, int index, Integer[] dp) {
        if(s == "") return 1;

        int oneD = Integer.valueOf(s.substring(0,1));
        int twoD = s.length() >= 2 ? Integer.valueOf(s.substring(0,2)) : 0;

        int x = 0, y = 0;
        if(dp[index] != null) return dp[index];
        if(oneD >= 1) {
            x = numDecodingsHelper(s.substring(1), index + 1, dp);
        }
        if(twoD >= 10 && twoD <= 26) {
            y = numDecodingsHelper(s.substring(2), index + 2, dp);
        }
        return dp[index] = x + y;
    }
}