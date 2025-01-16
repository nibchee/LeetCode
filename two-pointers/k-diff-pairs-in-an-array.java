class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,HashSet<Integer>> pairs=new HashMap<>();

        for(int num:nums){
           int num_plusK=num+k;
           int num_minusK=num-k;
          HashSet<Integer> s=pairs.get(nums);
               
           if(pairs.containsKey(num_plusK)){
               if(pairs.get(num_plusK)==null || !pairs.get(num_plusK).contains(num)){
               if(s==null){
                s=new HashSet<>();
               }
              s.add(num_plusK);
               pairs.put(num,s);
               }
           }

           if(pairs.containsKey(num_minusK)){
            if(pairs.get(num_minusK)==null || !pairs.get(num_minusK).contains(num)){
               if(s==null){
                s=new HashSet<>();
               }
              s.add(num_minusK);
               pairs.put(num,s);
            }
           }

           if(s==null)
           pairs.put(num,null);

        }
       int ans=0;
        for(Map.Entry<Integer,HashSet<Integer>> entry: pairs.entrySet()){
           HashSet<Integer> set=entry.getValue();
           if(set!=null){
            ans+=set.size();
           }
        }
        return ans;
    }
}