class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        for(Integer num:nums){
            if(num.toString().length()%2==0)
            c++;
        }
    return c;
    }
}