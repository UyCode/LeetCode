package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 16:03:11
 *
 */

public class P3432 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(countPartitions(nums));
    }

    public static int countPartitions(int[] nums) {

        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        System.out.println(rightSum & 1);
        int ans = 0;
        int leftSum = 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i-1];
            rightSum -= nums[i-1];
            int diff = leftSum - rightSum;
            if (diff % 2 == 0) ans++;
        }

        return ans;
    }
}
