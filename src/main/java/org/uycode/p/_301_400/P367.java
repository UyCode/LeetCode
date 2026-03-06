package org.uycode.p._301_400;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 11:50:36
 *
 */

public class P367 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }

    public static boolean isPerfectSquare(int n) {
        if (n < 0) return false;
        if (n == 0 || n == 1) return true;

        // 1. Quick Bitwise Filter
        // Perfect squares (mod 16) can only be 0, 1, 4, or 9
        int lastHexDigit = n & 0xF;
        if (lastHexDigit > 9) return false; // 10-15 are impossible
        if (lastHexDigit != 0 && lastHexDigit != 1 && lastHexDigit != 4 && lastHexDigit != 9) {
            return false;
        }

        // 2. Bitwise Integer Sqrt calculation
        int res = 0;
        int bit = 1 << 15; // Max possible bit for root of a 32-bit int

        while (bit > 0) {
            int temp = res + bit;
            // Use long to prevent overflow during comparison
            if ((long)temp * temp <= n) {
                res = temp;
            }
            bit >>= 1;
        }

        // 3. Final Verification
        return (long)res * res == n;
    }
}
