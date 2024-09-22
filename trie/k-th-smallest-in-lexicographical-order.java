class Solution {
    public int findKthNumber(int n, int k) {
          List<Integer> ans=new ArrayList<>();
      for(int s=1;s<=9;s++){
        helper(s,n,ans,k);
      } 
      return ans.get(k-1);
    }

     private void helper(int num,int limit,List<Integer> ans,int k){
      if(num>limit) return;
      if(ans.size()>=k) return;
      ans.add(num);
      for(int nextDigit=0;nextDigit<=9;nextDigit++){
        int nextNum=num*10+nextDigit;
        if(nextNum>limit) break;
        helper(nextNum,limit,ans,k);
      }
    }
}