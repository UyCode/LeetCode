package org.uycode.p._301_400;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 18/03/2026 17:22:21
 *
 */

public class P304 {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        NumMatrix(mat);
    }

    private static int[][] sum;

    public static void NumMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        sum = new int[n+1][m+1];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
               sum[row +1][col + 1] = sum[row + 1][col] + sum[row][col+1] - sum[row][col] + matrix[row][col];
            }
        }

        for (int[] ints : sum) {
            System.out.println(Arrays.toString(ints));
        }

        //System.out.println(Arrays.deepToString(sum));

    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}
