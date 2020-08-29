package wjchenge.three;

import java.util.Stack;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author wjchenge
 */
public class LeetCode42 {

    /**
     * 暴力
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null) return 0;
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int l = i;
            int r = i;
            int l_max = height[i];
            int r_max = height[i];
            while (l >= 0) l_max = Math.max(l_max, height[l--]);
            while (r < height.length) r_max = Math.max(r_max, height[r++]);
            sum += Math.min(l_max, r_max) - height[i];
        }
        return sum;
    }

    /**
     * 栈
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null) return 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = height[stack.pop()];
                if (stack.isEmpty()) break;
                int w = i - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[i]) - top;
                sum += w * h;
            }
            stack.push(i);
        }
        return sum;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if (height == null) return 0;
        int sum = 0;
        int l = 0, r = height.length - 1;
        int l_max = 0, r_max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > l_max) {
                    l_max = height[l];
                } else {
                    sum += l_max - height[l];
                }
                ++l;
            } else {
                if (height[r] > r_max) {
                    r_max = height[r];
                } else {
                    sum += r_max - height[r];
                }
                --r;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        new LeetCode42().trap2(a);
    }

}
