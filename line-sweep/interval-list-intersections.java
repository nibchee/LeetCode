class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0,j=0;
        int m=firstList.length;
        int n=secondList.length;
        ArrayList<int[]> ans=new ArrayList<>();

     while (i < n && j < m) {
    int start = Math.max(firstList[i][0], secondList[j][0]);
    int end = Math.min(firstList[i][1], secondList[j][1]);

    if (start <= end) {
        // There is an overlap
        int[] overlap = new int[]{start, end};
        ans.add(overlap);
    }

    // Move the pointer with the smaller end time
    if (firstList[i][1] < secondList[j][1]) {
        i++;
    } else {
        j++;
    }
}
   int [][]finalAns=new int[ans.size()][2];
   for(int z=0;z<ans.size();z++){
     finalAns[z]=ans.get(z);
   }
   return finalAns;
    }


}