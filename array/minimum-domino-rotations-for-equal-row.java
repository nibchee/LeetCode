class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
    //     for(int i=0;i<tops.length;i++){
    //         if(tops[i]==bottoms[i]){
    //             freq[tops[i]-1]++;
    //         }else{
    //             freq[tops[i]-1]++;
    //             freq[bottoms[i]-1]++;
    //         }
    //     }

    //    int possible=-1;
    //    for(int i: freq){
    //     if(freq>=n){
    //         posible=1;
    //         break;
    //     }
    //    }

        int top_freq[]=new int[6];
       int bottom_freq[]=new int[6];
       int equal[]=new int[6];
                 for(int i=0;i<n;i++){
            if(tops[i]==bottoms[i]){
                equal[tops[i]-1]++;
            }else{
                top_freq[tops[i]-1]++;
                bottom_freq[bottoms[i]-1]++;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<6;i++){
          if(top_freq[i]+bottom_freq[i]+equal[i]==n){
            ans=Math.min(ans,Math.min(top_freq[i],bottom_freq[i]));
          }
        }

    return ans==Integer.MAX_VALUE?-1:ans;
    }
}