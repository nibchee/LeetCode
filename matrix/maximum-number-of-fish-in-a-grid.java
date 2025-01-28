class Solution {
    public int findMaxFish(int[][] grid) {
        int ans=0;
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int a1=(i+1)<m?grid[i][j]+grid[i+1][j]:grid[i][j];
                int a2=(i-1)>=0?grid[i][j]+grid[i-1][j]:grid[i][j];
                int a3=(j+1)<n?grid[i][j]+grid[i][j+1]:grid[i][j];
                int a4=(j-1)>=0?grid[i][j]+grid[i][j-1]:grid[i][j];
                ans=Math.max(ans,Math.max(Math.max(a1,a2),Math.max(a3,a4)));
            }
        }
    return ans;
    }
}