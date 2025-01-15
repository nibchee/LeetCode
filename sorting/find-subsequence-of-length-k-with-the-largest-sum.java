class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
       PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->(a[0]-b[0]));

       for(int i=0;i<n;i++){
        q.add(new int[]{nums[i],i});
        if(q.size()>k)
        q.remove();
       }

      PriorityQueue<int[]> q2=new PriorityQueue<>((a,b)->(a[1]-b[1]));
       q2.addAll(q);
       int ans[]=new int[k];
         int i=0;
         while(!q.isEmpty()){
            int[] e=q.remove();
            ans[i++]=e[0];
         }
       return ans;
       }
}