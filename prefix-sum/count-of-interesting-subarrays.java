class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
      for(int i=0;i<nums.size();i++){
        if(nums.get(i)%modulo==k){
            nums.set(i,1);
        }else{
            nums.set(i,0);
        }
      }

      int l=0;
      int cnt=0;
      long ans=0;
      int n=nums.size();
      int p[]=new int[n];
      int s[]=new int[n];
      p[0]=nums.get(0);
      s[n-1]=nums.get(n-1);

      for(int i=0;i<n;i++){
        if(i!=0 && nums.get(i)==1)
          p[i]=nums[i]+p[i-1];
          if(i!=0 && nums.get(n-i-1)==1)
          s[i]=nums[i]+s[i+1];
       }

       for(int i=0;i<n;i++){
         ans+=(s[i-1]-p[i])%k;
       }  
   return ans;
    }
}