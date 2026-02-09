package org.uycode.p._3001_4000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/05/2025 18:11:36
 */

public class P3446 {

    public static void main(String[] args) {
        int[][] grid = {
                {0,1},
                {1,2}
        };
        System.out.println(Arrays.deepToString(sortMatrix(grid)));
    }

    public static int[][] sortMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        int[] center = new int[m];
        for (int i = 0; i < m; i++) {
            center[i] = grid[i][i];
        }
        Arrays.sort(center);
        for (int i = 0; i < m; i++) {
            res[m-i-1][n-i-1] = center[i];
        }

        int k = m-1;
        for (int i = 1; i < m-1; i++) {
            int[] below = new int[k];
            int[] above = new int[k];
            for (int j = 0; j < k; j++) {
                below[j] = grid[i+j][j];
                above[j] = grid[j][i+j];
            }
            Arrays.sort(below);
            Arrays.sort(above);
            for (int j = 0; j < k; j++) {
                res[i+j][j] = below[k-j-1];
                res[j][i+j] = above[j];
            }
            k--;
        }

        res[m-1][0] = grid[m-1][0];
        res[0][n-1] = grid[0][n-1];

        return res;

    }
}
