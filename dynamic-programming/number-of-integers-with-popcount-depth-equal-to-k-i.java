import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Long> cd = new HashMap<>();

    private int findSetBit(int n) {
        int numberOfSetBit = 0;
        while (n > 0) {
            n &= (n - 1);
            numberOfSetBit++;
        }
        return numberOfSetBit;
    }

    private long computeDepth(int num) {
        if (num == 0 || num == 1)
            return 0;

        if (cd.containsKey(num))
            return cd.get(num);

        int setBits = findSetBit(num);
        long depth = computeDepth(setBits) + 1;
        cd.put(num, depth);
        return depth;
    }

    public long popcountDepth(long n, int k) {
        if (k == 0)
            return 1;

        long ans = 0;
        for (int i = 2; i <= n; i++) {
            long depth = computeDepth(i);
            if (depth == k)
                ans++;
        }
        return ans;
    }
}
