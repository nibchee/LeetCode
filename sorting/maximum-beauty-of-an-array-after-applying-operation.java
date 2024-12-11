class Solution {
    public int maximumBeauty(int[] nums, int k) {
        HashMap<Integer,Integer> f=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=nums[i]-k ;j<=nums[i]+k;j++){
                f.put(j,f.getOrDefault(j,0)+1);
                ans=Math.max(ans,f.get(j));
            }
        }
        return ans;
    }
}