package wjchenge.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author wjchenge
 */
public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int length = nums.length;
        int[] result = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
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
        int r = 0;
        for (int i = 0; i < length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[r++] = nums[deque.peekFirst()];
            }

        }
        return result;
    }

    public int[] maxSlidingWindow3(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

}
