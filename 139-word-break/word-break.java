class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == true && wordDict.contains(s.substring(j, i))) 
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}