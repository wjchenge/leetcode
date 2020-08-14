package wjchenge.four;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * @author wjchenge
 */
public class LeetCode345 {

//    private static final Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
//            'A', 'E', 'I', 'O', 'U'));
//
//    public String reverseVowels(String s) {
//        if (s == null) return s;
//        int l = 0;
//        int r = s.length() - 1;
//        char[] chars = s.toCharArray();
//        while (l < r) {
//            if (!vowelSet.contains(s.charAt(l))) {
//                ++l;
//            } else if (!vowelSet.contains(s.charAt(r))) {
//                --r;
//            } else  {
//                char tmp = s.charAt(l);
//                chars[l++] = s.charAt(r);
//                chars[r--] = tmp;
//            }
//        }
//        return new String(chars);
//    }


    public String reverseVowels(String s) {
        if (s == null) return s;
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (!isVowel(s.charAt(l))) {
                ++l;
            } else if (!isVowel(s.charAt(r))) {
                --r;
            } else  {
                char tmp = s.charAt(l);
                chars[l++] = s.charAt(r);
                chars[r--] = tmp;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c ||
                'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
            return true;
        } else {
            return false;
        }
    }


}
