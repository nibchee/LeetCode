class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int l=nums.length;
        int i=0,j=0;
        
        Set<Integer> s=new HashSet<>();
        int sum=0,max_sum=0;
        while(i<l && j<l){
            if(!s.contains(nums[j])){
                s.add(nums[j]);
                sum+=nums[j];
            }else{
                int k=i;
                for(;nums[k]!=nums[j];k++){
                    s.remove(new Integer(nums[k]));
                    sum-=nums[k];
                }
                i=k+1;
            }
            max_sum=Math.max(max_sum,sum);
            j++;
        }
        return max_sum;
    }
}