package org.uycode.p._701_800;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 21/02/2026 22:35:10
 *
 */

public class P762 {

    public static void main(String[] args) {

    }

    public static int countPrimeSetBits(int left, int right) {

        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                ans++;
            }
        }

        return ans;
    }

    private static boolean isPrime(int n) {
        // 1. Handle the basics
        if (n <= 1) return false;
        if (n <= 3) return true;

        // 2. Eliminate multiples of 2 and 3 immediately
        if (n % 2 == 0 || n % 3 == 0) return false;

        // 3. Check divisors starting from 5, skipping even numbers and multiples of 3
        // We increment by 6 (checking i and i + 2)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
