class Solution {
    public int minMoves2(int[] nums) {
        long sum=0;
        for(int num:nums){
            sum+=num;
        }
        int avg=(int)(sum/nums.length);
        int ans=0;
        for(int num:nums){
            ans+=Math.abs(num-avg);
        }
        return ans;
    }
}