package org.uycode.p._3001_4000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/02/2026 10:31:35
 *
 */

public class P3634 {

    public static void main(String[] args) {
        int[] arr = {2,1,5};
        System.out.println(minRemoval(arr, 2));
    }

    public static int minRemoval(int[] nums, int k) {

        if (nums.length == 1) return 0;

        Arrays.sort(nums);

        int ans = 0;
        int l = 0;
        for (int j = 0; j < nums.length; j++) {
            while (nums[j] > k * nums[l]) {
                l++;
            }
            ans = Math.max(ans, j - l + 1);
        }
        return nums.length - ans;
    }


}
