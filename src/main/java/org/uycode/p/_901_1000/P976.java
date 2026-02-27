package org.uycode.p._901_1000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 13:46:57
 *
 */

public class P976 {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1,1,2, 10}));
    }

    public static int largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        for (int i = nums.length-1; i >=2; i--) {
            int sum = nums[i-1] + nums[i-2];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
        }
        return 0;
    }
}
