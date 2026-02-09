package org.uycode.p._1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 17/01/2026 11:20:11
 *
 */

public class P15 {

    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length;

        // Sets up two-pointer sweep to find zero-sum triplets
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return result;

            if (i > 0 && nums[i] == nums[i-1]) continue;

            int L = i + 1;
            int R = n - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                // Finds distinct triplets summing to zero via two-pointer scan
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums [L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        return result;
    }
}
