class Solution {

    //Observation Length of Paths-> grid.length[0]+1
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long prefix0[]=new long[n];
        long suffix1[]=new long[n];
         
         prefix0[0]=grid[0][0];
        for(int i=1;i<n;i++){
            prefix0[i]=prefix0[i-1]+grid[0][i];
        }

        suffix1[n-1]=grid[1][n-1];
        for(int j=n-2;j>=0;j--){
            suffix1[j]=suffix1[j+1]+grid[1][j];
        }

        int idx=0;
        long maxPath=prefix0[0]+suffix1[0];
        for(int i=1;i<n;i++){
            if(prefix0[i]+suffix1[i]>maxPath){
                maxPath=prefix0[i]+suffix1[i];
                idx=i;
            }
        }
      //  System.out.println(idx);
        long ans=0;
        for(int i=0;i<n;i++){
            long pre=0;
            if(i>idx){
                pre=prefix0[i]-prefix0[idx];
            }
            long suff=0;
            if(i<idx){
                suff=suffix1[i]-suffix1[idx];
            }
            
            //System.out.println(pre +" "+suff);
            ans=Math.max(ans,pre+suff);
        }
        return ans;
    }
}