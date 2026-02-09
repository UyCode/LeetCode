package org.uycode.p._3001_4000;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 03/02/2026 12:46:15
 *
 */

public class P3314 {

    public static void main(String[] args) {
        List<Integer> arr = List.of(11, 13,31);
        System.out.println(Arrays.toString(minBitwiseArray(arr)));
    }

    public static int[] minBitwiseArray(List<Integer> nums) {

        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            int tmp = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j < cur; j++) {
                int res = j | (j+1);
                if (res == cur && res <= minVal) {
                    tmp = j;
                    minVal = j;
                }
            }
            ans[i] = tmp;
        }

        return ans;

    }
}
