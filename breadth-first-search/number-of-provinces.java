class Solution {
    boolean [][]visited;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        visited=new boolean[n][n];
        int ans=0;
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
            if(!visited[i][j] && isConnected[i][j]!=0){
            dfs(i,j,isConnected);
           ans++;
            }
           }
       
        }
 return ans;
    }

    public void dfs(int i,int j,int[][] graph){
        if(i<0 || i>=graph.length || j<0 || j>=graph.length || visited[i][j] || graph[i][j]==0)
        return;
        visited[i][j]=true;
        dfs(i+1,j,graph);
        dfs(i-1,j,graph);
        dfs(i,j+1,graph);
        dfs(i,j-1,graph);
    }
}