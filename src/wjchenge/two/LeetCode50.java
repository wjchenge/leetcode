package wjchenge.two;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author wjchenge
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        double res = 1.0;
        if (x == 0) return 0;
        if (n == 0) return 1;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        for (; N > 0 ; N /= 2) {
            if (N % 2 == 1) res *= x;
            x *= x;
        }
        return res;
    }




}
