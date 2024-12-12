class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       // int oldcolor=image[sr][sc];
        dfs(image,sr,sc,color);
        return image;
    }

    private void dfs(int[][]img,int i,int j,int color){
        if(i<0 || i>=img.length || j<0 || j>=img[0].length || img[i][j]==0 || img[i][j]==color)
        return;

        img[i][j]=color;
        dfs(img,i-1,j,color);
        dfs(img,i+1,j,color);
        dfs(img,i,j-1,color);
        dfs(img,i,j+1,color);
    }


}