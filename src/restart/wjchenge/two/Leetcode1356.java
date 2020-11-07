package restart.wjchenge.two;

import java.util.*;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class Leetcode1356 {

    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            int val = arr[i];
            while (val != 0) {
                ++num;
                val = val & (val - 1);
            }
//            map.getOrDefault(num, new ArrayList<>()).add(arr[i]);
            if (!map.containsKey(num)) map.put(num, new ArrayList<>());
            map.get(num).add(arr[i]);
        }
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            for (int v : entry.getValue()) {
                arr[i++] = v;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1024,512,256,128,64,32,16,8,4,2,1};
        new Leetcode1356().sortByBits(n);
    }
}
