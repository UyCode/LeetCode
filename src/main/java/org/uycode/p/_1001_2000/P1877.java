package org.uycode.p._1001_2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/01/2026 10:56:56
 *
 */

public class P1877 {

    public static void main(String[] args) {

        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(pair(nums));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxSum = nums[0] + nums[n-1];

        if (n > 2) {
            for (int i = 1; i < n-1; i++) {
                maxSum = Math.max(maxSum, nums[i] + nums[n-i-1]);
            }
        }

        return maxSum;
    }

    public static List<Integer> pair(int[] nums) {
        int n = nums.length;
        boolean[] pos = new boolean[n+1];

        for (int num : nums) {
            pos[num] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (!pos[i]) {
                ans.add(i);
            }
        }

        return ans;

    }
}
