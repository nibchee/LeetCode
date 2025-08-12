class Solution {
    private int getPrefixLength(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        if (n <= 1) return new int[n];

        int[] adj = new int[n - 1];           
           int[] skip = new int[n - 2];     

        for (int i = 0; i < n - 1; i++) {
            adj[i] = getPrefixLength(words[i], words[i + 1]);
            if (i + 2 < n) skip[i] = getPrefixLength(words[i], words[i + 2]);
        }

        int[] leftMax = new int[n - 1];
        leftMax[0] = adj[0];
        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], adj[i]);
        }

        int[] rightMax = new int[n - 1];
        rightMax[n - 2] = adj[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], adj[i]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int best = 0;
            if (i > 0) best = Math.max(best, rightMax[0] == adj[i - 1] && n > 2 ? (i > 1 ? leftMax[i - 2] : 0) : leftMax[i - 1]);
            if (i < n - 1) best = Math.max(best, i < n - 2 ? rightMax[i + 1] : 0);
            if (i > 0 && i < n - 1) best = Math.max(best, skip[i - 1]);
            ans[i] = best;
        }

        return ans;
    }
}
