package wjchenge.one;



import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * @author wjchenge
 */
public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null) return result;
        int length = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List list = new ArrayList();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

}
