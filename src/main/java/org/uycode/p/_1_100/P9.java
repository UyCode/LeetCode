package org.uycode.p._1_100;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 02/03/2026 12:18:05
 *
 */

public class P9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x > 0 && x % 10 == 0) return false;

        int o = x;
        int p = x;
        int t = 1;
        while (x >= 10) {
            t *= 10;
            x /= 10;
        }

        long k = 0;
        while (p > 0) {
            k += (long) (p % 10) * t;
             p /= 10;
             t /= 10;
        }

        return o == k;


    }
}
