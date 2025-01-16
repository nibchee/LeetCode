class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {

            int idx = bs(ages, i);
            // System.out.println(idx);
            if (idx != i) {
                ans += (i - idx);
                if (ages[i] == ages[idx])
                    ans += (i - idx);
            }

        }
        return ans;
    }

    private int bs(int[] ages, int high) {
        // System.out.println("IDX:"+high);
        int x = ages[high];
        double target = x * 0.5 + 7;
        int h = high - 1;
        int l = 0;
        int ans = high;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ages[mid] > target) {
                // System.out.println(ans);
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // System.out.println("----------------------------");
        return ans;
    }
}

/**
 * Total Frined Request
 * Arrays.sortA
 * 
 */