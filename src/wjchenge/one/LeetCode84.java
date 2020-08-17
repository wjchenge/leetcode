package wjchenge.one;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * @author wjchenge
 */
public class LeetCode84 {

//    public int largestRectangleArea(int[] heights) {
//        if (heights == null) return 0;
//        int length = heights.length;
//        int maxArea = 0;
//        for (int i = 0; i < length; i++) {
//            int l = i;
//            int r = i;
//            int val = heights[i];
//            while (l > 0 && val <= heights[l - 1]) --l;
//            while (r < length - 1 && val <= heights[r + 1]) ++r;
//            maxArea = Math.max(maxArea, (r - l + 1) * val);
//        }
//        return maxArea;
//    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;
        int maxArea = 0;
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= length; i++) {
            int h = (i == length ? 0 : heights[i]);
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
            } else {
                h = heights[stack.pop()];
                int w = (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, w * h);
                --i;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,1,5,6,2,3};
        new LeetCode84().largestRectangleArea(ints);
    }

}
