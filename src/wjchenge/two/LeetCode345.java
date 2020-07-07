package wjchenge.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * @author wjchenge
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            if (!vowels.contains(chars[begin])) {
                ++begin;
            } else if (vowels.contains(chars[end])) {
                --end;
            } else {
                char tmp = chars[begin];
                chars[begin++] = chars[end];
                chars[end--] = tmp;
            }
        }
        return new String(chars);
    }

}
