class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][]=new int[m][n];
        for(int wall[]:walls){
            grid[wall[0]][wall[1]]=1;
        }

        for(int i=0;i<guards.length;i++){
            int row=guards[i][0];
            int col=guards[i][1];
            grid[row][col]=-1;
            for(int r=row-1;r>=0;r--){
                if(grid[r][col]==1)
                break;
                grid[r][col]=-1;
            }

            for(int r=row+1;r<m;r++){
                if(grid[r][col]==1)
                break;
                grid[r][col]=-1;
            }

            for(int c=col-1;c>=0;c--){
                if(grid[row][c]==1)
                break;
                grid[row][c]=-1;
            }

            for(int c=col+1;c<n;c++){
                if(grid[row][c]==1)
                break;
                grid[row][c]=-1;
            }
        }

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                ans++;
            }
        }
    return ans;
    }
}