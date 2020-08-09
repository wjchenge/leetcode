package wjchenge.one;

/**
 * 70. 爬楼梯
 * @author wjchenge
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
