package org.uycode.p._1001_2000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 04/03/2026 17:31:12
 *
 */

public class P1582 {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,1}, {0,0,0,0,1,0,0,0}, {1,0,0,0,1,0,0,0}, {0,0,1,1,0,0,0,0}};
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    int sum = 0;
                    int c = 0;
                    while (c < col) {
                        sum += mat[i][c];
                        c++;
                    }
                    if (sum > 1) break;
                    sum = 0;
                    int r = 0;
                    while (r < row) {
                        sum += mat[r][j];
                        r++;
                    }
                    if (sum > 1) break;
                    ans++;
                }
            }
        }

        return ans;
    }
}
