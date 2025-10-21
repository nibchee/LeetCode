class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
       int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        List<int[]> evts = new ArrayList<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            evts.add(new int[]{num - k, 1});
            evts.add(new int[]{num + k + 1, -1});
        }
        
        Set<Integer> points = new TreeSet<>();
        for (int[] evt : evts) {
            points.add(evt[0]);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            points.add(entry.getKey());
        }
        
        Collections.sort(evts, (a, b) -> Integer.compare(a[0], b[0]));
        
        int i = 0;
        int co = 0;
        int ans = 0;
        int ac = 0;
        
        for (int t : points) {
            while (i < evts.size() && evts.get(i)[0] <= t) {
                co += evts.get(i)[1];
                i++;
            }
            
            ac = freq.getOrDefault(t, 0);
            
            int possibleFreq = ac + Math.min(numOperations, co - ac);
            
            ans = Math.max(ans, possibleFreq);
        }
        
        return ans;
    }
    
}