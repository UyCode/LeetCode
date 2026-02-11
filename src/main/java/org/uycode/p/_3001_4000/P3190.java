package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 18:02:11
 *
 */

public class P3190 {

    public static void main(String[] args) {

        System.out.println(50 % 3);

        System.out.println(minimumOperations(new int[]{3, 6, 50}));
    }

    public static int minimumOperations(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            ans += Math.min(num % 3, 3 - num % 3);
        }

        return ans;
    }
}
