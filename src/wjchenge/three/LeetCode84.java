package wjchenge.three;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * @author wjchenge
 */
public class LeetCode84 {


    public int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;
        int maxArea = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int l = i;
            int r = i;
            int h = heights[i];
            while (l > 0 && heights[l - 1] >= h) --l;
            while (r < length - 1 && heights[r + 1] >= h) ++r;
            maxArea = Math.max(maxArea, (r - l + 1) * h);
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        for (int i = 0; i <= length ; i++) {
            int h = (i == length ? 0 : heights[i]);
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
            } else {
                h = heights[stack.pop()];
                int w = (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, w * h);
                i--;
            }
        }

        return maxArea;
    }

}
