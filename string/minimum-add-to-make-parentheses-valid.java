class Solution {
    public int minAddToMakeValid(String s) {
     int unbalanced=0;
     for(int i=0;i<s.length();i++){
      if(s.charAt(i)==')')
      unbalanced++;
      else
      unbalanced--;
     }   
     return Math.abs(unbalanced);
    }
}