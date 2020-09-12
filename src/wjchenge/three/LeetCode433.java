package wjchenge.three;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        startSet.add(start);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);
        int res = 0;
        List<Character> changeList = Arrays.asList('A', 'C', 'G', 'T');
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> nextStartSet = new HashSet<>();
            for (String str : startSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c : changeList) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (endSet.contains(word)) return ++res;
                        if (bankSet.contains(word)) {
                            nextStartSet.add(word);
                            bankSet.remove(word);
                        }
                    }
                    chars[i] = old;
                }
            }
            startSet = nextStartSet;
            ++res;
        }
        return -1;
    }


}
