class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->
            Character.compare(b, a)
        );

        for (char ch : freq.keySet()) {
            maxHeap.offer(ch);
        }

        String ans = "";

        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.remove();
            int count = freq.get(ch);

            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) {
                ans+=ch;
            }

            freq.put(ch, count - use);

            if (freq.get(ch) > 0 && !maxHeap.isEmpty()) {
                char nextCh = maxHeap.remove();
                ans+=nextCh;
                freq.put(nextCh, freq.get(nextCh) - 1);
                if (freq.get(nextCh) > 0) {
                    maxHeap.offer(nextCh);
                }
                maxHeap.offer(ch);
            }
        }

        return ans;
    }
}