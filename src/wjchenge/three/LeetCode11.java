package wjchenge.three;

/**
 * 11. 盛最多水的容器
 * @author wjchenge
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int w = r - l;
            int h;
            if (height[l] < height[r]) {
                h = height[l++];
            } else {
                h = height[r--];
            }
            maxArea = Math.max(maxArea, w * h);
        }
        return maxArea;
    }

}
