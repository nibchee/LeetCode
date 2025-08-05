class Solution {
    long[] cd;

    private int findSetBit(int n) {
        int numberOfSetBit = 0;
        while (n > 0) {
            n = n & (n - 1);
            numberOfSetBit++;
        }
        return numberOfSetBit;
    }

    private long computeDepth(int num) {
        if(num==1 || num==0) return 0;
        if (cd[num] != 0)
            return cd[num];

        int setBits = findSetBit(num);
        cd[num] = computeDepth(setBits) + 1;
        return cd[num];
    }

    public long popcountDepth(long n, int k) {
     if(k==0) return 1;
    int max = (int) Math.min(n + 2, Integer.MAX_VALUE);
    cd = new long[max];
    cd[0] = cd[1] = 0;

    long ans = 0;
    for (int i = 2; i <= n; i++) {
        cd[i] = computeDepth(i);
        //System.out.println(i+" N "+cd[i]);
        if (cd[i] == k)
            ans++;
    }

    return ans;
}

}
