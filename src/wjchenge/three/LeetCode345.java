package wjchenge.three;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * @author wjchenge
 */
public class LeetCode345 {

    private final static Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!vowels.contains(chars[i])) {
                ++i;
            } else if (!vowels.contains(chars[j])) {
                --j;
            } else {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }

}
