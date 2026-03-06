package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 01/03/2026 10:13:28
 *
 */

public class P1689 {

    public static void main(String[] args) {

    }

    public static int minPartitions(String n) {

        char[] nums = n.toCharArray();

        int max = nums[nums.length-1] - '0';
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] - '0' > max) max = nums[i] - '0';
        }


        return max;
    }
}
