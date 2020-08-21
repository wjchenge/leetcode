package wjchenge.one;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author wjchenge
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return true;
        int s_length = s.length();
        int t_length = t.length();
        if (s_length != t_length) return false;
        int[] count = new int[26];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < s_length; i++) {
            count[sArray[i] - 'a']++;
            count[tArray[i] - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

}
