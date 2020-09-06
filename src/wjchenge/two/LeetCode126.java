package wjchenge.two;

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
        Map<String, List<String>> resMap = new HashMap<>();
        this.bfs(beginWord, endWord, wordSet, resMap);
        List<String> sub = new ArrayList<>();
        sub.add(beginWord);
        this.dfs(beginWord, endWord, resMap, res, sub);
        return res;
    }

    private void dfs(String word, String endWord, Map<String, List<String>> resMap, List<List<String>> res, List<String> sub) {
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(sub));
        }
        List<String> list = resMap.get(word);
        if (list == null) return;
        for (String str : list) {
            sub.add(str);
            this.dfs(str, endWord, resMap, res, sub);
            sub.remove(sub.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> resMap) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        boolean finish = false;
        boolean reverse = false;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                reverse = !reverse;
            }
            wordSet.removeAll(beginSet);
            Set<String> newBeginSet = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (wordSet.contains(newStr)) {
                            if (endSet.contains(newStr)) {
                                finish = true;
                            } else {
                                newBeginSet.add(newStr);
                                String key = reverse ? newStr : str;
                                String val = reverse ? str : newStr;
                                if (!resMap.containsKey(key)) resMap.put(key, new ArrayList<>());
                                resMap.get(key).add(val);
                            }

                        }
                    }
                    chars[i] = old;
                }
            }
            if (finish) break;
            beginSet = newBeginSet;

        }




    }


}
