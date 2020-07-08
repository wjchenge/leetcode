package wjchenge.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * @author wjchenge
 */
public class LeetCode524 {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        if (s == null || s.length() == 0
                || d == null || d.isEmpty()) return result;
        for (String word : d) {
            if (word == null
                    || word.length() > s.length()
                    || word.length() < result.length()
                    || (word.length() == result.length()
                    && result.compareTo(word) < 0)) {
                continue;
            }
            char[] sChars = s.toCharArray();
            char[] wordChars = word.toCharArray();
            int i = 0;
            int j = 0;
            while (i < sChars.length && j < wordChars.length) {
                if (sChars[i] == wordChars[j]) {
                    ++j;
                }
                ++i;
            }
            if (j == wordChars.length) {
                result = word;
            }
        }
        return result;
    }

}
