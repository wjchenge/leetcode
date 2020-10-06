package wjchenge.four;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author wjchenge
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
        int s_len = s.length();
        int t_len = t.length();
        if (s_len != t_len) return false;
        int[] chars = new int[26];
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chars[s_chars[i] - 'a']++;
            chars[t_chars[i] - 'a']--;
        }

        for (int i : chars) {
            if (i != 0) return false;
        }
        return true;

    }

}
