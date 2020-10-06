package wjchenge.four;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author wjchenge
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        int[] tmp = new int[n + 1];
        tmp[0] = 1;
        tmp[1] = 2;
        for (int i = 2; i <= n; i++) {
            tmp[i] = tmp[i - 1] + tmp[i - 2];
        }
        return tmp[n];
    }


}
