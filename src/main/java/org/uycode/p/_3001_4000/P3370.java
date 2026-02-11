package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 12:07:01
 *
 */

public class P3370 {

    public static void main(String[] args) {
        System.out.println(smallestNumber(700));
    }

    public static int smallestNumber(int n) {

        int max = 1024;
        while (max > n) {
            max >>=1;
        }
        max <<= 1;
        return max -1;
    }
}
