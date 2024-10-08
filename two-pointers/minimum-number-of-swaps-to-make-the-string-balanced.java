class Solution {
    public int minSwaps(String s) {
        int start=0;
        int end=0;
        int i=0;
        int n=s.length();
        int j=n-1;
        int ans=0;
        while(i<j){
          while(i<j && start>=0){
             if(s.charAt(i)==']')
             start--;
             else
             start++;
             i++;
          } 
          while(j>i && end>=0){
            if(s.charAt(j)=='[')
             end--;
             else
             end++;
             j--;
          }
          if(i==n || j==-1) break;
          System.out.println(i+" "+j);
          if(s.charAt(i-1)==']' && s.charAt(j+1)=='['){
             ans++;
             start++;
             end++;
          }
        }
    return ans;
    }
}