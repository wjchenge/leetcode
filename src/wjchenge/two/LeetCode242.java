package wjchenge.two;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author wjchenge
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
        int s_length = s.length();
        int t_length = t.length();
        if (s_length != t_length) return false;
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        char[] sum = new char[26];
        for (int i = 0; i < s_length; i++) {
            sum[s_chars[i] - 'a']++;
            sum[t_chars[i] - 'a']--;
        }
        for (char c : sum) {
            if (c != 0) return false;
        }
        return true;
    }

}
