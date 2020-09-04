package wjchenge.one;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 * @author wjchenge
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        boolean b = true;
        Set<String> wordSet = new HashSet<>(wordList);
        List<Set<Character>> list = new ArrayList<>();
        for (String word : wordSet) {
            if (word.equals(endWord)) b = false;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (list.size() == i) list.add(new HashSet<>());
                list.get(i).add(chars[i]);
            }
        }
        if (b) return 0;
        int num = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                beginWord = q.poll();
                if (beginWord.equals(endWord)) return num;
                char[] chars = beginWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    Set<Character> set = list.get(i);
                    for (char c : set) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (wordSet.contains(newStr)) {
                            q.add(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                    chars[i] = oldChar;
                }
            }
            ++num;
        }
        return 0;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        List<Set<Character>> list = new ArrayList<>();
        for (String word : wordSet) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (list.size() == i) list.add(new HashSet<>());
                list.get(i).add(chars[i]);
            }
        }
        if (!wordSet.contains(endWord)) return 0;
        int num = 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    Set<Character> set = list.get(i);
                    for (char c : set) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (endSet.contains(newStr)) return num + 1;
                        if (wordSet.contains(newStr)) {
                            newBeginSet.add(newStr);
                            wordSet.remove(newStr);
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
