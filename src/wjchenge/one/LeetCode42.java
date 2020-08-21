package wjchenge.one;

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
            int l = height[i];
            int r = height[i];
            int k = i - 1;
            while (k >= 0) {
                l = Math.max(l , height[k--]);
            }
            k = i + 1;
            while (k < length) {
                r = Math.max(r , height[k++]);
            }

            sum += Math.min(l, r) - height[i];

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
            while (!stack.isEmpty() && height[stack.peek()] < height[i] ) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int w = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[top];
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
        int l_val = 0;
        int r_val = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > l_val) {
                    l_val = height[l];
                } else {
                    sum += l_val - height[l];
                }
                ++l;
            } else {
                if (height[r] > r_val) {
                    r_val = height[r];
                } else {
                    sum += r_val - height[r];
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
