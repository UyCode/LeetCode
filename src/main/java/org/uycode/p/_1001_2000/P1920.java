package org.uycode.p._1001_2000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/05/2025 00:12:08
 */

public class P1920 {


    public static void main(String[] args) {
        int[] nums = {
                5,0,1,2,3,4
        };
        System.out.println(Arrays.toString(buildArray(nums)));
    }

    public static int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }


        return ans;

    }


}
