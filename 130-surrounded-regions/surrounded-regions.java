class Solution {
    int[] rowIndex = new int [] {1, -1, 0, 0};
    int[] colIndex = new int[] {0, 0, 1, -1};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        Queue<int[]> bfs = new LinkedList<>();

        //1st and last row
        int first = 0, last = m - 1;
        for(int c = 0; c < n; c++) {
            if(board[first][c] == 'O') {
                bfs.add(new int[] {first, c});
            }
            if(board[last][c] == 'O') {
                bfs.add(new int[] {last, c});
            }
        }
        //1st and last col
        last = n - 1;
        for(int c = 0; c < m; c++) {
            if(board[c][first] == 'O') {
                bfs.add(new int[] {c, first});
            }
            if(board[c][last] == 'O') {
                bfs.add(new int[] {c, last});
            }
        }
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfs.remove();
                int r = curr[0]; 
                int c = curr[1]; 
                board[r][c] = '*';

                for(int dir = 0; dir < 4; dir++) {
                    int nextRow = r + rowIndex[dir];
                    int nextCol = c + colIndex[dir];
                    if(isValid(nextRow, nextCol, m , n , board)) {
                        bfs.add(new int[] {nextRow, nextCol});
                    }
                }

                // if(r - 1 >= 0 && board[r - 1][c] == 'O') bfs.add(new int[] {r - 1, c});
                // if(r + 1 < m && board[r + 1][c] == 'O') bfs.add(new int[] {r + 1, c});
                // if(c - 1 >= 0 && board[r][c - 1] == 'O') bfs.add(new int[] {r, c - 1});
                // if(c + 1 < n && board[r][c + 1] == 'O') bfs.add(new int[] {r, c + 1});
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '*') board[i][j] ='O';
            }
        }
    }
    public boolean isValid(int r, int c, int m, int n, char[][] grid) {
        return r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 'O';
    }
}