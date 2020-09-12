package wjchenge.three;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 * @author wjchenge
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int res = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> nextBeginSet = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String word = new String(chars);
                        if (endSet.contains(word)) return ++res;
                        if (wordSet.contains(word)) {
                            nextBeginSet.add(word);
                            wordSet.remove(word);
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = nextBeginSet;
            ++res;
        }
        return 0;
    }



}
