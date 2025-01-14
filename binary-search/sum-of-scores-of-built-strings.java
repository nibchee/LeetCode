class Solution {
    public long sumScores(String s) {
        int n=s.length();
        int[] z=new int[n];

       //O(n^2) 
        // for(int i=0;i<n;i++){
        //     while((i+z[i]<n) && (s.charAt(z[i])==s.charAt(i+z[i])))
        //     z[i]++;
        // }

        int l=0;
        int r=0;
        //O(n)
        for(int i=1;i<n;i++){
            if(i<=r){
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            while((i+z[i]<n) && (s.charAt(z[i])==s.charAt(i+z[i])))
            z[i]++;

            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
            }
        }
        long ans=0;
        for(int e:z)
        ans+=e;

        return ans+n;
    }
}