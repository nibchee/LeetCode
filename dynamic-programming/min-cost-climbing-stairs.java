class Solution {
     int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        helper(n,cost);
        return dp[n];
    }
    private int helper(int n,int[] cost){
      if(n<=1) return 0;
      int c1=cost[n-1]+(dp[n-1]!=0?dp[n-1]:helper(n-1,cost));
      int c2=cost[n-2]+(dp[n-2]!=0?dp[n-2]:helper(n-2,cost));
      dp[n]=Math.min(c1,c2);
      return dp[n];
    }
}