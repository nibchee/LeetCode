class Solution {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / (x * myPow(x, -(n + 1)));
        if (n == 1)
            return x;

        if (n == 0)
            return 1.0;

        double result = myPow(x, n / 2);
        return n % 2 == 0 ? result * result : result * result * x;
    }
}