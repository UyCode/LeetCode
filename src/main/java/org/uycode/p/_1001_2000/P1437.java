package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 10:28:00
 *
 */

public class P1437 {

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,1,0,1}, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {

        int cnt = k;
        for (int num : nums) {
            if (num == 0) {
                cnt++;
                continue;
            }
            if (cnt < k) return false;
            cnt = 0;
        }

        return true;
    }
}
