class Solution {
    public int getPrefixLength(String s1, String s2) {
        int i = 0;
        int minLength = Math.min(s1.length(), s2.length());
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[][] longPrefix = new int[n - 1][2];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            longPrefix[i][0] = getPrefixLength(words[i], words[i + 1]);
            if (i + 2 < n) {
                longPrefix[i][1] = getPrefixLength(words[i], words[i + 2]);
            } else {
                longPrefix[i][1] = 0;
            }
            maxHeap.add(longPrefix[i][0]);
            // maxHeap.add(longPrefix[i][1]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < longPrefix.length; i++) {
            //System.out.println(longPrefix[i][0] + " " + longPrefix[i][1]);
            if (i - 1 >= 0) {
                maxHeap.remove(longPrefix[i - 1][0]);
                maxHeap.add(longPrefix[i - 1][1]);
            }
            maxHeap.remove(longPrefix[i][0]);

            ans[i] = maxHeap.peek() != null ? maxHeap.peek() : 0;
            if (i - 1 >= 0) {
                maxHeap.add(longPrefix[i - 1][0]);
                maxHeap.remove(longPrefix[i - 1][1]);
            }
            maxHeap.add(longPrefix[i][0]);

        }
        if(n>1)
        maxHeap.remove(longPrefix[n-2][0]);
        ans[n - 1] = maxHeap.peek() != null ? maxHeap.peek() : 0;
        return ans;
    }

}