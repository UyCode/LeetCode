package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/05/2025 16:50:03
 */

public class P3335 {

    public static void main(String[] args) {
        P3335 p3335 = new P3335();

        System.out.println(p3335.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }

    static final int ALPHABET = 26;
    static final int MOD = 1_000_000_007;
    static long[][] dp;
    public int lengthAfterTransformations(String s, int t) {

        prepareDP(t);
        long total = 0;

        for (char ch : s.toCharArray()) {
            total += (dp[ch - 'a'][t])  % MOD;
        }

        return (int) total; // if needed, use modulo
    }

    private void prepareDP( int t) {
        dp = new long[ALPHABET][100001];

        // Base case: 0 transformations = length 1
        for (int i = 0; i < ALPHABET; i++) {
            dp[i][0] = 1;
        }

        // For all transformations from 1 to t
        for (int k = 1; k <= t; k++) {
            for (int i = 0; i < ALPHABET; i++) {
                if (i == 25) {
                    // 'z' -> 'a' + 'b'
                    dp[i][k] = dp[0][k - 1] + dp[1][k - 1];
                } else {
                    // any other: just next char
                    dp[i][k] = dp[i + 1][k - 1];
                }
            }
        }
    }
}
