package wjchenge.one;

/**
 * 11. 盛最多水的容器
 * @author wjchenge
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        int h;
        int w;
        while (l < r) {
            w = r - l;
            if (height[l] < height[r]) {
                h = height[l++];
            } else {
                h = height[r--];
            }
            max = Math.max(max, w * h);
        }
        return max;
    }

}
