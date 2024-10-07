class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        while(j<n){
          while(j<n && nums[i]==nums[j]){
            j++;
          }
          if(j<n){
            if(j-i>=2 && nums[i]==nums[i+1])
            i=i+2;
            else
            i=i+1;
            nums[i]=nums[j];
          }
        }

        if(nums[j-1]==nums[j-2])
        nums[++i]=nums[j-1];
        
         return i+1;
    }
}