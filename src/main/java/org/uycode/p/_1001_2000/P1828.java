package org.uycode.p._1001_2000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/05/2025 12:57:41
 */

public class P1828 {

    public static void main(String[] args) {
        int[][] points = {
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5}
        };
        int[][] queries = {
                {1,2,2},
                {2,2,2},
                {4,3,2},
                {4,3,3},
        };
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {

        int[] ans = new int[queries.length];


        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            int rSquare = queries[i][2] * queries[i][2];
            for (int[] point : points) {
                if (Math.pow(point[0] - queries[i][0], 2) + Math.pow(point[1] - queries[i][1], 2) <= rSquare) {
                    count++;
                }
            }
            ans[i] = count;
        }


        return ans;
    }
}
