class Solution {
  int c=0;
   Integer ans=-1;
    public int findKthNumber(int n, int k) {
         
      for(int s=1;s<=9;s++){
        helper(s,n,k);
        if(c==k)
        break;
      } 
      return ans;
    }

     private void helper(int num,int limit,int k){
      if(num>limit) return;
      if(c>=k) return;
      ans=num;
      c++;
      
      for(int nextDigit=0;nextDigit<=9;nextDigit++){
        int nextNum=num*10+nextDigit;
        if(nextNum>limit) break;
        helper(nextNum,limit,k);
      }
    }
}