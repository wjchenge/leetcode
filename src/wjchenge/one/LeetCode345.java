package wjchenge.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 345. 反转字符串中的元音字母
 * @author wjchenge
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashMap<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        for (i < j) {
            if (!vowels.contains(chars[i])) {
                ++i;
            } else if (!vowels.contains(chars[j])) {
                --j;
            } else {
                char[] tmp = chars[i];
                chars[i] =  chars[j];
                chars[j] =  chars[i];
            }
        }
        return new String(chars);
    }

}
