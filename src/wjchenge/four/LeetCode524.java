package wjchenge.four;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * @author wjchenge
 */
public class LeetCode524 {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        int sLength = s.length();
        if (s == null || d == null) return result;
        for (String sub : d) {
            if (sub == null ||
                    sub.length() > sLength ||
                    sub.length() < result.length() ||
                    (sub.length() == result.length() && result.compareTo(sub) < 0)) {
                continue;
            }

            int j = 0;
            for (int i = 0; i < sLength && j < sub.length(); i++) {
                if (sub.charAt(i) == s.charAt(j)) {
                    ++j;
                }
            }
            if (j == sub.length()) {
                result = sub;
            }
        }
        return result;
    }

}
