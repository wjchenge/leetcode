package wjchenge.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * @author wjchenge
 */
public class LeetCode524 {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        if (s == null || s.length() == 0 || d == null || d.isEmpty()) return result;
        for (String str : d) {
            if (str == null
                    || result.length() > str.length()
                    || str.length() > s.length()
                    || (str.length() == result.length() && result.compareTo(str) < 0)) {
                continue;
            }
            int i = 0;
            int j = 0;
            char[] sChars = s.toCharArray();
            char[] strChars = str.toCharArray();
            while (i < sChars.length && j < strChars.length) {
                if (sChars[i] == strChars[j]) {
                    ++i;
                    ++j;
                } else {
                    ++i;
                }
            }
            if (j == str.length()) {
                result = str;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add(null);
        d.add(null);
        d.add(null);
        System.out.println(d);
    }

}
