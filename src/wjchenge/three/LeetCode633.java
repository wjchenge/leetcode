package wjchenge.three;

/**
 * 633. 平方数之和
 * @author wjchenge
 */
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int pow = i * i + j * j;
            if (pow == c) {
                return true;
            } else if (pow > c) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }

}
