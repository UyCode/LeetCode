package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 15:34:38
 *
 */

public class P1523 {

    public static void main(String[] args) {
        System.out.println(countOdds(9, 11));
    }

    public static int countOdds(int low, int high) {

        int range = high - low + 1;
        if (range % 2 == 0) return range / 2;

        if (high % 2 == 0) return range / 2;

        return range / 2 + 1;
    }
}
