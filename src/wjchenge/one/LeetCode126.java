package wjchenge.one;

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
        Map<String, Set<String>> resMap = new HashMap<>();
        this.bfs(beginWord, endWord, wordSet, resMap);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        this.dfs(res, resMap, beginWord, endWord, list);
        return res;
    }

    private void bfs2(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> resMap) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        boolean finish = false;
        while (!q.isEmpty()) {
            int size = q.size();
            wordSet.removeAll(q);
            while (size-- > 0) {
                beginWord = q.poll();
                char[] chars = beginWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (word.equals(endWord)) finish = true;
                        if (wordSet.contains(word)) {
                            q.add(word);
                            if (!resMap.containsKey(beginWord)) resMap.put(beginWord, new HashSet<>());
                            resMap.get(beginWord).add(word);
                        }
                    }
                    chars[i] = old;
                }
            }
            if (finish) break;
        }
    }

    private void dfs(List<List<String>> res, Map<String, Set<String>> resMap, String word, String endWord, List<String> cur) {
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(cur));
            return;
        }
        Set<String> list = resMap.get(word);
        if (list == null) return;
        for (String str : list) {
            cur.add(str);
            dfs(res, resMap, str, endWord, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> resMap) {
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        boolean reverse = false;
        boolean finish = false;
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
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String word = new String(chars);
                        String key = (reverse ? word : str);
                        String val = (reverse ? str : word);
                        if (endSet.contains(word)) finish = true;
                        if (wordSet.contains(word)) {
                            if (!resMap.containsKey(key)) resMap.put(key, new HashSet<>());
                            resMap.get(key).add(val);
                            nextBeginSet.add(word);
                        }
                    }
                    chars[i] = old;
                }
            }
            if (finish) break;
            beginSet = nextBeginSet;

        }
    }

}
