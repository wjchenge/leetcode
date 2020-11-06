package restart.wjchenge.two;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        return this.bfs(beginWord, endWord, wordSet);
//        return this.bfs2(beginWord, endWord, wordSet);

    }

    private int bfs(String beginWord, String endWord, Set<String> wordSet) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int num = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                beginWord = q.poll();
                char[] chars = beginWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) return num + 1;
                        if (wordSet.contains(newWord)) {
                            q.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
            ++num;
        }
        return 0;
    }

    private int bfs2(String beginWord, String endWord, Set<String> wordSet) {
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int num = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) return num + 1;
                        if (wordSet.contains(newWord)) {
                            newBeginSet.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = newBeginSet;
            ++num;
        }
        return 0;
    }
}
