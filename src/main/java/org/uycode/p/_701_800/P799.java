package org.uycode.p._701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/02/2026 10:02:00
 *
 */

public class P799 {

    public static void main(String[] args) {
        System.out.println(champagneTower(25,6,1));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {

        double[][] f = new double[101][101];

        f[0][0] = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] >= 1) {
                    double rem = f[i][j] - 1;
                    f[i][j] = 1;
                    double next = rem / 2;
                    f[i+1][j] += next;
                    f[i+1][j+1] += next;
                }
            }
        }

        return f[query_row][query_glass];

    }
}
