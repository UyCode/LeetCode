package org.uycode.p;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/05/2025 11:13:04
 */

public class PQ2 {

    public static void main(String[] args) {

        int[][] grid = {
                {1,4},
                {2,3},
        };

        System.out.println(canPartitionGrid(grid));
    }

    public static boolean canPartitionGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 2) return grid[0][0] == grid[0][1];
        if (m == 2 && n == 1) return grid[0][0] == grid[1][0];

        // 计算总和
        long totalSum = 0;
        for (int[] g : grid) {
            for (int j = 0; j < n; j++) {
                totalSum += g[j];
            }
        }

        // 如果总和是奇数，直接返回false
        if (totalSum % 2 != 0) return false;
        long target = totalSum / 2;

        // 检查水平分割线
        long currentRowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            currentRowSum += rowSum;
            if (currentRowSum == target) {
                return true;
            }
        }

        // 检查垂直分割线
        long currentColSum = 0;
        for (int j = 0; j < n - 1; j++) {
            long colSum = 0;
            for (int[] g : grid) {
                colSum += g[j];
            }
            currentColSum += colSum;
            if (currentColSum == target) {
                return true;
            }
        }

        return false;
    }
}
