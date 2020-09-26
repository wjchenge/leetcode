package wjchenge.four;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * @author wjchenge
 */
public class LeetCode84 {


    public int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.add(i);
            } else {
                int cur = stack.pop();
                h = heights[cur];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, w * h);
                --i;
            }
        }
        return max;
    }


}
