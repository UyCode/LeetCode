package org.uycode.p._2001_3000;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/05/2025 20:28:02
 */

public class P2462 {

    public static void main(String[] args) {
        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println(totalCost(costs, 3, 4));
    }

    public static long totalCost(int[] costs, int k, int candidates) {


        PriorityQueue<int[]> pre = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> suf = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        long sum = 0;
        int n = costs.length;
        int preIndex = candidates;
        int sufIndex = n - candidates - 1;

        for (int i = 0; i < Math.min(n, candidates); i++) {
            pre.offer(new int[]{i, costs[i]});
            suf.offer(new int[]{n - i - 1, costs[n - i - 1]});
        }

        boolean[] visited = new boolean[n];

        while (k-- > 0) {

            while (visited[pre.peek()[0]]) {
                pre.poll();
                if (preIndex < n) pre.offer(new int[]{preIndex, costs[preIndex++]});
            }

            while (visited[suf.peek()[0]]) {
                suf.poll();
                if (sufIndex >= 0) suf.offer(new int[]{sufIndex, costs[sufIndex--]});
            }
            int[] p = pre.peek();
            int[] s = suf.peek();
            if (p[1] <= s[1]) {
                sum += p[1];
                visited[p[0]] = true;
                pre.poll();
                if (preIndex < n) pre.offer(new int[]{preIndex, costs[preIndex++]});
            } else {
                sum += s[1];
                visited[s[0]] = true;
                suf.poll();
                if (sufIndex >= 0) suf.offer(new int[]{sufIndex, costs[sufIndex--]});
            }
        }

        return sum;
    }

}
