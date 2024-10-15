class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
     HashMap<Integer,Integer> map=new HashMap<>();
      PriorityQueue<Integer> pq=new PriorityQueue<>(
        (a,b)->{
          return map.get(a)-map.get(b)
        }
       ); 

   return new long[0];
    }

   
}