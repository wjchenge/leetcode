package wjchenge.three;

/**
 * 66. 加一
 * @author wjchenge
 */
public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry == 1; --i) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;

    }

}
