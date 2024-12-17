class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[]=new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
            //System.out.println(ch+" "+freq[ch-'a']+" ");
        }
        String ans="";
        for(int i=25;i>=0;){
            while(i>=0 && freq[i]==0)
            i--;
            if(i<0)
            break;
            int f=freq[i];
            int apend=f;
            if(ans.length()>0 && ans.charAt(ans.length()-1)==(char)('a'+i))
            break;
            if(f>repeatLimit){
                freq[i]=f-repeatLimit;
                apend=repeatLimit;
            }else{
                freq[i]=0;
            }

            for(int k=0;k<apend;k++){
              ans+=(char)('a'+i);
            }
           // System.out.println(ans+" "+freq[i]);
            if(freq[i]==0)continue;
            
            int j=i-1;
            while(j>=0 && freq[j]==0){
                j--;
            }

            if(j>=0){
                ans+=(char)('a'+j);
                freq[j]--;
            }
        }
        return ans;
    }
}