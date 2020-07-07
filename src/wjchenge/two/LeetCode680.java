package wjchenge.two;

/**
 * 680. 验证回文字符串 Ⅱ
 * @author wjchenge
 */
public class LeetCode680 {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return this.isPalindrome(chars, begin + 1, end) || this.isPalindrome(chars, begin , end - 1);
            }
            ++begin;
            --end;
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            ++begin;
            --end;
        }
        return true;
    }

}
