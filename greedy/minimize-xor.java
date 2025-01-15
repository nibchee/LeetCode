class Solution {
    private int countBits(int n) {
        int c = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                c++;
            n = n >> 1;
        }
        return c;
    }

    public int minimizeXor(int num1, int num2) {
        int bits = countBits(num2);
       // System.out.println(bits);
        int k = 0;
        int ans = 0;
        while (num1 != 0) {

            while (num1!=0 && (num1 & 1) == 0) {
                num1 = num1 >> 1;
                k++;
            }
           // System.out.println(k);
            ans += Math.pow(2, k);
            bits--;
            num1 = num1 >> 1;
                k++;
        }

        while (bits != 0) {
            //System.out.println(k);
            ans += Math.pow(2, k);
            bits--;
            k++;
        }
        return ans;
    }
}