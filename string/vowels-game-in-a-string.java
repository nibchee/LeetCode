class Solution {
    public boolean doesAliceWin(String s) {
        int cnt=0;
        for(char c:s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            cnt++;
        }
        return (cnt!=0 && cnt%2==0);
    }
}