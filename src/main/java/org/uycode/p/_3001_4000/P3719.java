package org.uycode.p._3001_4000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 09:56:59
 *
 */

public class P3719 {

    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[]{10, 5, 7}));
    }


    public static int longestBalanced(int[] nums) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> vis = new HashSet<>();
            int[] cnt = new int[2];
            for (int j = i; j < n; ++j) {
                if (vis.add(nums[j])) {
                    ++cnt[nums[j] & 1];
                }
                if (cnt[0] == cnt[1]) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;


    }
}
