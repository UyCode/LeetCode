package org.uycode.p._1_100;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/05/2025 20:29:22
 */

public class P48 {
    public static void main(String[] args) {
        int[][] matrix = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16},
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][m-1-i];
                matrix[j][m-1-i] = temp;
            }
        }


    }


}
