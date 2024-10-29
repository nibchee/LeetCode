class Solution {
    int ans = 0;

    public int maxMoves(int[][] grid) {
        // try all possible ways
        for (int i = 0; i < grid.length; i++) {
            try_allWays(grid, i, 0, 0);
        }
        return ans;
    }

   public void try_allWays(int[][]grid,int row,int col, int moves){
        ans=Math.max(ans,moves);

    //upper  right
    if(row-1>=0 && col+1<grid[0].length && grid[row-1][col+1]>grid[row][col]){
        try_allWays(grid,row-1,col+1,moves+1);
    }
      //right
    if( col+1<grid[0].length && grid[row][col+1]>grid[row][col]){
        try_allWays(grid,row,col+1,moves+1);
    }

    //down right
    if( col+1<grid[0].length && row+1<grid.length && grid[row+1][col+1]>grid[row][col]){
        try_allWays(grid,row+1,col+1,moves+1);
    }
   }

}