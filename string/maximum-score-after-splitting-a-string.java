class Solution {
    public int maxScore(String s) {
        int count1=0;
        for(char ch: s.toCharArray()){
            if(ch=='1')
            count1++;
        }

        int count0=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch=='0')
            count0++;
            else
            count1--;
            ans=Math.max(ans,count0+count1);
        }
    return ans;
    }
}