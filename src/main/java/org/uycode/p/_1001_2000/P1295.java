package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 30/04/2025 13:55:34
 */

public class P1295 {

    public int findNumbers(int[] nums) {

        int ans = 0;
        int count;
        for (int num : nums) {
            count = 0;
            while (num > 0) {
                count++;
                num /= 10;
            }
            if (count % 2 == 0) ans++;
        }

        return ans;
    }
}
