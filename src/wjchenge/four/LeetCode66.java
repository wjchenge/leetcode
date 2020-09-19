package wjchenge.four;

/**
 * 66. 加一
 * @author wjchenge
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry == 1; --i) {
            int sum = digits[i] + carry;
            if (sum == 10) {
                carry = 1;
                sum = 0;
            } else {
                carry = 0;
            }
            digits[i] = sum;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

}
