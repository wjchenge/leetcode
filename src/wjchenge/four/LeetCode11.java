package wjchenge.four;

/**
 * 11. 盛最多水的容器
 * @author wjchenge
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int w = r - l;
            int h = height[l] < height[r] ? height[l++] : height[r--];
            max = Math.max(max, w * h);
        }
        return max;
    }

}
