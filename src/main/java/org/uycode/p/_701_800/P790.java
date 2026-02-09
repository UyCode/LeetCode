package org.uycode.p._701_800;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/05/2025 10:46:03
 */

public class P790 {

    public static void main(String[] args) {
        System.out.println(numTilings(4));
    }

    public static int numTilings(int n) {

        if (n == 1) return 1;

        int mod = 1_000_000_007;
        long[] dp = new long[3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = (dp[2] * 2 + dp[0]) % mod;
            // dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % mod;
        }
        return (int)dp[2];
    }
}
