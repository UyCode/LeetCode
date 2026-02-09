package org.uycode.p._1001_2000;

import java.util.Map;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/01/2026 15:35:40
 *
 */

public class P1774 {

    public static void main(String[] args) {

        int[] a = {2,3};
        int[] b = {4,5,100};
        int t = 18;

        System.out.println(closestCost(a, b, t));

    }

    public static int closestCost(int[] baseCost, int[] toppingCost, int target) {
        boolean[] dp = new boolean[target + 1];
        int minCost = Integer.MAX_VALUE;

        for (int b: baseCost) {
            if (b > target) {
                minCost = Math.min(minCost, b);
            } else {
                dp[b] = true;
            }
        }

        for (int x : toppingCost) {
            for (int i = 0; i < 2; i++) {
                for (int j = target; j >=0; j--) {
                    if(dp[j] && j + x > target) {
                        minCost = Math.min(minCost, j + x);
                    }
                    if (j > x) {
                        dp[j] = dp[j] | dp[j - x];
                    }
                }
            }
        }

        for(int i = 0; i <= minCost - target && i <= target; i++) {
            if (dp[target - i]) return target - i;
        }

        return minCost;

    }
}
