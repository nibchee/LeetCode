class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(lower-nums[i]<=0)
            break;
            int smallest=greaterThanEqualTo(nums,lower-nums[i],i);
            int largest=lessThanEqualTo(nums,upper-nums[i],i);
            ans+=largest-smallest+1;
            System.out.println(nums[i]+" "+smallest+" "+largest);
        }
        return ans+1;
    }
    
    private int greaterThanEqualTo(int nums[],int target,int lower){
          int low=lower;
          int high=nums.length-1;
         while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
   private int lessThanEqualTo(int nums[],int target,int lower){
int low=lower;
          int high=nums.length-1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}