class Solution {
    public long findScore(int[] nums) {
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.getKey() == p2.getKey())
                        return p1.getValue() - p2.getValue();
                    return p1.getKey() - p2.getKey();
                });

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair<>(nums[i], i));
        }
        long sum = 0;

        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> p = minHeap.poll();
            int val = p.getKey();
            int idx= p.getValue();
            if (nums[idx]!=-1) {
                sum += val;
                nums[idx] = -1;
                if (idx - 1 >= 0)  nums[idx - 1] = -1;
                if (idx + 1 < nums.length) nums[idx + 1] = -1;
            }
        }
        return sum;
    }
}