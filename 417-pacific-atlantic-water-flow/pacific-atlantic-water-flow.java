class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      int n=heights.length, m=heights[0].length;
      boolean[][] pacific=new boolean[n][m],atlantic=new boolean[n][m];

      for(int i=0;i<n;i++){
        dfs(i,0,n,m,heights, heights[i][0],pacific); //1st col
        dfs(i,m-1,n,m,heights, heights[i][m-1],atlantic); //last col
      }

      for(int j=0;j<m;j++){
        dfs(0,j,n,m,heights, heights[0][j],pacific); //1st row
        dfs(n-1,j,n,m,heights, heights[n-1][j],atlantic); //last row
      }

      List<List<Integer>> ans=new ArrayList<>();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
          if(pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
        }
      }
      
      return ans;
    }

    public void dfs(int i,int j,int n,int m,int heights[][],int preHeight,boolean vis[][]){
      if(i<0 || j<0 || i==n || j==m || vis[i][j] || preHeight>heights[i][j]) return;
      vis[i][j]=true;
      dfs(i+1,j,n,m,heights, heights[i][j],vis);
      dfs(i,j+1,n,m,heights, heights[i][j],vis);
      dfs(i-1,j,n,m,heights, heights[i][j],vis);
      dfs(i,j-1,n,m,heights, heights[i][j],vis);
    }
}