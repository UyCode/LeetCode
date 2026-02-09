package org.uycode.p._2001_3000;

import java.util.Arrays;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/05/2025 21:50:17
 */

public class P2148 {


    public static void main(String[] args) {
        System.out.println(countElements(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public static int countElements(int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        while (start < nums.length-1) {
            if (nums[start] != nums[start+1]) break;
            start++;
        }

        int end = nums.length - 1;
        while (end > 1) {
            if (nums[end] != nums[end-1]) break;
            end--;
        }

        if (start > end) return 0;

        return end - start - 1;
    }
}
