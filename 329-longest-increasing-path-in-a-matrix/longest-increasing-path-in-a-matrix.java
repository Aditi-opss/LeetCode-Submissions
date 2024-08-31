class Solution {
    int[] ri = {1, -1, 0, 0}; 
    int[] ci = {0, 0, 1, -1};
    public int longestIncreasingPath(int[][] matrix) {
        int maxPath = 0;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int path = longestIncreasingPathHelper(matrix, i, j, dp);
                maxPath = Math.max(path, maxPath);
            }
        }
        return maxPath;
    }

    public int longestIncreasingPathHelper(int[][] matrix, int r, int c, Integer[][] dp) {

        if(dp[r][c] != null) return dp[r][c];
        int path = 1;
        for(int i = 0; i < 4; i++) {
            int x = r + ri[i];
            int y = c + ci[i];
            if (isValid(matrix, x, y) && matrix[r][c] < matrix[x][y]) {
                path = Math.max(1 + longestIncreasingPathHelper(matrix, x, y, dp), path);
            }
        }
        return dp[r][c] = path;
    }

    public boolean isValid(int[][] matrix, int r, int c) {
        if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length)
            return false;
        
        return true;
    }
}