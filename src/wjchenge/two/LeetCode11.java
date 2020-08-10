package wjchenge.two;

/**
 * 11. 盛最多水的容器
 * @author wjchenge
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        int w,h;
        while (l < r) {
            w = r - l;
            if (height[l] < height[r]) {
                h = height[l++];
            } else {
                h = height[r--];
            }
            result = Math.max(result, w * h);
        }
        return result;
    }

}
