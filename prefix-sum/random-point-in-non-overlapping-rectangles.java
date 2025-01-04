class Solution {
      Random rand=null;
      TreeMap<Integer, Integer> map=null;
      int [][]rects;
      int area;
    public Solution(int[][] rects) {
        rand=new Random();
        map=new TreeMap<>();
        this.rects=rects;
        for(int i=0;i<rects.length;i++){
            int currArea=(rects[i][2]-rects[i][0]+1)*(rects[i][3]-rects[i][1]+1);
            area+=currArea;
            map.put(area,i);
        }

    }
    
    public int[] pick() {
         int randInt=rand.nextInt(area);
         int index=map.higherKey(randInt);
         int[] rectChoosen=rects[map.get(index)];
         int x=rectChoosen[0]+(index-randInt-1)%(rectChoosen[2]-rectChoosen[0]+1);
         int y=rectChoosen[1]+(index-randInt-1)/(rectChoosen[2]-rectChoosen[0]+1);
         return new int[]{x,y};
         
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */