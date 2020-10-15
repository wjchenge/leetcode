package wjchenge.four;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author wjchenge
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        double res = 1.0;
        if (x == 0) return x;
        if (n == 0) return res;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        for (long i = N; i > 0 ; i /= 2) {
            if (i % 2 == 1) {
                res *= x;
            }
            x *= x;
        }
        return res;
    }

}
