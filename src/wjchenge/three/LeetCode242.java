package wjchenge.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author wjchenge
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return s == t;
        int s_length = s.length();
        int t_length = t.length();
        if (s_length != t_length) return false;
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s_chars[i] - 'a']++;
            res[t_chars[i] - 'a']--;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0) return false;
        }
        return true;

    }

}
