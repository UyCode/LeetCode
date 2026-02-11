package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 12:26:26
 *
 */

public class P3354 {

    public static void main(String[] args) {


    }

    public static int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int ans = 0;
        int pre = 0;
        for (int x : nums) {
            if (x > 0) {
                pre += x;
            } else {
                int diff = Math.abs(pre * 2 - total);
                ans += Math.max(2 - diff, 0);
            }
        }
        return ans;
    }
}
