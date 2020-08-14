package wjchenge.four;

/**
 * 680. 验证回文字符串 Ⅱ
 * @author wjchenge
 */
public class LeetCode680 {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                ++l;
                --r;
            } else {
                return isValidPalindrome(s, l + 1, r) || isValidPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    private boolean isValidPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                ++l;
                --r;
            } else {
                return false;
            }
        }
        return true;
    }


}
