class Solution {
    public boolean canConstruct(String s, int k) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int e=0, o=0;
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
            if(freq[i]%2==0)
            e++;
            else
            o++;
            }
        }
       return o<=k;
    }
}