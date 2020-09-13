package wjchenge.three;

import java.util.*;

/**
 * 126. 单词接龙 II
 * https://leetcode-cn.com/problems/word-ladder-ii/
 * @author wjchenge
 */
public class LeetCode126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        this.bfs(beginWord, endWord, wordSet, map);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        this.dfs(beginWord, endWord, res, list, map);
        return res;
    }

    private void dfs(String beginWord, String endWord, List<List<String>> res, List<String> list, Map<String, List<String>> map) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        List<String> wordList = map.get(beginWord);
        if (wordList == null) return;
        for (String word : wordList) {
            list.add(word);
            this.dfs(word, endWord, res, list, map);
            list.remove(list.size() - 1);
        }

    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> map) {
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        boolean finsh = false;
        boolean reverse = false;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                reverse = !reverse;
            }
            wordSet.removeAll(beginSet);
            Set<String> nextBeginSet = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (wordSet.contains(word)) {
                            nextBeginSet.add(word);
                            if (endSet.contains(word)) finsh = true;
                            String key = reverse ? word : str;
                            String val = reverse ? str : word;
                            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                            map.get(key).add(val);

                        }
                    }
                    chars[i] = old;
                }
            }
            if (finsh) break;
            beginSet = nextBeginSet;
        }
    }


}
