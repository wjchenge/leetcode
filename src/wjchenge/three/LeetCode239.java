package wjchenge.three;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author wjchenge
 */
public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ret = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
            ret[i] = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                ret[i] = Math.max(ret[i], nums[j]);
            }
        }
        return ret;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 1) return nums;
        int length = nums.length;
        int[] ret = new int[length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int r = 0;
        for (int i = 0; i < length; i++) {
            if (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.remove();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.add(i);
            if (i - k + 1 >= 0) {
                ret[r++] = nums[queue.peek()];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] n = {1,3,-1,-3,5,3,6,7};
        int[] n = {1,3,1,2,0,5};
        new LeetCode239().maxSlidingWindow2(n, 3);
    }
}
