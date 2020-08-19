package wjchenge.two;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author wjchenge
 */
public class LeetCode329 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int length = nums.length;
        int[] result = new int[length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                result[i] = Math.max(result[i], nums[j]);
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 1) return nums;
        int length = nums.length;
        int[] result = new int[length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= i - k + 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;

    }
}
