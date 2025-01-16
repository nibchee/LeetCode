class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int idx1 = bs(ages, i, ages[i] * 0.5 + 7);
            int idx2 = bs2(ages, i, ages[i]);
            ans += (i - idx2);
         //    System.out.println(idx1+" "+idx2);
            if (idx1 != i) {
                ans += (i - idx1);
            }

        }
        return ans;
    }

    private int bs(int[] ages, int high, double target) {
        // System.out.println("IDX:"+high);
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
private int bs2(int[] ages, int high, double target) {
        // System.out.println("IDX:"+high);
        int h = high - 1;
        int l = 0;
        int ans = high;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ages[mid] >= target) {
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