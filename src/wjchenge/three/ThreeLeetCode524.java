package wjchenge.three;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * @author wjchenge
 */
public class ThreeLeetCode524 {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        if (s == null || s.length() == 0 || d == null || d.isEmpty()) return result;
        for (String word : d) {
            if (word == null || word.length() > s.length()
                    || result.length() > word.length()
                    || (word.length() == result.length() && result.compareTo(word) < 0)) {
                continue;
            }

            int i = 0;
            int j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    ++j;
                }
                ++i;
            }
            if (j == word.length()) {
                result = word;
            }
        }
        return result;
    }

}
