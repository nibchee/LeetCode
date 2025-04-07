class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        return helper(n,cost);
    }
    private int helper(int n,int[] cost){
        if(n<=1) return 0;
     return Math.min(cost[n-1]+helper(n-1,cost),cost[n-2]+helper(n-2,cost));
    }
}