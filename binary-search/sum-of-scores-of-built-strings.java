class Solution {
    public long sumScores(String s) {
        int n=s.length();
        int[] z=new int[n];
        
        for(int i=0;i<n;i++){
            while((i+z[i]<n) && (s.charAt(z[i])==s.charAt(i+z[i])))
            z[i]++;
        }
        long ans=0;
        for(int e:z)
        ans+=e;

        return ans;
    }
}