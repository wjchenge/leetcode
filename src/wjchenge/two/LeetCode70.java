package wjchenge.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author wjchenge
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }

    private int climbStairs(int n, Map<Integer, Integer> map) {
        if (n < 3) return n;
        if (map.containsKey(n)) return map.get(n);
        int num = climbStairs(n - 1, map) + climbStairs(n -2, map);
        map.put(n, num);
        return num;
    }

}
