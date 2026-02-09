package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/02/2026 10:59:36
 *
 */

public class P1351 {

    public static void main(String[] args) {

        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (grid[n-1][m-1] >= 0) {
            return 0;
        }

        if (grid[0][0] < 0) {
            return grid.length * grid[0].length;
        }

        int count = 0;
        int jBound = 0;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >= jBound; j--) {
                if (grid[i][j] < 0) {
                    count++;
                } else {
                      jBound = j;
                }
            }
        }

        return count;
    }
}
