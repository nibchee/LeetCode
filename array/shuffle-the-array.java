class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[]=new int[2*n];
        int k=0;
        for(int i=0;i<2*n;i++){
            ans[i]=nums[k];
            i=i+1;
            ans[i]=nums[k+n];
            k++;
        }
        return ans;
    }
}