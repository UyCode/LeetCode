package org.uycode.p._1_100;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 17/05/2025 20:53:10
 */

public class P75 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {

        while (true) {
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i+1] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    count++;
                }
            }
            if (count == 0) break;
        }


    }
}
