class Solution {
    public long countSubarrays(int[] nums, int k) {
        // find max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        // count max by sliding window
        int i = 0, j = 0, count = 0;
        int p = 0;
        long total = 0;
        while (j < nums.length) {
            if (nums[j] == max) {
                count++;
            }

            if (count == k) {
                // start shrinking window

                while (count == k && i <= j) {
                    p++;
                    if (nums[i] == max)
                        count--;
                    i++;
                }
                // add in total subarray count

            }
            // ****Important to analyse why adding outside */
            total += p;
            j++;
        }
        return total;
    }
}