package wjchenge.two;

import java.util.Map;
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
        int length = height.length;
        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            int l_max = height[i];
            int r_max = l_max;
            int l = i - 1;
            while (l >= 0) {
                l_max = Math.max(l_max, height[l--]);
            }
            int r = i + 1;
            while (r < length) {
                r_max = Math.max(r_max, height[r++]);
            }
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
        int length = height.length;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int w = i - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[i]) - height[top];
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
        int l = 0;
        int r = height.length - 1;
        int max_l = 0;
        int max_r = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > max_l) {
                    max_l = height[l];
                } else {
                    sum += max_l - height[l];
                }
                ++l;
            } else {
                if (height[r] > max_r) {
                    max_r = height[r];
                } else {
                    sum += max_r - height[r];
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
