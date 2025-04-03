class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        prefix[0]=nums[0];
        int suffix[]=new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=0;i<n;i++){
            if(i>0){
            prefix[i]=Math.max(prefix[i-1],nums[i]);
            suffix[n-i-1]=Math.max(suffix[n-i],nums[n-i-1]);
            }
        }

        long ans=0l;
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,(prefix[i-1]-nums[i])*suffix[i+1]);
        }
        return ans;
    }
}