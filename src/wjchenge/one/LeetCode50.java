package wjchenge.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author wjchenge
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        double res = 1.0;
        if (n == 0) return res;
        if (x == 0) return 0.0;
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= x;
            }
            System.out.println("i = " + i + " -- res = " + res + "---x = " + x);
            x *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        new LeetCode50().myPow(2, 9);
    }



}
