package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 03/02/2026 14:45:17
 *
 */

public class P1266 {

    public static void main(String[] args) {
        int[][] points = {{3,2}, {5, 2}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {

        int n = points.length;
        int total = 0;
        int[] from = points[0];
        for (int i = 1; i < n; i++) {
            int[] to = points[i];
            int x = Math.abs(to[0] - from[0]);
            int y = Math.abs(to[1] - from[1]);
            total += Math.max(x,y);
            from = to;
        }

        return total;
    }
}
