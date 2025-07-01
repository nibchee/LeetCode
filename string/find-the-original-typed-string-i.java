class Solution {
    public int possibleStringCount(String word) {
       int n=word.length();
        int i=0;int j=0;
        int ans=1;
        while(i<n && j<n){
            while(j<n && word.charAt(i)==word.charAt(j)){
                j++;
            }
            ans+=(j-i)-1;
            i=j;
        }
        return ans;
    }
}