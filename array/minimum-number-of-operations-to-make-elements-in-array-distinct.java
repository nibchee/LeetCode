class Solution {
    public int minimumOperations(int[] nums) {
       HashMap<Integer,Integer> freq=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
       }

       int n=nums.length;
       int j=0;
       int ans=0;
       while(!distinct(freq)){
        int k=j+3;
        while(j<n && j<k){
            freq.put(nums[j],freq.get(nums[j])-1);
            if(freq.get(nums[j])==0) freq.remove(nums[j]);
            j++;
        }
          ans++;
       }
    return ans;
    }

    private boolean distinct(HashMap<Integer,Integer> map){
        for(Integer val:map.values()){
            if(val>1){
                return false;
            }
        }
        return true;
    } 
}