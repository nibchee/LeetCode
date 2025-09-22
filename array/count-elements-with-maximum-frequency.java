class Solution {
    public int maxFrequencyElements(int[] nums) {
       HashMap<Integer,Integer> m=new HashMap<>();
       int freq=0;
       for(int i:nums){
           m.put(i,m.getOrDefault(i,0)+1);
           freq=Math.max(freq,m.get(i));
       }
       int sum=0;
       for(Map.Entry<Integer,Integer> entry:m.entrySet()){
           if(entry.getValue()==freq)
           sum+=freq;
       }
       return sum;
    }
}