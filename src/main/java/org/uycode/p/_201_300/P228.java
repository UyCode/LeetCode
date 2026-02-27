package org.uycode.p._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 27/02/2026 16:26:02
 *
 */

public class P228 {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647,2147483647};
        List<String> ans = summaryRanges(nums);
        System.out.println(ans);
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int l = nums[i];
            int idx = i+1;
            while (idx < n && nums[idx] - nums[idx-1] == 1) {
                idx++;
            }
            int r = nums[idx-1];
            if (l == r) {
                ans.add("" + l);
            } else {
                ans.add(l + "->" + r);
            }
            i = idx-1;
        }


        return ans;
    }
}
