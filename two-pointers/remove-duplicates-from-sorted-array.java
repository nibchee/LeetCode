class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        while(j<n){
          while(j<n && nums[i]==nums[j]){
            j++;
          }
          i++;
          if(j<n)
          nums[i]=nums[j];
        }
    return i;
    }
}