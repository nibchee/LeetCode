class Solution {
    public int maxProfit(int[] prices) {
       int max_profit=0;
       int n=prices.length;
       for(int i=0;i<n;i++){
         int buy=prices[i];
         for(int j=i+1;j<n;j++){
           if(prices[j]>buy)
           max_profit=Math.max(max_profit,prices[j]-buy);
         }
       }
       return max_profit; 
    }
}