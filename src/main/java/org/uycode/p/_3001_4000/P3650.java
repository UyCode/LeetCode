package org.uycode.p._3001_4000;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 27/01/2026 10:02:22
 *
 */

public class P3650 {

    public static void main(String[] args) {
        /*int[][] edges = {{0,1,3}, {3,1,1}, {2,3,4}, {0,2,2}};
        System.out.println(minCost(4, edges));*/

        String s = "abcd";
        String t = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};

        System.out.println(minimumCost(s, t, original, changed, cost));

    }

    public static int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // direct unchanged version
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, 2 * w});
        }

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE); // infinite distance in initialization

        dist[0] = 0; // source node

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{0,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];

            if (visited[u]) continue;

            visited[u] = true;

            if (u == n - 1) {
                return cost;
            }

            for(int[] next: graph.get(u)) {
                int v = next[0];
                int w = next[1];

                if (!visited[v] && cost + w < dist[v]) {
                    dist[v] = cost + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1: dist[n -1];

    }
    private static final int INF = Integer.MAX_VALUE / 2;
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        List<List<int[]>> graph = new ArrayList<>();
        int n = 26;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];

            graph.get(u).add(new int[]{v, w});
        }

        long minCost = 0;

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dijkstra(i, graph, dist[i]);
        }

        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (s == t) continue;
            if (dist[s][t] == INF) return -1;

            minCost += dist[s][t];
        }
        return minCost;
    }

    private static void dijkstra(int start, List<List<int[]>> graph, int[] dist) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        dist[start] = 0;
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue;

            for (int[] e : graph.get(u)) {
                int v = e[0], w = e[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
    }

}
