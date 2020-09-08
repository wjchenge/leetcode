package wjchenge.three;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author wjchenge
 */
public class LeetCode50 {

    public double myPow(double x, int n) {

        double res = 1.0;
        if (n == 0) return res;
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }

        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= x;
            }
            x *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(-2147483648);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);
        int i0 = Integer.MIN_VALUE;
        long i = i0;
        long i2 = -i0;
        long i3 = -i;
        System.out.println(i2);
        System.out.println(i3);
    }


}
