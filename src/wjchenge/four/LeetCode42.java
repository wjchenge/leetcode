package wjchenge.four;

import java.util.Stack;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author wjchenge
 */
public class LeetCode42 {

    /**
     * 栈
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = height[stack.pop()];
                if (stack.isEmpty()) break;
                int w = i - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[i]) - top;
                sum += w * h;
            }
            stack.add(i);
        }
        return sum;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int l_max = 0;
        int r_max = 0;
        int sum = 0;
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

}
