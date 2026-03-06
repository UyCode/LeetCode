package org.uycode.p._301_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 08:49:33
 *
 */

public class P349 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4,7,9,7,6,7}, new int[]{5,0,0,6,1,6,2,2,4})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>(nums1.length);

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> dup = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                dup.add(nums2[i]);
            }
        }

        int[] ans = new int[dup.size()];

        int idx = 0;
        for (int i : dup) {
            ans[idx++] = i;
        }

        return ans;
    }
}
