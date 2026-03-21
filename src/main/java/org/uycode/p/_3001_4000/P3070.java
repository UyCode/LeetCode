package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 18/03/2026 17:31:48
 *
 */

public class P3070 {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(countSubmatricesV2(mat, 15));
    }

    public static int countSubmatrices(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] sum = new int[n+1][m+1];

        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                sum[r+1][c+1] = sum[r+1][c] + sum[r][c+1] - sum[r][c] + grid[r][c];
                if (sum[r+1][c+1] <= k) {
                    ans++;
                }
            }
        }

        return ans;

    }

    public static int countSubmatricesV2(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowSum = new int[m+1];

        int ans = 0;
        for (int r = 0; r < n; r++) {
            int s = 0;
            for (int c = 0; c < m; c++) {
                rowSum[c] += grid[r][c];
                s += rowSum[c];
                if (s > k) break;
                ans++;
            }
        }

        return ans;
    }
}
