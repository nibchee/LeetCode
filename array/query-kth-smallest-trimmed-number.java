
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len = nums[0].length();
        int n = nums.length;
        long[][][] ds = new long[len][n][2];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                String trimmed = nums[j].substring(len - i - 1);
                long num = Long.parseLong(trimmed); 
                ds[i][j][0] = num;
                ds[i][j][1] = j; 
            }
         
            Arrays.sort(ds[i], (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]); 
            });
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0] - 1; 
            int trim = queries[i][1] - 1;
            ans[i] = (int) ds[trim][k][1];
        }
        
        return ans;
    }
}
