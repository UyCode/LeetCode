package org.uycode.p._801_900;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 14:01:15
 *
 */

public class P812 {

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
    }

    public static double largestTriangleArea(int[][] points) {

        int row = points.length;
        double ans = 0;
        for (int i = 0; i < row-2; i++) {
            int[] p1 = points[i];
            for (int j = i+1; j < row-1; j++) {
                int[] p2 = points[j];
                for (int k = j+1; k < row; k++) {
                    int[] p3 = points[k];
                    double area = calArea(p1, p2, p3);
                    if (area > ans) {
                        ans = area;
                    }
                }
            }
        }

        return ans;
    }

    private static double calArea(int[] p1, int[] p2, int[] p3) {
        int a = (p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1]) - (p2[0] * p1[1] + p3[0] * p2[1] + p1[0] * p3[1]);
        return 0.5 * Math.abs(a);
    }
}
