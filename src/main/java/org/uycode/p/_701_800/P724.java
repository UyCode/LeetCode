package org.uycode.p._701_800;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/05/2025 15:25:09
 */

public class P724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,0,1}));
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;

    }
}
