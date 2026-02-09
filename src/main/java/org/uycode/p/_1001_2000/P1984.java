package org.uycode.p._1001_2000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/01/2026 11:53:46
 *
 */

public class P1984 {

    public static void main(String[] args) {

        int[] arr = {87063,61094,44530,21297,95857,93551,9918};
        System.out.println(minimumDifference(arr, 6));
    }

    public static int minimumDifference(int[] nums, int k) {

        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);

        for (int i = 0; i <= n -k; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }

        return ans;
    }
}
