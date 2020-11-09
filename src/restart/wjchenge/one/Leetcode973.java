package restart.wjchenge.one;

import java.util.*;

/**
 * 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class Leetcode973 {

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> q = new PriorityQueue<>(K, Comparator.comparingInt(v -> v[0] * v[0] + v[1] * v[1]));
        for (int[] p : points) {
            q.add(p);
        }
        int i = 0;
        while (!q.isEmpty() && i < K) {
            res[i++] = q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        new Leetcode973().kClosest(new int[][] {{1,3},{-2,2}}, 1);
    }

}
