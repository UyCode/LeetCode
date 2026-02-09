package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 27/05/2025 12:26:53
 */

public class P2894 {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(12, 12));
    }

    public static int differenceOfSums(int n, int m) {


        if (m > n) {
            return n * (n+1) /2;
        }

        int sum = 0;
        for (int i = 1; i < m; i++) {
            sum += i;
        }
        sum -= m;
        for (int i = m+1; i <= n; i++) {
            if (i % m == 0) {
                sum -= i;
                continue;
            }
            sum += i;
        }

        return sum;

    }
}
