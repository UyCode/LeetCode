package org.uycode.p._101_200;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 26/05/2025 16:08:07
 */

public class P154 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,1,1}));
    }

    public static int findMin(int[] nums) {

        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return Math.min(nums[0], nums[1]);

        int j = 1;

        int res = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[j] && res > nums[i]) {
                res = nums[i];
            }
            if (nums[i] > nums[j] && res > nums[j]) {
                res = nums[j];
            }
            j++;
        }



        return res;
    }
}
