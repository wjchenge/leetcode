package wjchenge.one;

import javax.lang.model.element.NestingKind;
import javax.sound.sampled.EnumControl;
import java.util.*;

/**
 * 433. 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * @author wjchenge
 */
public class LeetCode433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        List<Character> changeChars = Arrays.asList('A', 'C', 'G', 'T');
        int num = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> newStartSet = new HashSet<>();
            for (String str : startSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c : changeChars) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (endSet.contains(newStr)) return num + 1;
                        if (bankSet.contains(newStr)) {
                            newStartSet.add(newStr);
                            bankSet.remove(newStr);
                        }
                    }
                    chars[i] = old;
                }
            }
            startSet = newStartSet;
            ++num;
        }
        return -1;
    }

    public static void main(String[] args) {
        new LeetCode433().minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"});
    }

}
