package restart.wjchenge.one;

import javax.sound.sampled.EnumControl;
import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
//        return this.bfs(beginWord, endWord, wordSet);
        return this.bfs2(beginWord, endWord, wordSet);

    }

    private int bfs(String beginWord, String endWord, Set<String> wordSet) {
        int res = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                beginWord = q.poll();
                char[] chars = beginWord.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char oldChar = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord)) return res + 1;
                            q.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[i] = oldChar;
                }

            }
            ++res;
        }
        return 0;
    }

    private int bfs2(String beginWord, String endWord, Set<String> wordSet) {
        int res = 1;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for (String beginStr : beginSet) {
                char[] chars = beginStr.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) return res + 1;
                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            newBeginSet.add(newWord);
                        }
                    }
                    chars[i] = oldChar;
                }
            }
            beginSet = newBeginSet;
            ++res;
        }
        return 0;
    }
}
