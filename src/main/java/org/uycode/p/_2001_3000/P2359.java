package org.uycode.p._2001_3000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 30/05/2025 12:09:09
 */

public class P2359 {


    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{2,2,3,-1}, 0, 1));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {

        int[] dist1 = calcDist(edges, node1);
        int[] dist2 = calcDist(edges, node2);

        int n = edges.length;
        int minDist = n;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int d = Math.max(dist1[i], dist2[i]);
            if (d < minDist) {
                minDist = d;
                ans = i;
            }
        }

        return ans;
    }

    private static int[] calcDist(int[] edges, int x) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, n);
        int d = 0;
        while (x >=0 && dist[x] == n) {
            dist[x] = d++;
            x = edges[x];
        }

        return dist;
    }
}
