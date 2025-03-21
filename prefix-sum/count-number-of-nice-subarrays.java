class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int windowSize = 0, subarrays = 0, start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSize += nums[end] % 2;
           
            while (windowSize > k) {
                windowSize -= nums[start] % 2;
                start++;
            }
            subarrays += end - start + 1;
        }

        return subarrays;
    }
}