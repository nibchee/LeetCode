class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> row = null;
        row = new ArrayList<>();
        row.add(1);
        result.add(row);

        if (numRows == 1) return result;

        for (int i = 2; i <= numRows; i++) {

            int left = 0, right = i - 1;
            int rowArray[] = new int[i];
            rowArray[left++] = 1;
            rowArray[right--] = 1;

            List<Integer> prev = result.get(i - 2);

            while (left <= right) {
                rowArray[left] = prev.get(left - 1) + prev.get(left);
                rowArray[right] = prev.get(right) + prev.get(right - 1);
                left++;
                right--;
            }

            row = new ArrayList<>();

            for (int num : rowArray) row.add(num);

            result.add(row);
        }
        return result;
    }
}