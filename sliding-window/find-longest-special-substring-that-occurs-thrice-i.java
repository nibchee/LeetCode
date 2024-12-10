class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> freq=new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        while(i<n && j<n){
            char ch=s.charAt(i);
           while(j<n && ch==s.charAt(j)){
              j++;
           }
           putSpecialStringFreq(freq,ch,i,j);
           i=j;
        }
        int ans=-1;
        for(Map.Entry<String,Integer> entry: freq.entrySet()){
         int l=Integer.parseInt(entry.getKey().substring(1));
         int count=entry.getValue();
         if(count>=3)
            ans=Math.max(ans,l);
         }
        
        return ans;
    }

    private void putSpecialStringFreq(HashMap<String,Integer> freq,char ch,int i,int j){
         int len=j-i;
         for(Integer k=1;k<=len;k++){
            String str=ch+k.toString();
           freq.put(str,freq.getOrDefault(str,0)+len-k+1);
         }
    }
}