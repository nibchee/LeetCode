class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0,j=0;
        int m=firstList.length;
        int n=secondList.length;
        ArrayList<int[]> ans=new ArrayList<>();

    while(i<m && j<n){
            if(secondList[j][1]>=firstList[i][0] && secondList[j][1]<=firstList[i][1]){
               int[] overlapp=new int[]{Math.max(firstList[i][0],secondList[j][0]),Math.min(firstList[i][1],secondList[j][1])};
               ans.add(overlapp);
               j++;
            }else if(secondList[j][0]>=firstList[i][0] && secondList[j][0]<=firstList[i][1]){
                 int[] overlapp=new int[]{Math.max(firstList[i][0],secondList[j][0]),Math.min(firstList[i][1],secondList[j][1])};
               ans.add(overlapp);
               i++;
            }else{
                if(firstList[i][1]<secondList[j][0])
                i++;
                else
                j++;
            }
           // System.out.println(j);
        }
   int [][]finalAns=new int[ans.size()][2];
   for(int z=0;z<ans.size();z++){
     finalAns[z]=ans.get(z);
   }
   return finalAns;
    }


}