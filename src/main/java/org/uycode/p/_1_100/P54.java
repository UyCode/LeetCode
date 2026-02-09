package org.uycode.p._1_100;

import org.uycode.common.ListNode;

import java.security.interfaces.DSAParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/05/2025 11:50:23
 */

public class P54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        Map<String, Integer> map = new HashMap<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int rotation = m + n - 1;

        int k = 0;
        int p = 0;
        while (rotation > 0) {
            if (k > 0 &&k % 4 == 0) {
                p++;
            }
            int[] first = matrix[p];
            for (int i = 0; i < n; i++) {
                if (map.get(k + "" + i) == null) {
                    map.put(k + "" + i, first[i]);
                }
            }

            rotateCounterClockwise(matrix);
            rotation--;
            k++;
        }



        return null;
    }
    public static void rotateCounterClockwise(int[][] matrix) {
        int n = matrix.length;

        // 1. 转置矩阵 (行列互换)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 上下翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
    }
}
