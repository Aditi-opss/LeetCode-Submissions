class Solution {
    // int island = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int island = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, island);
                }
            }
        }   
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        int island = 0;
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        
        grid[row][col] = 0;
        island++ ;
        island += dfs(grid, row + 1, col);
        island += dfs(grid, row - 1, col);
        island += dfs(grid, row, col + 1);
        island += dfs(grid, row, col - 1);  

        return island;
    }
}