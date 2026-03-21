package org.uycode.interviews;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 10:23:58
 *
 */

public class FindTop3 {

    public static void main(String[] args) {
        int[] nums = {1,10,3,12,5,6,7,8,9};
        System.out.println(Arrays.toString(findTop3(nums)));
    }

    public static int[] findTop3(int[] nums) {

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first ) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }

        return new int[]{first, second, third};

    }
}
