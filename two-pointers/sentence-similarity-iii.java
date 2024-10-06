class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
      int l1=sentence1.length();
      int l2=sentence2.length();
      int i=0;
      int j=sentence1.length()-1;
      int k=sentence2.length()-1;

      while(i<l1 & i<l2 && sentence1.charAt(i)==sentence2.charAt(i)){
        i++;
      } 

      while(j>=0 && k>=0 && sentence1.charAt(j)==sentence2.charAt(k)){
          j--;
          k--;
      }

      //System.out.println(i+" "+j+" "+k);

     
       if((j==l1-1 || k==l2-1)&&(i==j+1 || i==k+1))
       return true;
      if((i<l1 && sentence1.charAt(i)==' ')||(j>=0 && sentence1.charAt(j)==' ')||(k>=0 && sentence2.charAt(k)==' '))
      return false;
      if((i<=j && i==k+2)||(i==j+2 && i<=k))
      return true;

      return false;

    }
}