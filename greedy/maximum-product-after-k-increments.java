class Solution {
    int MOD=1000_000_007;
    public int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0];
        int c=0;
        long prd=1;
        for(int num:nums){
            if(num==min)
            c++;
            else
            prd=(prd*num)%MOD;
        }

        int div=k/c;
        int rem=k%c;
        
        for(int i=0;i<c;i++){
            prd=(prd*(min+div))%MOD;
        }

        for(int i=0;i<rem;i++){
            prd=(prd*(min+1))%MOD;
        }
        
        return (int)prd;
        
        
        
    }
}