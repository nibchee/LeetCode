class Solution {

    int binarySearch(int[] nums,int val,int low,int high){
        int mid=low+(high-low)/2;
        
        while(low<=high ){
           mid= low+(high-low)/2;
          if(val>nums[mid]){
              low=mid+1;
          }else{
              high=mid-1;
          }
        }
    
    return low;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
     int n=nums.length;
int count=0;
//O(n^2 * logn)
        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                int val=nums[i]+nums[j];
                int k=binarySearch(nums,val,j+1,nums.length-1);
                count+=k-j-1;
            }
        }
   return count;
    }

}