class Solution {
    public int trap(int[] height) {

        int max_left[]=new int[height.length];
        int max_right[]=new int[height.length];

        max_left[0]=height[0];
        max_right[height.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++){
            if(height[i]<max_left[i-1]){
                max_left[i]=max_left[i-1];
            }else{
                max_left[i]=height[i];
            }
        }

        for(int j=height.length-2;j>=0;j--){
            if(height[j]<max_right[j+1]){
                max_right[j]=max_right[j+1];
            }else{
                max_right[j]=height[j];
            }
        }

        int water=0;
        for(int k=0;k<height.length;k++){
            water+=Math.min(max_left[k],max_right[k])-height[k];
        }

        return water;
    }
}