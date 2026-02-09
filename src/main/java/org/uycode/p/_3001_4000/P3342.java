package org.uycode.p._3001_4000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/05/2025 12:38:09
 */

public class P3342 {

    public static void main(String[] args) {

    }
    public int minTimeToReach(int[][] moveTime) {
        //使用优先队列 默认 降序 对头的时间最少就可以了
        PriorityQueue<node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        int n = moveTime.length, m = moveTime[0].length, k;
        Boolean[][] visited = new Boolean[n][m];
        int[] dx = new int[]{0, 0, 1, -1}, dy = new int[]{1, -1, 0, 0};
        for(int i = 0; i < n; i++) Arrays.fill(visited[i], false);
        queue.add(new node(0, 0, 1, 0));
        while (!queue.isEmpty()) {
            var t = queue.poll();
            if(visited[t.x][t.y]) continue;
            visited[t.x][t.y] = true;
            for(int i = 0; i < 4; i++){
                int x = t.x + dx[i], y = t.y + dy[i];
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) continue;
                if(t.count % 2 == 0) k = 2; else k = 1;
                int time = t.time >= moveTime[x][y] ? t.time + k : moveTime[x][y] + k;
                queue.add(new node(x, y, k + 1, time));
                if(x == n - 1 && y == m - 1) return time;
            }
        }
        return -1;
    }
    static class node{
        int x, y,count,time;
        public node(int x, int y, int count,int time){
            this.x = x;
            this.y = y;
            this.count = count;
            this.time = time;
        }
    }


}
