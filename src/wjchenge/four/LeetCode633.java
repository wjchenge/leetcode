package wjchenge.four;

/**
 * 633. 平方数之和
 * @author wjchenge
 */
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }


}
