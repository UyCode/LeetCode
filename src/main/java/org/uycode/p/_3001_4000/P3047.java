package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 17/01/2026 12:34:39
 *
 */

public class P3047 {

    public static void main(String[] args) {
        int[][] bottomLeft = {{1,1},{2,2},{3,1}};
        int[][] topRight = {{3,3},{4,4},{6,6}};

        System.out.println(largestSquareArea(bottomLeft, topRight));
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {

        int n = bottomLeft.length;

        long max = 0;
        for (int i = 0; i < n-1; i++) {
            int[] b1 = bottomLeft[i];
            int[] t1 = topRight[i];

            if (t1[0] - b1[0] <= max || t1[1] - b1[1] <= max) continue;

            for (int j = i+1; j < n; j++) {
                int[] b2 = bottomLeft[j];
                int[] t2 = topRight[j];

                int minX = Math.min(t1[0], t2[0]) - Math.max(b1[0], b2[0]);
                int minY = Math.min(t1[1], t2[1]) - Math.max(b1[1], b2[1]);

                int minSide = Math.min(minX, minY);
                max = Math.max(minSide, max);
            }
        }
        return max * max;

    }
}
