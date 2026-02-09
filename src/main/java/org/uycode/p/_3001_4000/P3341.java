package org.uycode.p._3001_4000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 07/05/2025 22:27:04
 */

public class P3341 {

    public static void main(String[] args) {
        int[][] nums = {
                {0,4},
                {4,4},
        };

        System.out.println(minTimeToReach(nums));
    }

    public static int minTimeToReach(int[][] moveTime) {
        // Dijkstra，并允许同一个节点的重复访问
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 最小堆，存储数组 {t, x, y}，表示到达 (x, y) 的时间为 t
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // 起点
        heap.offer(new int[]{0, 0, 0});

        int n = moveTime.length, m = moveTime[0].length;
        // time[i][j]表示到达(i,j)的最少时间
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        time[0][0] = 0; // 初始化

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int t = curr[0], x = curr[1], y = curr[2];
            if (t > time[x][y]) { // 剪枝
                continue;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    int nt;
                    if (t < moveTime[nx][ny]) { // 需要等待
                        nt = 1 + moveTime[nx][ny];
                    } else { // 否则，直接进入
                        nt = t + 1;
                    }
                    if (nt < time[nx][ny]) { // 当前的更优路径
                        time[nx][ny] = nt;
                        heap.offer(new int[]{nt, nx, ny});
                    }
                }
            }
        }

        return time[n - 1][m - 1]; // 终点


    }


}
